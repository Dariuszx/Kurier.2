import exceptions.FileFormatException;

public class Main {

    public static void main( String[] args ) {

        //Tablica samochodów kurierskich
        Data<CourierCar> courierCars = new Array<CourierCar>();

        //Graf
        Map test = new Map();

        //Kolejka priorytetowa zleceń
        OrderQueue orderQueue = new OrderQueue();

        //Tablica kosztów dojść do wszystkich wierzchołków grafu
        Data<Dijkstry> dijkstryData = new ArrayDijkstry();


        try {
            new DataLoading(args).loadData( test, courierCars, orderQueue, dijkstryData );

            Static.mainCity = test.getCity(0);

            AssignOrders.assign( dijkstryData, courierCars, test, orderQueue );

            //WritingOnScreen.wypiszKolejke( orderQueue );
            WritingOnScreen.wypiszSamochody( courierCars );
            //WritingOnScreen.wypiszSciezke( courierCars );

           // Path path = new Path();
            //path.addPath( dijkstryData.get(0).returnPath( test.getCity(8) ) );
            //WritingOnScreen.wypiszSciezke( path );


        } catch ( FileFormatException e) {
            System.out.println(e.message);
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }

}
