package visualization;


import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import logic.CourierCar;
import logic.Data;
import logic.Map;
import org.apache.commons.collections15.Transformer;

import javax.swing.*;
import java.awt.*;


public class AnimationGraph {

    private Map map;
    private Data<CourierCar> courierCars;
    private JFrame jframe;


    private int time = 0;

    public AnimationGraph(Map map, Data<CourierCar> courierCar) {

        this.map = map;
        this.courierCars = courierCar;

    }

    private VisualizationViewer<VertexLabel, Edge>  draw( ) {

        GraphView graphView = new GraphView( map, courierCars );
        Layout<VertexLabel, Edge> layout = new KKLayout( graphView.refresh( time ) );


        layout.setSize(new Dimension(1624, 1624));
        VisualizationViewer<VertexLabel, Edge> vv = new VisualizationViewer<VertexLabel, Edge>(layout);


        Transformer<VertexLabel,Paint> vertexPaint = new Transformer<VertexLabel, Paint>() {
            @Override
            public Paint transform(VertexLabel i) {
                if ( i.getCourierCars().size() != 0 )
                    return (Paint) Color.GREEN;
                else
                    return  (Paint) Color.RED;
            }
        };

        vv.getRenderContext().setVertexFillPaintTransformer( vertexPaint );

        vv.setPreferredSize(new Dimension(1024, 768));

        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());

        DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
        gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
        vv.setGraphMouse(gm);

        return vv;
    }

    public void run() {


        jframe = new JFrame("Widok grafu");

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jframe.getContentPane().add( draw() );

        jframe.pack();
        jframe.setVisible(true);
    }

}
