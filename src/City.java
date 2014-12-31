
public class City {

    private String name;
    private Data<Neighbour> neighbourList;

    public City( String name ) {

        this.name = name;
        this.neighbourList = new Array<Neighbour>();
    }

    public void setNeighbour( City city, int weight ) {
        neighbourList.add( new Neighbour( city, weight ) );
    }

    public int getWeight( City city ) {

        for( int i=0; i < neighbourList.size(); i++ ) {

            if( neighbourList.get(i).getCity().equals( city ) ) {
                return neighbourList.get(i).getWeight();
            }
        }

        return 0;
    }

    public String getName() {
        return name;
    }

    public Data<Neighbour> getNeighbourList() {
        return neighbourList;
    }

    @Override
    public int hashCode() {

        String hash = this.name;

        for( int i=0; i < this.neighbourList.size(); i++ ) {
            hash += "" + this.neighbourList.get(i).getCity().name;
        }
        return hash.hashCode();
    }

    @Override
    public boolean equals( Object obj ) {

        if( obj instanceof City && obj.hashCode() == this.hashCode() ) {
            return true;
        }
        return false;
    }

}
