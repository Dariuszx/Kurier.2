package visualisation;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.picking.PickedInfo;
import logic.*;
import org.apache.commons.collections15.Transformer;

import java.awt.*;


class Edge {

    private int weight;
    private City a;
    private City b;

    public Edge( City a, City b, int weight ) {
        this.weight = weight;
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return weight + "";
    }

    @Override
    public boolean equals( Object obj ) {

        if( obj instanceof Edge ) {

            Edge tmp = ((Edge)obj);

            if( (tmp.a.equals( a ) && tmp.b.equals( b )) || tmp.a.equals( b ) && tmp.b.equals( a ) ) {
                return true;
            }
        }
        return false;
    }
}

public class GraphView {

    private Map map;
    private Data<CourierCar> courierCars;
    private Data<VertexLabel> nodeList;
    private Data<Edge> edgeList;



    public GraphView( Map map, Data<CourierCar> courierCars ) {
        this.map = map;
        this.courierCars = courierCars;
        this.nodeList = new Array<VertexLabel>();
        this.edgeList = new Array<Edge>();
    }

    public Graph<VertexLabel, Edge> refresh( int time ) {

        Graph<VertexLabel, Edge> graph = new SparseMultigraph<VertexLabel, Edge>();

        for( int i=0; i < map.getSize(); i++ ) {

            nodeList.add( new VertexLabel( map.getCity(i), time ) );
        }

        //iteruje przez samochody kurierskie
        for( int i=0; i < courierCars.size(); i++ ) {
            CourierCar courierCar = courierCars.get(i);

            for( int j=1; j < courierCar.getPath().getPath_list().size(); j++ ) {

                PathElement element = courierCar.getPath().getPath_list().get(j);
                if( time < element.getTime() ) {
                    PathElement prev = courierCar.getPath().getPath_list().get(j-1);
                    nodeList.get( map.getCityIndex( prev.getCity() ) ).addCourierCar( courierCar );
                    break;
                }
            }
        }


        for( int i=0; i < map.getSize(); i++ ){

            City city = map.getCity(i);

            for( int j=0; j < city.getNeighbourList().size(); j++ ) {

                Neighbour neighbour = city.getNeighbourList().get(j);

                Edge tmp = new Edge( city, neighbour.getCity(), neighbour.getWeight() );

                if( edgeList.get( tmp ) == null ) {
                    edgeList.add( tmp );
                    graph.addEdge( tmp, nodeList.get(map.getCityIndex(city)), nodeList.get(map.getCityIndex(neighbour.getCity())));
                }
            }
        }

        return graph;
    }

    public VertexLabel getVertexLabel( int i ) {
        return nodeList.get(i);
    }

}
