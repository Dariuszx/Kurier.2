package logic;

public class Dijkstry {

    public int[] d, p;
    private boolean[] QS;

    private City cityA;

    private Map Q, S;

    public Dijkstry(Map Q, City cityA) {

        this.S = new Map();
        this.Q = Q;
        this.cityA = cityA;


        d = setArray( Q.getSize(), 99999999 );
        p = setArray( Q.getSize(), -1 );
        QS = setQSArray( Q.getSize(), false );

        d[ Q.getCityIndex(cityA) ] = 0;


        for( int i=0; i < Q.getSize(); i++ ) {

            City tmp = returnSmallestWeight();
            browseNeighbours( tmp );

        }
    }

    public void browseNeighbours( City city ) {

        Data<Neighbour> list = city.getNeighbourList();

        for( int i=0; i < list.size(); i++ ) {

            int index = Q.getCityIndex( list.get(i).getCity() );
            int weight = list.get(i).getWeight();

            if( d[index] > d[ Q.getCityIndex( city ) ] + weight) {
                d[index] = d[ Q.getCityIndex( city ) ] + weight;
                p[index] = Q.getCityIndex( city );
            }
        }
    }

    public City returnSmallestWeight() {

        City tmp = cityA;

        int distance = 999999999;

        for( int i=0; i < Q.getSize(); i++ ) {

            if( d[i] < distance && QS[ i ] != true ) {
                distance = d[i];
                tmp = Q.getCity( i );
            }
        }

        S.addCity( tmp );

        QS[ Q.getCityIndex( tmp ) ] = true;

        return tmp;

    }

    public static int[] setArray( int n, int value ) {

        int[] array = new int[n];

        for( int i=0; i<n; i++ )
            array[i] = value;

        return array;
    }

    public static boolean[] setQSArray( int n, boolean value ) {

        boolean[] array = new boolean[n];

        for( int i=0; i < n; i++ )
            array[i] = value;

        return array;
    }

    public Data<City> returnPath( City cityB ) {

        Data<City> path = new Array<City>();

        int index = Q.getCityIndex( cityB );

        while( index != -1 ) {
            path.add( Q.getCity( index ));
            index = p[index];
        }

        return path;
    }
}
