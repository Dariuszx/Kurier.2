package exceptions;

public class FileFormatException extends Exception {

    public String message;

    public FileFormatException( String message ) {
        this.message = message;
    }
}
