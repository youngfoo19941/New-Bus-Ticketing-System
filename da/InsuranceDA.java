package da;

import domain.Insurance;
import java.sql.*;
import javax.swing.*;

public class InsuranceDA {
    private String host = "jdbc:derby://localhost:1527/BusSystem";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "PurchaseOrder";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQuery = "SELECT * FROM" + tableName;
    
    public InsuranceDA(){
        createConnection();
    }
    
    public Insurance getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PurchaseID = ?";
        Insurance purchase = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                purchase = new Insurance(ID,rs.getString("CustomerName"),rs.getString("CustomerContact"),rs.getString("CustomerIC"),rs.getDouble("InsuranceCllaims"),rs.getString("PurchaseDate"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return purchase;
    }
    
    public Insurance getName(String name) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE CUSTOMERNAME = ?";
        Insurance purchase = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                purchase = new Insurance(rs.getString("PurchaseID"),rs.getString("CustomerName"),rs.getString("CustomerContact"),rs.getString("CustomerIC"),rs.getDouble("InsuranceCllaims"),rs.getString("PurchaseDate"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return purchase;
    }
        
    public void addRecord(Insurance purchase) {
      
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement("INSERT INTO PURCHASEORDER VALUES(?, ?, ?, ?, ?, ?)");
                stmt.setString(1, purchase.getpurchaseID());
                stmt.setString(2, purchase.getcustomerName());
                
                stmt.setString(3, purchase.getCustomerContact());
                stmt.setString(4, purchase.getCustomerIC());
                stmt.setDouble(5, purchase.getInsuranceClaims());
                stmt.setString(6, purchase.getPurchaseDate());

                
                
                stmt.executeUpdate();
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void updateRecord(Insurance purchase){
        
        try{
                stmt = conn.prepareStatement("UPDATE PURCHASEORDER SET InsuranceCllaims = ? WHERE PurchaseID=?");
                
                
                stmt.setDouble(1, purchase.getInsuranceClaims());
                
                stmt.setString(2, purchase.getpurchaseID());
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    /*public void updateRecord1(Insurance purchase){
        
        try{
                stmt = conn.prepareStatement("UPDATE PURCHASEORDER SET PurchaseID=?, PurchaseDate = ?, CustomerContact = ?, CustomerIC = ?, InsuranceCllaims = ? WHERE CustomerName = ?");
                
                stmt.setString(1, purchase.getpurcahseID());
                
                stmt.setString(2, purchase.getPurhaseDate());
                stmt.setString(3, purchase.getCustomerContact());
                stmt.setString(4, purchase.getCustomerIC());
                stmt.setDouble(5, purchase.getInsuranceClaims());
                stmt.setString(6, purchase.getcustomerName());
                
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }*/
    
    public void deleteRecord(Insurance purchase){ 
        try{
            int yesno;
            yesno = JOptionPane.showConfirmDialog(null, "Are you sure to delete?", "YES OR NO", JOptionPane.YES_NO_OPTION);
            if(yesno==0)
            {
                stmt = conn.prepareStatement("DELETE FROM PURCHASEORDER WHERE PURCHASEID = ?");
                stmt.setString(1, purchase.getpurchaseID()); 
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Customer Infor mation has been deleted!");  
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void createConnection(){
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
   
   public String[] getCustomerName() {
        int count=0;
        String[] staffName={};
        try {
              
            stmt = conn.prepareStatement("SELECT CUSTOMERNAME FROM PURCHASEORDER WHERE InsuranceCllaims !=0");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            staffName = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                staffName[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staffName;
    }
   public String[] getClaimsName() {
        int count=0;
        String[] claimsName={};
        try {
              
            stmt = conn.prepareStatement("SELECT CustomerName FROM PURCHASEORDER");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            claimsName = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                claimsName[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return claimsName;
    }
   
   public String[] getAllCustomerContact() {
        int count=0;
        String[] CustomerContact={};
        try {
              
            stmt = conn.prepareStatement("SELECT CustomerContact FROM PURCHASEORDER");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            CustomerContact = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                CustomerContact[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return CustomerContact;
    }
   public String[] getAllPurchaseID() {
        int count=0;
        String[] PurchaseID={};
        try {
              
            stmt = conn.prepareStatement("SELECT PurchaseID FROM PURCHASEORDER");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            PurchaseID = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                PurchaseID[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return PurchaseID;
    }
   public String[] getAllPurchaseDate() {
        int count=0;
        String[] purchaseDate={};
        try {
              
            stmt = conn.prepareStatement("SELECT PurchaseDate FROM PURCHASEORDER");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            purchaseDate = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                purchaseDate[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return purchaseDate;
    }
   public String[] getAllCustomerIC() {
        int count=0;
        String[] cusIC={};
        try {
              
            stmt = conn.prepareStatement("SELECT CustomerIC FROM PURCHASEORDER");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            cusIC = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                cusIC[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return cusIC;
    }
   public String[] getClaims() {
        int count=0;
        String[] insClaims={};
        try {
              
            stmt = conn.prepareStatement("SELECT InsuranceCllaims FROM PURCHASEORDER");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            insClaims = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                insClaims[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return insClaims;
    }
   
    
}