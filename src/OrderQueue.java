
public class OrderQueue {

    private Queue<Order> head;
    private Queue<Order> tail;


    public OrderQueue() {
        head = tail = null;
    }

    public void push( Order o ) {

        Queue order = new Queue<Order>( o );

        if( head == null ) {
            head = tail = order;
        }
        else if ( head.getPriority() < order.getPriority() ) {
            order.setNext( head );
            head = order;
        }
        else {
            Queue tmp = head;

            while( (tmp.getNext() != null) && (tmp.getNext().getPriority() >= order.getPriority() ) ) {
                tmp = tmp.getNext();
            }

            order.setNext( tmp.getNext() );
            tmp.setNext( order );

            if( order.getNext() == null ) tail = order;
        }
    }

    public Order pop() {

        if( head != null ) {
            Queue<Order> tmp = head;
            head = head.getNext();

            if( head == null ) tail = null;
            return tmp.getValue();
        }
        return null;
    }

    public boolean empty() {
        return head == null;
    }

    public Order front() {

        if( head != null ) return head.getValue();
        else return null;
        
    }

    public static OrderQueue getOrdersByPath( Order order, OrderQueue orderQueue, Path path, int maxOrders ) {

        OrderQueue tmp = new OrderQueue();
        int ordersAdded = 1;

        WritingOnScreen.wypiszSciezke( path );

        path.addOrder( order );

        while ( !orderQueue.empty() ) {

            Order orderTmp = orderQueue.pop();

            //Sprawdzam czy mogę po drodze zabrać przesyłkę i ją dostarczyć gdzieś
            if( ordersAdded < maxOrders && path.getCity( orderTmp.getSource() ) != null && path.getCity( orderTmp.getDestination() ) != null )
            {
                ordersAdded++;
                path.addOrder( orderTmp );
            }
            else
            {
                tmp.push( orderTmp );
            }
        }

        return tmp;
    }
}
