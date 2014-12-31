package exceptions;


public class OutOfRange extends Exception {

    private String message = "";

    public OutOfRange() { }

    public OutOfRange( String message ) {

        this.message = message;
    }

    public String getMessage() {
        return "Przekroczono dopuszczalny zakres listy. " + message;
    }

}
