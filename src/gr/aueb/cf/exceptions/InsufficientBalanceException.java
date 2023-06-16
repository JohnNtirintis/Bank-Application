package gr.aueb.cf.exceptions;

/**
 * @author Ntirintis John
 */
public class InsufficientBalanceException extends Exception {
    // For the sake of simplicity for this example
    // we will use a simple num
    // But this should have been very long and unique
    private static final long serialVersionUID = 1234L;

    public InsufficientBalanceException() {}

    public InsufficientBalanceException(double balance, double amount) {
        super("Insufficient Balance " + balance + " for amount " + amount);
    }
}
