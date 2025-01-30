package woof.exception;

public class MarkedErrorException extends Exception {
    public MarkedErrorException() {
        super("WERWER! It seems like you are trying to mark a task that you have already completed!");
    }
}
