import java.util.*;

/**
 * Write a description of class Commercial here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Commercial extends Vehicle
{
    private int payload;
    public Commercial()
    {
    }
    public int getPayload()
    {
        return payload;
    }
    public void setPayload(int payload)
    {
        this.payload = payload;
    }
    public void readData(Scanner scanner2)
    {
        super.readData(scanner2);
        String tempPayload = scanner2.next().trim();
        payload = Integer.parseInt(tempPayload);
    }
    public void showData()
    {
        super.printDetails();
        System.out.println("Payload: " + payload);
    }
    public String toString()
    {
        return super.toString() + " ," + payload;
    }
}
