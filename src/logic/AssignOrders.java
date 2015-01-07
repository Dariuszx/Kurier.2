package logic;

public class AssignOrders {

    //metoda przydziela zlecenia do kolejnych samochodów kurierskich
    public static void assign( Data<Dijkstry> dijkstryData, Data<CourierCar> courierCars, Map map, OrderQueue orderQueue ) {

        //Jeżeli zlecenia nieprzydzielone != 0
        while ( !orderQueue.empty() ) {

            //Przechodzę przez samochody kurierskie
            for( int i=0; i < courierCars.size(); i++ ) {

                CourierCar courierCar = courierCars.get( i ); //samochód kurierski
                Order order = orderQueue.front(); //pobieram pierwsze zlecenie z góry
                Path path = new Path();

                if ( order == null ) break;



                //Jeżeli zlecenie nie jest w mieście gdzie startuje samochód
                //Zapisuje ścieżke gdzie ma pojechać
                //Paczka jest zaadresowana z B->C
                if( !order.getSource().equals( courierCar.getLastCity() ) ) {

                    //Ścieżka z A -> B
                    Data<City> pathToCityB = dijkstryData.get( map.getCityIndex( order.getSource() ) ).returnPath( courierCar.getLastCity() );

                    //Ścieżka B -> C
                    Data<City> pathToCityC = dijkstryData.get( map.getCityIndex( order.getDestination() )).returnPath( order.getSource() );

                    path.addPath( pathToCityB );

                    path.addPath( pathToCityC );

                    //visualisation.WritingOnScreen.wypiszSciezke( path );

                } else {

                    Data<City> pathToCityB = dijkstryData.get( map.getCityIndex( order.getDestination() ) ).returnPath( order.getSource() );

                    path.addPath( pathToCityB );

                }

                orderQueue = OrderQueue.getOrdersByPath( orderQueue.pop(), orderQueue, path, courierCar.getMaxOrders() );
                courierCar.getPath().addPath( path );
            }
        }

    }

    public static void assignTime( Data<CourierCar> courierCars ) {

        for ( int i=0; i < courierCars.size(); i++ ) {

            CourierCar courierCar = courierCars.get(i);

            Data<PathElement> path = courierCar.getPath().getPath_list();


            if( path.size() == 0 ) return;

            PathElement prev = path.get(0);
            PathElement curr;

            int time = 0;

            for( int j=1; j < path.size(); j++ ) {

                curr = path.get(j);

                Neighbour tmp = curr.getCity().getNeighbour( prev.getCity() );

                if( tmp != null ) {
                    time += tmp.getWeight();
                }

                curr.setTime( time );
                prev = curr;
            }

        }

    }
}
