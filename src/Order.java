
public class Order {

    private String name;
    private int priority;
    private City source;
    private City destination;

    public Order(String name, int priority, City source, City destination) {
        this.name = name;
        this.priority = priority;
        this.source = source;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public City getSource() {
        return source;
    }

    public City getDestination() {
        return destination;
    }

    public int getPriority() {
        return priority;
    }
}
