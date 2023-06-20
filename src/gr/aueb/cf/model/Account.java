package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.InsufficientAmountException;
import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.SsnNotValidException;

/**
 * The {@code Account} class represents a bank account belonging to a user,
 * identified by a unique International Bank Account Number (IBAN).
 * It provides methods for depositing and withdrawing money from the account.
 *
 * @author Ntirintis John
 */
public class Account extends IdentifiableEntity {
    private User holder = new User();
    private String iban;
    private double balance;

    /**
     * Default constructor initializing an empty account with a new User holder.
     */
    public Account() {}

    /**
     * Overloaded constructor initializing an account with a holder, IBAN and initial balance.
     *
     * @param holder the user who holds the account
     * @param iban the international bank account number of the account
     * @param balance the initial balance of the account
     */
    public Account(User holder, String iban, double balance) {
        this.holder = holder;
        this.iban = iban;
        this.balance = balance;
    }

    // Getters / Setters
    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Returns a string representation of the account
    @Override
    public String toString() {
        return "Account{" +
                "holder=" + holder.toString() +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }

    // Public API


    /**
     * Deposits a given amount to the bank account
     *
     * @param amount amount to be deposited
     * @throws InsufficientAmountException if amount is zero or negative
     */
    public void deposit(double amount) throws InsufficientAmountException {
        try {
            if(amount <= 0){
                throw new InsufficientAmountException(amount);
            }

            balance += amount;
        } catch (InsufficientAmountException e) {
            System.err.println("Error: Negative or Zero Amount");
            throw e;
        }
    }

    /**
     * Withdraws a given amount from the bank account if the holder's social security number (SSN)
     * matches the one given and the balance is sufficient.
     *
     * @param amount the amount to be withdrawn
     * @param ssn the social security number of the account holder
     * @throws InsufficientBalanceException if the amount is greater than the current balance
     * @throws SsnNotValidException if the social security number doesn't match the holder's SSN
     * @throws InsufficientAmountException if the amount is zero or negative
     */
    public void withdraw(double amount, String ssn)
            throws InsufficientBalanceException, SsnNotValidException, InsufficientAmountException {
        try {
            if(amount <= 0) throw new InsufficientAmountException(amount);
            if(amount > balance) throw new InsufficientBalanceException(getBalance(), amount);
            if(!isSsnValid(ssn)) throw new SsnNotValidException(ssn);

            balance -= amount;

        } catch (InsufficientAmountException | InsufficientBalanceException | SsnNotValidException e){
            // Would be better to have more catch statements and have exception specific err messages
            System.err.println("Error: Withdrawal");
            throw e;
        }
    }

    /**
     * Checks if a given social security number (SSN) is the same as the account holder's.
     *
     * @param ssn the social security number to be checked
     * @return true if the given SSN matches the holder's, false otherwise
     */
    protected boolean isSsnValid(String ssn){
        if(ssn == null || getHolder().getSsn() == null) return false;

        // We dont use getHolder because we are in the same class
        return holder.getSsn().equals(ssn);
    }

}
