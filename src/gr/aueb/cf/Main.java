package gr.aueb.cf;

import gr.aueb.cf.exceptions.InsufficientAmountException;
import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.SsnNotValidException;
import gr.aueb.cf.model.Account;
import gr.aueb.cf.model.OverdraftAccount;
import gr.aueb.cf.model.OverdraftJointAccount;
import gr.aueb.cf.model.User;

/**
 * The {@code Main} class demonstrates the functionality of Account, OverdraftAccount,
 * and OverdraftJointAccount by simulating deposit and withdrawal operations.
 *
 * @author Ntirintis John
 */
public class Main {
    public static void main(String[] args) {
        User john = new User("John", "N.", "2424");
        User michael =  new User("Michael", "W. ", "1234");

        Account acc = new Account(john, "GR2424", 100);
        Account overJohn = new OverdraftAccount(john, "GR2424", 50);
        Account overJointAccount = new OverdraftJointAccount(john, "GR2424", 200, michael);
        try {
            // .toString has been override so there is no need to call it
            System.out.println("Account: \n" + acc);
            System.out.println("Overdraft: \n" + overJohn);

            overJointAccount.deposit(100);
            overJointAccount.withdraw(50, "2424");
            System.out.println("Overdraft joint account: \n" + overJointAccount);
        } catch (InsufficientAmountException | InsufficientBalanceException | SsnNotValidException e){
            System.out.println(e.getMessage());
        }
    }
}
