
public class Queue<T> {

    private T value;
    private Queue<T> next;

    public Queue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Queue<T> getNext() {
        return next;
    }

    public void setNext(Queue<T> next) {
        this.next = next;
    }

    public int getPriority() {
        return value instanceof Order ? ((Order) value).getPriority() : 0;
    }
}
