import java.util.*;


public class Truck extends Commercial
{
    private String features;
    public Truck()
    {
    }
    public void setFeatures(String features)
    {
        this.features = features;
    }
    public String getFeatures()
    {
        return features;
    }
    public void readData(Scanner scanner2)
    {
        super.readData(scanner2);
        features = scanner2.next().trim();        
    }
    public void showData()
    {
        super.showData();
        System.out.println("Additional features: " + features);
    }
    public String toString()
    {
        return super.toString() + "," + features ;
    }
}
