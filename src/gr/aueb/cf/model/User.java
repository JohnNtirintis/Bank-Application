package gr.aueb.cf.model;

/**
 * The {@code User} class represents a user or a holder of a bank account.
 * A user is identifiable by a social security number (SSN) and has a first name and a last name.
 * The User class extends IdentifiableEntity to include a unique ID.
 *
 * @author Ntirintis John
 */
public class User extends IdentifiableEntity {
    private String firstName;
    private String lastName;
    private String ssn;

    /**
     * Default constructor initializing an empty user.
     */
    public User() {}

    /**
     * Overloaded constructor initializing a user with first name, last name, and social security number.
     *
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param ssn the social security number of the user
     */
    public User(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    /**
     * Copy constructor creating a new user that is a copy of the user provided.
     *
     * @param user the user to be copied
     */
    public User(User user){
        firstName = user.getFirstName();
        lastName = user.getLastName();
        ssn = user.getSsn();
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * Returns a string representation of the user.
     * The returned string includes the user's first name, last name, and social security number.
     *
     * @return a string representation of the user
     */
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
