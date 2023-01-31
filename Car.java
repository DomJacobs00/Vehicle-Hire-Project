import java.util.Scanner;

/**
 *   Car class 
 * @author (Dominykas Jokubauskas AGE491)
 */
public class Car extends Vehicle
{
    // instance variables - replace the example below with your own
    private String bodyType;
    private int numberOfDoors;
    private int numberOfSeats;
    public Car()
    {
   
    }
    /** accessor and mutator methods */
    public String getBodyType()
    {
        return bodyType;
    }
    public void setBodyType(String bodyType)
    {
        this.bodyType = bodyType;
    }
    public int getNumberOfDoors()
    {
        return numberOfDoors;
    }
    public void setNumberOfDoors(int numberOfDoors)
    {
        this.numberOfDoors = numberOfDoors;
    }
    public int getNumberOfSeats()
    {
        return numberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats)
    {
        this.numberOfSeats = numberOfSeats;
    }
    public void readData(Scanner scanner2)
    {
        /* Pass the scanner 2 here for scanning the data for car specifically and importing set methods of vehicle then in
         * vehicle readData method add this read data and initialisation of car and other vehicles needed?
         */
        super.readData(scanner2);
        bodyType = scanner2.next().trim();
        String tempNumberOfDoors =  scanner2.next().trim();
        numberOfDoors = Integer.parseInt(tempNumberOfDoors);
        String tempNumberOfSeats = scanner2.next().trim();
        numberOfSeats = Integer.parseInt(tempNumberOfSeats);
        
        
        
    }
    public void showData()
    {
        super.printDetails();
        System.out.println("Body type: " + bodyType + " Number of doors: " + numberOfDoors + " Number of Seats: " + numberOfSeats );
        
    }
    public String toString()
    {
        return super.toString() + ", "+ bodyType + "," + numberOfDoors + "," + numberOfSeats; 
    }
    
}
