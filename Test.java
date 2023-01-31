import java.io.*;
import java.util.*;

/**
 * Test class for the project by Dominykas Jokubauskas AGE491
 * Notes for fixing:
 * -optimising the code
 * -See if all accesors and mutators are present 
 * - comment all needed things for clarification
 * - generateReservationNo in ReservationSystem figure out how to create unique numbers that do not start from 0
 */
public class Test
{

    public Test() 
    {
        //Vehicle vehicle = new Vehicle("A3", "JY-5623", "GF09RTY", "Ford");
        //vehicle.printDetails();
        //ReservationSystem reservationSystem = new ReservationSystem();
        //reservationSystem.readVehicleData();
        //reservationSystem.printAllVehicles();
        
        //reservationSystem.readCustomerData();
        //reservationSystem.writeCustomerData("new_customers.txt");
        //DateUtil dateUtil = new DateUtil();
        //Date date1 = dateUtil.convertStringToDate("12-03-2022");
        //Date date2 = dateUtil.convertStringToDate("31-03-2022");
        
        //System.out.println("Start date: "+ dateUtil.convertDateToLongString(date1));
        //System.out.println("End date: " + dateUtil.convertDateToLongString(date2));
        //System.out.println("Days between: " + dateUtil.daysBetween(date1, date2));
        //VehicleReservation vehh = new VehicleReservation("00001", "NG-0192", "TP-00001", "01-01-2021", 5);
        //vehh.print();
        //reservationSystem.makeVehicleReservation("AB-002450", "TF-65118", "01-04-2022", 5);
        //reservationSystem.printAllVehicleReservations();
        /**             Testing the vehicle Reservation system write function                         */
        
        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.readVehicleData();
        reservationSystem.readCustomerData();
        reservationSystem.printAllCustomers();        
        reservationSystem.makeVehicleReservation("AB-536621","TF-63403","01-04-2022", 5);
        reservationSystem.makeVehicleReservation("AB-095420","TF-61273","03-04-2022", 2);
        reservationSystem.makeVehicleReservation("AB-419676","GH-68135","02-04-2022",12);
        reservationSystem.makeVehicleReservation("AB-835474","TF-63403","01-04-2022",1);
        reservationSystem.printAllVehicleReservations();
        //System.out.println("                                              ");
        reservationSystem.writeReservationData("new_reservations.txt");
        //reservationSystem.readReservationData();
        //reservationSystem.printAllVehicleReservations();
        reservationSystem.printDiaryEntries("01-04-2022", "04-04-2022");
        
        
        
    }


}
