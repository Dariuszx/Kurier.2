package visualisation;


import logic.*;

public class VertexLabel {

    private Data<CourierCar> courierCars;
    private City city;
    private int time;

    public VertexLabel( City city, int time ) {
        this.courierCars = new Array<CourierCar>();
        this.city = city;
        this.time = time;
    }

    public void addCourierCar( CourierCar car ) {
        courierCars.add( car );
    }

    public City getCity() {
        return city;
    }

    public Data<CourierCar> getCourierCars() {
        return courierCars;
    }

    @Override
    public String toString() {

        String s = city.getName() + " ";

        for( int i=0; i < courierCars.size(); i++ ) {

            s += "Car[" + courierCars.get(i).getId() + "] ";
/*
            CourierCar car = courierCars.get(i);

            for( int j=0; j < car.getPath().getPath_list().size(); j++ ) {

                PathElement element = car.getPath().getPath_list().get(j);

                if( element.getCity().equals( city ) && element.getTime() <= time ) {

                    if( j != car.getPath().getPath_list().size()-1 && car.getPath().getPath_list().get(j+1).getTime() >= time ) {

                        for( int k=0; k < element.getGet_list().size(); k++ ) {
                            s += "+" + element.getGet_list().get(k).getName();
                        }

                        for( int k=0; k < element.getPut_list().size(); k++ ) {
                            s += "-" + element.getPut_list().get(k).getName();
                        }

                    } else if ( j == car.getPath().getPath_list().size()-1 ){

                        for( int k=0; k < element.getGet_list().size(); k++ ) {
                            s += "+" + element.getGet_list().get(k).getName();
                        }

                        for( int k=0; k < element.getPut_list().size(); k++ ) {
                            s += "-" + element.getPut_list().get(k).getName();
                        }
                    }

                }
            }
*/
            s+= " ";
        }

        return s;
    }

    @Override
    public boolean equals( Object obj ) {

        if( obj instanceof VertexLabel ) {
            if( ((VertexLabel)obj).getCity().equals( this.city ) ) return true;
        }

        return false;
    }

}
