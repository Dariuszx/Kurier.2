import java.util.ArrayList;

public class Array<T> implements Data<T> {

    private ArrayList<T> arrayList = new ArrayList<T>();

    public ArrayList<T> getArrayList() {
        return arrayList;
    }

    @Override
    public void add(T data) {
        arrayList.add(data);
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public T get(int index) {
        return arrayList.get(index);
    }

    @Override
    public T get(T data) {

        for( T obj : arrayList ) {
            if( obj.equals(data) ) return obj;
        }
        return null;
    }

    @Override
    public void set(int index, T data) {
        arrayList.set( index, data );
    }
}
