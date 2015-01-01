public class Path {

    private Data<PathElement> path_list;

    public Path() {
        path_list = new Array<PathElement>();
    }

    public boolean addOrder( Order order ) {

        PathElement source = null;
        PathElement destination = null;

        int i = path_list.size();


        while( i-- != 0 ) {

            PathElement tmp = path_list.get( i );

            if( tmp.getCity().equals( order.getSource() ) ) {
                source = tmp;
            } else if ( tmp.getCity().equals( order.getDestination() ) ) {
                destination = tmp;
            }

            if( tmp.getCity().equals( Static.mainCity ) ) break;
        }

        if( source != null && destination != null ) {
            source.add_to_get_list( order );
            destination.add_to_put_list( order );

            return true;
        }

        return false;
    }

    public void addPath( Data<City> path ) {

        for( int i=0; i < path.size(); i++ ) {

            path_list.add( new PathElement( path.get(i) ) );
        }
    }

    public void addPath( Path path ) {

        for( int i=0; i < path.getPath_list().size(); i++ ) {
            //if( i == 0 && path_list.size() != 0 && path_list.get( path_list.size() - 1).equals( path.getPath_list().get(i) ) ) continue;
            path_list.add( path.getPath_list().get(i) );
        }

    }

    public void addPath( City city ) {
        path_list.add( new PathElement( city ) );
    }

    public Data<PathElement> getPath_list() {
        return path_list;
    }

    public City getCity( City city ) {

        for( int i=0; i < path_list.size(); i++ ) {

            if( path_list.get(i).getCity().equals( city ) ) return city;
        }

        return null;
    }

    public void reverse() {

        for ( int i=0; i < path_list.size(); i++ ) {

            PathElement tmp = path_list.get( path_list.size() - 1 - i );

            path_list.set( path_list.size() - 1 - i, path_list.get(i) );

            path_list.set( i, tmp );

        }

        WritingOnScreen.wypiszSciezke( this );
    }

}
