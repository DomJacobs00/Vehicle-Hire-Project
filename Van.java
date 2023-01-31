import java.util.*;

/**
 * Write a description of class Van here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Van extends Commercial
{
    private double loadVolume;
    private boolean slidingSideDoor;
    public Van()
    {
    }
    public void setLoadVolume(double loadVolume)
    {
        this.loadVolume = loadVolume;
    }
    public double getLoadVolume()
    {
        return loadVolume;
    }
    public void setSlidingsideDoor (boolean slidingSideDoor)
    {
        this.slidingSideDoor = slidingSideDoor;
    }
    public boolean getSlidingSideDoor()
    {
        return slidingSideDoor;
    }
    public String getSlidingDoor()
    {
        String bool;
        if(slidingSideDoor == true)
        {
            bool =  "Yes";
        }
        else
        {
            bool = "No";
        }
        return bool;
        
    }
    public void readData(Scanner scanner2)
    {
        super.readData(scanner2);
        String tempLoadVolume = scanner2.next().trim();
        loadVolume = Double.parseDouble(tempLoadVolume);
        String tempSlidingDoor = scanner2.next().trim();
        if(tempSlidingDoor.equals("Yes"))
        {
            slidingSideDoor = true;
        }
        else
        {
            slidingSideDoor = false;
        }
        
        
    }
    public void showData()
    {
        super.printDetails();
        System.out.println("Load Compartment Volume in m3: " + loadVolume + " Sliding Door: " + getSlidingDoor());
        
    }
    public String toString()
    {
        return super.toString() + "," + loadVolume + "," + slidingSideDoor;
    }

}
