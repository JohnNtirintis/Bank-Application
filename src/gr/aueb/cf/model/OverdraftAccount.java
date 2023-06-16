package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.InsufficientAmountException;
import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.SsnNotValidException;

/**
 *
 * @author Ntirintis John
 */
public class OverdraftAccount extends Account {

    public OverdraftAccount() {}

    public OverdraftAccount(User holder, String iban, double balance) {
        super(holder, iban, balance);
    }

    @Override
    public void withdraw(double amount, String ssn)
            throws SsnNotValidException, InsufficientAmountException {
        try {
            if(amount <= 0) throw new InsufficientAmountException(amount);
            if(!isSsnValid(ssn)) throw new SsnNotValidException(ssn);

            setBalance(getBalance() - amount);

        } catch (InsufficientAmountException | SsnNotValidException e){
            // Would be better to have more catch statements and have exception specific err messages
            System.err.println("Error: Withdrawal");
            throw e;
        }
    }


}
