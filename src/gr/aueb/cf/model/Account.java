package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.InsufficientAmountException;
import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.SsnNotValidException;

import javax.net.ssl.SSLServerSocket;

/**
 * @author Ntirintis John
 */
public class Account extends IdentifiableEntity {
    private User holder = new User();
    private String iban;
    private double balance;

    public Account() {}

    // Overloaded Constructor
    public Account(User holder, String iban, double balance) {
        this.holder = holder;
        this.iban = iban;
        this.balance = balance;
    }

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
     *
     *
     * @param amount
     * @param ssn
     * @throws InsufficientBalanceException
     * @throws SsnNotValidException
     * @throws InsufficientAmountException
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

    protected boolean isSsnValid(String ssn){
        if(ssn == null || getHolder().getSsn() == null) return false;

        // We dont use getHolder because we are in the same class
        return holder.getSsn().equals(ssn);
    }

}
