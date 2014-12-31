
public class Map {

    private Data<City> cityList;

    public Map() {

        cityList = new Array<City>();
    }

    public void addCity( City city ) {
        cityList.add( city );
    }

    public City getCity( int index ) {
        return cityList.get( index );
    }

    public int getCityIndex( City city ) {

        for( int i=0; i < cityList.size(); i++ ) {
            if( cityList.get(i).equals( city ) ) return i;
        }

        return -1;
    }

    public void setNeighbour( int indexA, int indexB, int weight ) {

        cityList.get( indexA ).setNeighbour( cityList.get( indexB ), weight );
        cityList.get( indexB ).setNeighbour( cityList.get( indexA ), weight );
    }

    public int getSize() {
        return cityList.size();
    }

}
