package gspelling;

/**
 * TODO improve docs
 * 
 * @author Otávio Scherer Garcia
 * @version $Revision$
 */
public class GSpellingException
    extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 4210348840420615917L;

    public GSpellingException() {
        super();
    }

    public GSpellingException(String message, Throwable cause) {
        super(message, cause);
    }

    public GSpellingException(String message) {
        super(message);
    }

    public GSpellingException(Throwable cause) {
        super(cause);
    }
}
