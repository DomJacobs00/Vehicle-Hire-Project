import java.util.*;

/**
 * Vehicle class made by Dominykas Jokubauskas AGE491
 */
public class Vehicle
{
    private String group;
    private String vehID;
    private String regNo;
    private String make;
    private String model;
    private boolean airCon;
    private double engineSize;
    private String fuelType;
    private String gearbox;
    private String transmission;
    private int mileage;
    private String dateFirstRegistered;

    public Vehicle()
    {
        
    }
    /**
     * Accessor and mutator methods
     */
    public String getGroup()
    {
        return group;
    }
    public void setGroup (String group)
    {
        this.group = group;
    }
    public String getVehID()
    {
        return vehID;
    }
    public void setVehID(String vehID)
    {
        this.vehID = vehID;
    }
    public String getRegNo()
    {
        return regNo;
    }
    public void setRegNo(String regNo)
    {
        this.regNo = regNo;
    }
    public String getMake()
    {
        return make;
    }
    public void setMake(String make)
    {
        this.make = make;
    }
    public String getModel()
    {
        return model;
    }
    public void setModel(String model)
    {
        this.model = model;
    }
    public boolean getAirCon()
    {
        return airCon;
    }
    public void setAirCon(boolean airCon)
    {
        this.airCon = airCon;
    }
    public String getAirConString()
    {
        String bool;
        if(airCon == true)
        {
            bool = "Yes";
        }
        else
        {
            bool = "No";
        }
        
        return bool;
    }
    public double getEngineSize()
    {
        return engineSize;
    }
    public void setEngineSize(double engineSize)
    {
        this.engineSize = engineSize;
    }
    public String getFuelType()
    {
        return fuelType;
    }
    public void setFuelType(String fuelType)
    {
        this.fuelType = fuelType;
    }
    public String getGearbox()
    {
        return gearbox;
    }
    public void setGearbox()
    {
        this.gearbox = gearbox;
    }
    public String getTransmission()
    {
        return transmission;
    }
    public void setTransmission(String transmission)
    {
        this.transmission = transmission;
    }
    public int getMileage()
    {
        return mileage;
    }
    public void setMileage(int mileage)
    {
        this.mileage = mileage;
    }
    public String getDateFirstRegistered()
    {
        return dateFirstRegistered;
    }
    public void setDateFirstRegistered(String dateFirstRegistered)
    {
        this.dateFirstRegistered = dateFirstRegistered;
    }
    public void printDetails()
    {
        //System.out.println("Group: " + group + " Vehicle Id: " + vehID + " Reg No: " + regNo + " Make: " + make);
        System.out.println(make + " " + model + " Group: " + group + " vehicle Id: " + vehID );
        System.out.println("Air conditioning/Climate Control: " + getAirConString() ); // change it to if statement with yes and no 
        System.out.println("Engine Size: " + engineSize + " Fuel: " + fuelType);
        System.out.println("Gearbox: " + gearbox + " Transmission: " + transmission);
        System.out.println("Mileage: " + mileage + " Date first registered: " + dateFirstRegistered);
    }
    public String toString()
    {
        //return "Group: " + group + " Vehicle Id: " + vehID + " Reg No: " + regNo + " Make: " + make + " Model: " + model + " Air Conditioning/ Climate Control: "+ airCon + " Engine Size: " + engineSize + " Fuel: " + fuelType + " Gearbox: " + gearbox + " Transmission: " + transmission + " Mileage: "+mileage + " Date first Registered: "+ dateFirstRegistered;
        return group + "," + regNo + "," + make + "," + model + ","+ airCon + "," + engineSize + "," + fuelType + "," + gearbox + "," + transmission + ","+mileage + ","+ dateFirstRegistered;
    }
    public void readData(Scanner scanner2)
    {
        String delimiter = ",";
        scanner2.useDelimiter(delimiter);
        group = scanner2.next().trim();
        vehID = scanner2.next().trim();
        regNo = scanner2.next().trim();
        make  = scanner2.next().trim();
        model = scanner2.next().trim();
        String tempAirCon = scanner2.next().trim();
        if(tempAirCon.equals("Yes"))
        {
            airCon = true;                
        }
        else
        {
            airCon = false;
        }
        String tempEngineSize = scanner2.next().trim();
        engineSize = Double.parseDouble(tempEngineSize);
        fuelType = scanner2.next().trim();
        gearbox = scanner2.next().trim();
        transmission = scanner2.next().trim();
        String tempmileage = scanner2.next().trim();
        mileage = Integer.parseInt(tempmileage);
        dateFirstRegistered = scanner2.next().trim();           
    }
}
