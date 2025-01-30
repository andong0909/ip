package woof.exception;

public class UnmarkedErrorException extends Exception {
    public UnmarkedErrorException() {
        super("WERWER! It seems like you are trying to unmark a task that you have not completed!");
    }
}
