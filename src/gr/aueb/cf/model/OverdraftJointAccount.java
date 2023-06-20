package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.InsufficientAmountException;
import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.SsnNotValidException;

/**
 * The {@code OverdraftJointAccount} class represents a joint bank account
 * which allows overdraft, i.e., the account's balance can go negative.
 * This class extends the {@code JointAccount} class and overrides the withdraw method
 * to remove the balance check, thereby allowing an overdraft.
 *
 * @author Ntirintis John
 */
public class OverdraftJointAccount extends JointAccount{

    /**
     * Default constructor initializing an empty overdraft joint account.
     */
    public OverdraftJointAccount() {}

    /**
     * Overloaded constructor initializing an overdraft joint account with a first holder, IBAN, initial balance and second holder.
     *
     * @param holder the first user who holds the account
     * @param iban the international bank account number of the account
     * @param balance the initial balance of the account
     * @param secondHolder the second user who holds the account
     */
    public OverdraftJointAccount(User holder, String iban, double balance, User secondHolder) {
        super(holder, iban, balance, secondHolder);
    }

    /**
     * Withdraws a given amount from the joint bank account if the holder's social security number (SSN)
     * matches the one given. Unlike the parent {@code JointAccount} class, it allows the balance to go negative (overdraft).
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
            if (amount < 0) throw new InsufficientAmountException(amount);
            if (!isSsnValid(ssn)) throw new SsnNotValidException(ssn);

            setBalance(getBalance() - amount);
        } catch (SsnNotValidException | InsufficientAmountException e) {
            // Would be better to have more catch statements and have exception specific err messages
            System.err.println("Error: withdrawal");
            throw e;
        }
    }
}
