import java.util.*;

/**
 * Write a description of class VehicleReservation here.
 *
 * @author (Dominykas Jokubauskas AGE491)
 * @version (Part 4 Step 2)
 */
public class VehicleReservation
{
    private String reservationNo;
    private String vehID;
    private String customerID;
    private DateUtil dateUtil;
    private Date startDate;
    private int noOfDays;
    
    
    public VehicleReservation(String reservationNo, String vehID, String customerID, String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.vehID = vehID;
        this.customerID = customerID;
        dateUtil = new DateUtil();
        this.startDate = dateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
        
    }
    public VehicleReservation()
    {
        
    }
    public String getReservationNo()
    {
        return reservationNo;
    }
    public void setReservationNo(String reservationNo)
    {
        this.reservationNo = reservationNo;
    }
    public String getVehID()
    {
        return vehID;
    }
    public void setVehID(String vehID)
    {
        this.vehID = vehID;
    }
    public String getCustomerID()
    {
        return customerID;
    }
    public void setCustomerID(String customerID)
    {
        this.customerID = customerID;
    }
    public Date getStartDate()
    {
        return startDate;
    }
    public void setStartDate(String startDate)
    {
        this.startDate = dateUtil.convertStringToDate(startDate);
    }
    public int getNoOfDays()
    {
        return noOfDays;
    }
    public void setNoOfDays(int noOfDays)
    {
        this.noOfDays = noOfDays;
    }
    public void printDetails()
    {
        System.out.println("Reservation number: "+ reservationNo+", vehicle ID: " + vehID + ", Customer ID: " + customerID + ", start date: " + dateUtil.convertDateToShortString(startDate) + ", number of days: " + noOfDays);

    }
    public String toString()
    {
        return "Reservation No: "+ reservationNo + ", Vehicle ID: "+ vehID + ", Customer ID: " + customerID;
    }
}
