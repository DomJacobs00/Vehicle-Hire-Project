//import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.awt.FileDialog;
import java.awt.Frame;
import java.util.Scanner;

/**
 * ReservationSystem acts as a upload area aswell as storage of all vehicles
 * Created by: Dominykas Jokubauskas AGE491
 */
public class ReservationSystem
{
    //private ArrayList<Vehicle> vehicleList;
    private HashMap <String, Vehicle> vehicleMap;
    //private ArrayList<Customer> customerList;
    private HashMap <String, Customer> customerMap;
    private HashMap <String, VehicleReservation> vehicleReservationMap;
    private Diary diary;
    /** Reservation system**/
    public ReservationSystem()
    {
        //vehicleList = new ArrayList<Vehicle>();
        vehicleMap = new HashMap<String, Vehicle>();
        //customerList = new ArrayList<Customer>();
        customerMap = new HashMap<String, Customer>();
        vehicleReservationMap = new HashMap<String, VehicleReservation>();
        diary = new Diary();
    }
    /** Vehicle methods **/
    public void readVehicleData()
    {
        Frame openFrame = null;
        FileDialog openFile = new FileDialog(openFrame, "Open", FileDialog.LOAD);
        openFile.setVisible(true);
        openFile.setDirectory("C:/Users/ddjok/OneDrive - University of Salford/Year 1/Programming/T2/Vehicle Hire app project");
        String fileName = openFile.getFile();
        File dataFile = new File(fileName);
        Scanner scanner = null;
        String typeOfData = null;
        
        try
        {
            scanner = new Scanner(dataFile); 
        }
        catch( Exception FileNotFound)
        {
           System.out.println("File Not Found"); 
        }   
        while(scanner.hasNext())
            {
                String lineOfText= scanner.nextLine();
                if(lineOfText.startsWith("//")) 
                {
                }
                else if(lineOfText.isEmpty() )
                {
                }
                else if(lineOfText.startsWith("[")) 
                {
                    typeOfData = lineOfText.trim();
                }
                else
                {
                        if(typeOfData.equals("[Car data]"))
                        {
                           Scanner scanner2 = new Scanner(lineOfText); 
                           Vehicle vehicle1 = new Car();
                           vehicle1.readData(scanner2);
                           storeVehicle(vehicle1);
                        } 
                        else if(typeOfData.equals("[van data]"))
                        {
                            Scanner scanner3 = new Scanner(lineOfText);
                            Vehicle vehicle2 = new Van();
                            vehicle2.readData(scanner3);
                            storeVehicle(vehicle2);
                        }
                        else if(typeOfData.equals("[Truck data]"))
                        {
                            Scanner scanner4 =  new Scanner(lineOfText);
                            Vehicle vehicle3 = new Truck();
                            vehicle3.readData(scanner4);
                            storeVehicle(vehicle3);
                        }
                }
            }
    }   
    public void storeVehicle(Vehicle vehicle)
    {
        //vehicleList.add(vehicle);
        vehicleMap.put(vehicle.getVehID(),vehicle);
        
    }
    public void printAllVehicles()
    {
       
    
        //for(Vehicle vehicle: vehicleList)
        for(String vehID: vehicleMap.keySet())
        {   
            System.out.println(vehID+","+vehicleMap.get(vehID));
        }
    }
    /** Customer methods **/
    public void storeCustomer(Customer customer)
    {
        //customerList.add(customer);
        
        customerMap.put(customer.getCustomerID(),customer);
    }
    public void printAllCustomers()
    {
        //for(Customer customer: customerList)
        for(String customerID: customerMap.keySet())
        {
            System.out.println(customerID+","+customerMap.get(customerID));
        }

    }
    public void readCustomerData()
    {
        Frame openFrame = null;
        FileDialog openFile = new FileDialog(openFrame, "Open", FileDialog.LOAD);
        openFile.setVisible(true);
        openFile.setDirectory("C:/Users/ddjok/OneDrive - University of Salford/Year 1/Programming/T2/Vehicle Hire app project");
        String fileName = openFile.getFile();
        File dataFile = new File(fileName);
        Scanner scanner = null;
        String typeOfData = null;
        try
        {
            scanner = new Scanner(dataFile); 
        }
        catch( Exception FileNotFound)
        {
           System.out.println("File Not Found"); 
        }
        while(scanner.hasNext())
        {
            String line = scanner.nextLine();
            if(line.startsWith("//"))
            {
                
            }
            else if(line.isEmpty())
            {
                
            }
            else
            {
             Customer customer = new Customer();
             Scanner scanner2 = new Scanner(line);
             customer.readData(scanner2);
             if(customer.getCustomerID().equals("unknown"))
             {
                customer.setCustomerID(generateCustomerID("AB-", 6));
                
             }
             storeCustomer(customer);
            }
            
        }
    }
    public void writeCustomerData(String fileName)
    {
        PrintWriter writer = null;
        try
        {
          writer = new PrintWriter(fileName);  
        }
        catch( Exception FileNotFound)
        {
            System.out.println("Process failed");
        }
        //for(Customer customer: customerList)
        for(Customer customer: customerMap.values())
        {
            String output = customer.getCustomerID() + "," + customer.getSurname()  + "," + customer.getFirstName()  + "," + customer.getOtherInitials()  + "," + customer.getTitle();
            writer.println(output);
        }

        
        writer.close();
    }
    public String generateCustomerID(String prefix, int noOfDigits)
    {
        /**
         * Using a while loop with a boolean called unique, firstly a sequence of numbers with specified length by noOfDigits
         * is created, then combined with the prefix it is checked if the CustomerID is already in use. If it is, then generated
         * CustomerID is deleted and the generator starts from the begining.
         * Once a unique CustomerID is produced the boolean is changed to true and the
         * unique CustomerID is returned to the method that called it.
         */
        String customerID = "";
        Random randomNumber = new Random();
        boolean unique = false;
        while(unique == false)
        {
            while(customerID.length()<noOfDigits)
            {
                int number = randomNumber.nextInt(10);
                customerID = customerID + number;
            }
            String ID = prefix+customerID;
            if(!customerMap.containsKey(ID))
            {
                unique = true;
            }
            else
            {
                customerID = "";
            }
            
        }
            
        return prefix+customerID;
        
        
    }
    /**     Vehicle Reservation     **/
    public void storeVehicleReservation(VehicleReservation vehicleReservation)
    {
        vehicleReservationMap.put(vehicleReservation.getReservationNo(), vehicleReservation);
        diary.addReservation(vehicleReservation);
    }
    public String generateReservationNo()
    {
        /** 
         * Firstly the method initialises the reservationNo as empty string. The lastDigit is created temporarily if the 
         * last number file exsists, if not then it is used as the end of the reservation number. Scanner is used to access
         * the file containing last reservationNo. When obtained the reservation number is increased by 1. While loop is used
         * to fill the unused space by 0's and when desired lengh is reached the last digit that is either obtained from 
         * the file or used from the initialised string is added to the reservationNo and is written to a file using PrintWriter
         * as well as returned to be used in other methods.
        **/
        String reservationNo = "";
        String lastDigit = "1";
        
        File dataFile = new File("last_reservation_number.txt");
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(dataFile);
            while (scanner.hasNext())
            {
                int in = scanner.nextInt();
                lastDigit = in + 1 + "";
            }
        }
        catch(Exception FileNotFound)
        {
            ;
        }
        while((reservationNo.length()+lastDigit.length())<7)
        {
            reservationNo = reservationNo+"0";
        }
        reservationNo = reservationNo + lastDigit;
        
        PrintWriter writer;
        try
        {
            writer = new PrintWriter("last_reservation_number.txt");
            writer.println(reservationNo);
            writer.close();
        }
        catch (Exception FileNotFound)
        {
            System.out.println("Unable to save last digit for reservation.");
        }
        
        return reservationNo;
    }
    public void getVehicleReservation(String reservationNo)
    {
        System.out.println(vehicleReservationMap.get(reservationNo));
    }
    public boolean makeVehicleReservation(String customerID, String vehID, String startDate, int noOfDays)
    {
        /**
         * This method has several checkpoints to proceed with making the reservation. Firstly it checks if the Customer exsists
         * in the customerMap, then it checks if vehicle chosen exists. If both customer and vehicle exsist, then the method
         * checks if the vehicle is not already reserved for the duration chosen by the user. This is done by utilizing 
         * getReservations method in the Diary class that gets an array of VehicleReservation objects of that day. A while loop
         * is used to find if the vehicle that is chosen is already reserved in the diary, checking from the startDate and 
         * through number of days chosen. If the vehicle ID is not found in the reservations stored in the diary, then the 
         * method proceeds to create a reservation with the information provided.
         */
        Date checkDate = DateUtil.convertStringToDate(startDate);
        Date endDate = DateUtil.incrementDate(checkDate, noOfDays);
        String reservedVehID = "";
        while(DateUtil.daysBetween(checkDate, endDate)>=0)
        {
            VehicleReservation [] input = diary.getReservations(checkDate);
            if(input == null)
            {
                ;
            }
            else
            {
                for(VehicleReservation vehicleReservation: input)
                {
                    reservedVehID = vehicleReservation.getVehID();
                    if(reservedVehID.equals(vehID))
                    {
                        checkDate = endDate;
                    }
                }
            }
            checkDate = DateUtil.incrementDate(checkDate, 1);
        }
        if( !customerMap.containsKey(customerID))
        {
            System.out.println("CustomerID not found");
            return false;
        }
        else if( !vehicleMap.containsKey(vehID))
        {
            System.out.println("VehicleID not found");
            return false;
        }
        else if(vehID.equals(reservedVehID))
        {
                System.out.println("This vehicle has been already reserved for the chosen period" );
                return false;
        }   
        else
        {
            String reservationNo = generateReservationNo();
            VehicleReservation reservation = new VehicleReservation(reservationNo, vehID, customerID,  startDate, noOfDays);
            storeVehicleReservation(reservation);
            return true;  
        }
    }
    public void printAllVehicleReservations()
    {
        for(VehicleReservation vehicleReservation: vehicleReservationMap.values())
        {
            vehicleReservation.printDetails();
        }
    }
    public void writeReservationData(String fileName)
    {
        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter(fileName);
        }
        catch (Exception FileNotFound)
        {
            System.out.println("Process failed");
        }
        for(VehicleReservation vehicleReservation: vehicleReservationMap.values())
        {
            
            String output = vehicleReservation.getReservationNo()+","+ vehicleReservation.getCustomerID()+","+vehicleReservation.getVehID()+","+vehicleReservation.getStartDate()+","+vehicleReservation.getNoOfDays();
            writer.println(output);
            System.out.println(output);
        }
        writer.close();
    }
    public void readReservationData()
    {
        Frame openFrame = null;
        FileDialog openFile = new FileDialog(openFrame, "Open", FileDialog.LOAD);
        openFile.setVisible(true);
        //openFile.setDirectory();
        String fileName = openFile.getFile();
        File dataFile = new File(fileName);
        Scanner scanner = null;
        
        try
        {
            scanner = new Scanner(dataFile);
            
        }
        catch(Exception FileNotFound)
        {
            System.out.println("File not found");
        }
        while(scanner.hasNext())
        {
            String line = scanner.nextLine();
            Scanner scanner2 = new Scanner(line);
            String delimiter = ",";
            scanner2.useDelimiter(delimiter);
            while(scanner2.hasNext())
            {
                String reservationNo = scanner2.next();
                String customerID = scanner2.next();
                String vehID = scanner2.next();
                String startDate = scanner2.next();
                int noOfDays = scanner2.nextInt();
               
                VehicleReservation reservation = new VehicleReservation(reservationNo, customerID, vehID, startDate, noOfDays);
                if(!vehicleReservationMap.containsKey(reservationNo))
                {
                   storeVehicleReservation(reservation); 
                }
                else
                {
                   System.out.println("This reservation is already stored.");
                }
            }
            
        }
    }
    public void printDiaryEntries(String startDate, String endDate)
        {
            diary.printEntries(DateUtil.convertStringToDate(startDate), DateUtil.convertStringToDate(endDate));
        }
    public void deleteVehicleReservation(String reservationNo)
    {
        diary.deleteReservation(vehicleReservationMap.get(reservationNo));
        vehicleReservationMap.remove(reservationNo);
    }
    
}
