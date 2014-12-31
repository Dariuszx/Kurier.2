
public class AssignOrders {

    //metoda przydziela zlecenia do kolejnych samochodów kurierskich
    public static void assign( Data<Dijkstry> dijkstryData, Data<CourierCar> courierCars, Map map, OrderQueue orderQueue ) {

        //Jeżeli zlecenia nieprzydzielone != 0
        while ( !orderQueue.empty() ) {

            //Przechodzę przez samochody kurierskie
            for( int i=0; i < courierCars.size(); i++ ) {

                CourierCar courierCar = courierCars.get( i ); //samochód kurierski
                Order order = orderQueue.front(); //pobieram pierwsze zlecenie z góry

                if ( order == null ) break;

                //Jeżeli zlecenie nie jest w mieście gdzie startuje samochód
                //Zapisuje ścieżke gdzie ma pojechać
                //Paczka jest zaadresowana z B->C
                if( !order.getSource().equals( courierCar.getLastCity() ) ) {

                    //Ścieżka z A -> B
                    Data<City> pathToCityB = dijkstryData.get( map.getCityIndex( courierCar.getLastCity() ) ).returnPath( order.getSource() );

                    //Ścieżka B -> C
                    Data<City> pathToCityC = dijkstryData.get( map.getCityIndex( order.getSource() )).returnPath( order.getDestination() );


                    //courierCar.addOrderToQueue( order, map.getCity( order.getIndexA() ) );
                    courierCar.addPath( pathToCityB );
                    courierCar.addPath( pathToCityC );
                    courierCar.addOrder( orderQueue.pop() );

                    orderQueue = OrderQueue.getOrdersByPath( orderQueue, pathToCityB, courierCar, map );
                    orderQueue = OrderQueue.getOrdersByPath( orderQueue, pathToCityC, courierCar, map );

                } else {
                    Data<City> pathToCityB = dijkstryData.get( map.getCityIndex( order.getSource() ) ).returnPath( order.getDestination() );
                    courierCar.addPath( pathToCityB );
                    orderQueue = OrderQueue.getOrdersByPath( orderQueue, pathToCityB, courierCar, map );
                }
            }
        }

    }
}
