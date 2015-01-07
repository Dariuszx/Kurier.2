package logic;

public class PathElement {

    private City city;
    private int time;
    private Data<Order> get_list;
    private Data<Order> put_list;

    public PathElement( City city ) {

        this.city = city;
        this.get_list = new Array<Order>();
        this.put_list = new Array<Order>();
    }

    public City getCity() {
        return city;
    }

    public Data<Order> getPut_list() {
        return put_list;
    }

    public Data<Order> getGet_list() {
        return get_list;
    }

    public void add_to_get_list( Order order ) {
        this.get_list.add( order );
    }

    public void add_to_put_list( Order order ) {
        this.put_list.add( order );
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
