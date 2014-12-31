
public class Neighbour {

    private City city;
    private int weight;

    public Neighbour( City city, int weight ) {

        this.city = city;
        this.weight = weight;
    }

    public City getCity() {
        return city;
    }

    public int getWeight() {
        return weight;
    }
}
