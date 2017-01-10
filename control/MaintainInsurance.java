package control;

import domain.Insurance;
import da.InsuranceDA;

public class MaintainInsurance {

    private InsuranceDA insuranceDA;

    public MaintainInsurance() {
        insuranceDA = new InsuranceDA();
    }

    public Insurance selectRecord(String ID){
        return insuranceDA.getRecord(ID);
    }
    
    public Insurance getName(String ins){
        return insuranceDA.getName(ins);
    }

    public void addRecord(Insurance ins) {
        insuranceDA.addRecord(ins);
    }
    
    public void getRecord(Insurance ins) {
        insuranceDA.addRecord(ins);
    }
    
    public void updateRecord(Insurance ins) {
        insuranceDA.updateRecord(ins);
    }
    
    /*public void updateRecord1(Insurance ins){
        insuranceDA.updateRecord1(ins);
    }*/
    
    public void deleteRecord(Insurance ins) {
        insuranceDA.deleteRecord(ins);
    } 
    
    public String[] getCustomerName(){
        return insuranceDA.getCustomerName();
    }
    public String[] getClaimsName() {
        return insuranceDA.getClaimsName();
    }
    public String[] getAllCustomerContact() {
        return insuranceDA.getAllCustomerContact();
    }
    public String[] getAllPurchaseID() {
        return insuranceDA.getAllPurchaseID();
    }
    public String[] getAllPurchaseDate() {
        return insuranceDA.getAllPurchaseDate();
    }
    public String[] getAllCustomerIC() {
        return insuranceDA.getAllCustomerIC();
    }
    public String[] getClaims() {
        return insuranceDA.getClaims();
    }
    /*public String[] getPID(){
        return insuranceDA.getPID();
    }*/
    
}