package visualisation;
/*

for ( int i=0; i < data.size(); i++ ) {

}

 */


import logic.*;

public class WritingOnScreen {


    public static void wypiszSamochody( Data<CourierCar> data ) {

        for ( int i=0; i < data.size(); i++ ) {

            CourierCar car = data.get(i);

            System.out.println( "ID=" + car.getId() );

            for( int j=0; j < car.getPath().getPath_list().size(); j++ ) {

                PathElement pathElement = car.getPath().getPath_list().get(j);

                System.out.println( "\t\t" + pathElement.getTime() + " " + pathElement.getCity().getName() );

                for( int k=0; k < pathElement.getGet_list().size(); k++ ) {
                    System.out.println( "\t\t\t ++ " + pathElement.getGet_list().get(k).getName() + " +" + pathElement.getGet_list().get(k).getSource().getName() + " -" + pathElement.getGet_list().get(k).getDestination().getName() );
                }

                for( int k=0; k < pathElement.getPut_list().size(); k++ ) {
                    System.out.println( "\t\t\t -- " + pathElement.getPut_list().get(k).getName() );
                }
            }
        }
    }

    public static void wypiszSciezke( Data<CourierCar> data ) {

        for ( int i=0; i < data.size(); i++ ) {

            Data<PathElement> list = data.get(i).getPath().getPath_list();
            System.out.println( "\n" + data.get(i).getId() );
            for( int j=0; j < list.size(); j++ ) {

                System.out.print( list.get(j).getCity().getName() + " -> ");
            }

        }
    }

    public static void wypiszKolejke( OrderQueue orderQueue ) {

        int i=0;

        while( !orderQueue.empty() ) {
            System.out.println( "i=" + i++ + " " + orderQueue.front().getName() + " : " + orderQueue.front().getPriority() );
            orderQueue.pop();
        }
    }

    public static void wypiszSciezke( Path path ) {

        System.out.println();

        for ( int i=0; i < path.getPath_list().size(); i++ ) {

            System.out.print( path.getPath_list().get(i).getCity().getName() + " -> ");
        }
    }

}
