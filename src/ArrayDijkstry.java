import java.util.ArrayList;

public class ArrayDijkstry implements Data<Dijkstry> {

    private ArrayList<Dijkstry> dijkstryArrayList = new ArrayList<Dijkstry>();


    public void generate( Map map ) {

        for( int i=0; i < map.getSize(); i++ ) {

            add( new Dijkstry( map, map.getCity(i) ) );

        }
    }

    @Override
    public void add(Dijkstry data) {

        dijkstryArrayList.add( data );
    }

    @Override
    public int size() {
        return dijkstryArrayList.size();
    }

    @Override
    public Dijkstry get(int index) {
        return dijkstryArrayList.get(index);
    }

    @Override
    public Dijkstry get(Dijkstry data) {
        return null;
    }

    @Override
    public void set(int index, Dijkstry city) {

    }
}
