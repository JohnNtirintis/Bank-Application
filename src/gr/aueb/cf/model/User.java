package gr.aueb.cf.model;

/**
 *
 *
 * @author Ntirintis John
 */
public class User extends IdentifiableEntity {
    private String firstName;
    private String lastName;
    private String ssn;

    // Default Constructor
    public User() {}

    // Overloaded Constructor
    public User(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    // Copy Constructor
    public User(User user){
        firstName = user.getFirstName();
        lastName = user.getLastName();
        ssn = user.getSsn();
    }

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

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
