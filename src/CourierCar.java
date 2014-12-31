
public class CourierCar {

    private int max_orders;
    private Path path;
    private int id;

    public CourierCar( City startCity, int id, int max_orders) {

        this.id = id;
        this.max_orders = max_orders;
        path = new Path();
        path.addPath( startCity );
    }

    public boolean addOrder( Order order ) {

        return this.path.addOrder( order );
    }

    public City getLastCity() {
        return path.getPath_list().get( path.getPath_list().size() ).getCity();
    }

    public int getMaxOrders() {
        return max_orders;
    }

    public void addPath( Data<City> path ) {
        this.path.addPath( path );
    }

}
