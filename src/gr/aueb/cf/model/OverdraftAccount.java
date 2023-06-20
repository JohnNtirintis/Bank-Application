package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.InsufficientAmountException;
import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.SsnNotValidException;

/**
 * The {@code OverdraftAccount} class represents a bank account
 * which allows overdraft, i.e., the account's balance can go negative.
 * This class extends the {@code Account} class and overrides the withdraw method
 * to remove the balance check, thereby allowing an overdraft.
 *
 * @author Ntirintis John
 */
public class OverdraftAccount extends Account {

    /**
     * Default constructor initializing an empty overdraft account.
     */
    public OverdraftAccount() {}

    /**
     * Overloaded constructor initializing an overdraft account with a holder, IBAN, and initial balance.
     *
     * @param holder the user who holds the account
     * @param iban the international bank account number of the account
     * @param balance the initial balance of the account
     */
    public OverdraftAccount(User holder, String iban, double balance) {
        super(holder, iban, balance);
    }

    /**
     * Withdraws a given amount from the bank account if the holder's social security number (SSN)
     * matches the one given. Unlike the parent {@code Account} class, it allows the balance to go negative (overdraft).
     *
     * @param amount the amount to be withdrawn
     * @param ssn the social security number of the account holder
     * @throws SsnNotValidException if the social security number doesn't match the holder's SSN
     * @throws InsufficientAmountException if the amount is zero or negative
     */
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
