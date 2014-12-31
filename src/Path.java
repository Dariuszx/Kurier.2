public class Path {

    private Data<PathElement> path_list;

    public Path() {
        path_list = new Array<PathElement>();
    }

    public boolean addOrder( Order order ) {

        PathElement source = null;
        PathElement destination = null;

        for( int i=0; i < path_list.size(); i++ ) {

            PathElement tmp = path_list.get( i );

            if( tmp.getCity().equals( order.getSource() ) ) {
                source = tmp;
            } else if ( tmp.getCity().equals( order.getDestination() ) ) {
                destination = tmp;
            }

        }

        if( source != null && destination != null ) {
            source.add_to_get_list( order );
            source.add_to_put_list( order );
            return true;
        }

        return false;
    }

    public void addPath( Data<City> path ) {

        for( int i=0; i < path.size(); i++ ) {

            path_list.add( new PathElement( path.get(i) ) );
        }
    }

    public void addPath( City city ) {
        path_list.add( new PathElement( city ) );
    }

    public Data<PathElement> getPath_list() {
        return path_list;
    }

}
