package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.InsufficientAmountException;
import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.SsnNotValidException;

/**
 * @author Ntirintis John
 */
public class OverdraftJointAccount extends JointAccount{

    public OverdraftJointAccount() {}

    public OverdraftJointAccount(User holder, String iban, double balance, User secondHolder) {
        super(holder, iban, balance, secondHolder);
    }

    @Override
    public void withdraw(double amount, String ssn)
            throws SsnNotValidException, InsufficientAmountException {
        try {
            if (amount < 0) throw new InsufficientAmountException(amount);
            if (!isSsnValid(ssn)) throw new SsnNotValidException(ssn);

            setBalance(getBalance() - amount);
        } catch (SsnNotValidException | InsufficientAmountException e) {
            // Would be better to have more catch statements and have exception specific err messages
            System.out.println("Error: withdrawal");
            throw e;
        }
    }
}
