package domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.Date;


public class Insurance implements Serializable{
    private String purchaseID;
    private String customerName;
   // private String SeatID;
    private String PurchaseDate;
    private String CustomerContact;
    //private String ScheduleID;
    private String CustomerIC;
    private double InsuranceCllaims;
    

    public Insurance(){
        
    }
    
    public Insurance(String purchaseID,String customerName,String CustomerContact,String CustomerIC,double InsuranceCllaims,String PurchaseDate){
        this.purchaseID = purchaseID;
        this.customerName = customerName;
        //this.SeatID = SeatID;
        
        this.CustomerContact = CustomerContact;
        //this.ScheduleID = ScheduleID;
        this.CustomerIC = CustomerIC;
        this.InsuranceCllaims = InsuranceCllaims;
        this.PurchaseDate = PurchaseDate;
        
    }
    
    public String getpurchaseID(){
        return purchaseID;
    }
    public void  setpurchaseID(String purchaseID){
        this.purchaseID = purchaseID;
    }
    
    public String getcustomerName(){
        return customerName;
    }
    public void  setcustomerName(String customerName){
        this.customerName = customerName;
    }
    
    /*public String getseatID(){
        return SeatID;
    }
    public void  setseatID(String seatID){
        this.SeatID = SeatID;
    }*/
    
    public String getPurchaseDate(){
        return PurchaseDate;
    }
    public void  setPurchaseDate(String PurchaseDate){
        this.PurchaseDate = PurchaseDate;
    }
    
     public String getCustomerContact(){
        return CustomerContact;
    }
    public void  setCustomerContact(String CustomerContact){
        this.CustomerContact = CustomerContact;
    }
    
    /*public String getScheduleID(){
        return ScheduleID;
    }
    public void  setScheduleID(String ScheduleID){
        this.ScheduleID = ScheduleID;
    }*/
    
    public String getCustomerIC(){
        return CustomerIC;
    }
    public void  setCustomerIC(String CustomerIC){
        this.CustomerIC = CustomerIC;
    }
   
    public double getInsuranceClaims(){
        return InsuranceCllaims;
    }
    public void  setInsuranceClaims(double InsuranceCllaims){
        this.InsuranceCllaims = InsuranceCllaims;
    }
   
    
}