package gr.aueb.cf.exceptions;

/**
 * @author Ntirintis John
 */
public class SsnNotValidException extends Exception {
    private static final long serialVersionUID = 1234L;

    public SsnNotValidException(String ssn) {
        super("Ssn" + ssn + " is not valid");
    }
}
