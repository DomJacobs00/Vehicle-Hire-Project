import java.util.*;

/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    private String customerID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;
    public Customer(String customerID)
    {
        customerID = "unknown";
        
    }
    public Customer()
    {
        
    }
    /** Accesor and mutator methods **/
    public String getCustomerID()
    {
        return customerID;
    }
    public void setCustomerID(String customerID)
    {
        this.customerID = customerID;
    }
    public String getSurname()
    {
        return surname;
    }
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getOtherInitials()
    {
        return otherInitials;
    }
    public void setOtherInitials(String otherInitials)
    {
        this.otherInitials= otherInitials;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    /** Other methods **/
    public void printDetails()
    {
        System.out.println("Customer ID: "+ customerID + ", Surname: " + surname + ", First Name: " + firstName + ",  Other initials: "+ otherInitials+ ", Title: "+title);
    }
    public void readData(Scanner scanner)
    {
        String delimiter = ",";
        scanner.useDelimiter(delimiter);
        customerID = scanner.next().trim();
        surname = scanner.next().trim();
        firstName = scanner.next().trim();
        otherInitials = scanner.next().trim();
        title = scanner.next().trim();
        
    }
    public String toString()
    {
        return surname  + "," + firstName  + "," + otherInitials  + "," + title;
    }

}
