

public interface Data<T> {

    public void add( T data );

    public int size();

    public T get( int index );

    public T get( T data );

    public void set( int index, T city );

}