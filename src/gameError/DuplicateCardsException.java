package gameError;

public class DuplicateCardsException extends Exception {
    private static final long serialVersionUID = 4L;

    public DuplicateCardsException(String message) {
        super(message);
    }
}