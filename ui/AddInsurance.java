package ui;
import control.MaintainInsurance;
import da.InsuranceDA;
import domain.Insurance;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class AddInsurance extends JFrame{
   
    private MaintainInsurance insuranceMaintain =new MaintainInsurance();
    private JLabel jlblPurchaseID = new JLabel("     Puchase ID:                        ");
    //private JTextField jtfPurchaseID = new JTextField(10);
    private JLabel jlblCustomerName = new JLabel("     Customer Name:              ");
    private JTextField jtfCustomerName = new JTextField();
    private JLabel jlblPurchaseDate = new JLabel("     Purchase Date:                 ");
    private JTextField jtfPurchaseDate = new JTextField();
    private JLabel jlblCustomerContact = new JLabel("     Customer Contact:           ");
    private JTextField jtfCustomerContact = new JTextField();
    
    
    private JLabel jlblCustomerIC = new JLabel("    Customer IC:                       ");
    private JTextField jtfCustomerIC = new JTextField();
    private JLabel jlblInsuranceClaims = new JLabel("     Insurance Claims:            ");
    private JTextField jtfInsuranceClaims = new JTextField();
    
    
    
    private JButton jbtAdd = new JButton("Add");
    private JButton jbtBack = new JButton("Back");
    private JButton jbtCheck = new JButton("Check");
    
    //private String[] staff = staffMaintain.getStaffName();
   // private JList list = new JList(staff);
  
    public AddInsurance(){
        
        
        String[]  Pid= insuranceMaintain.getAllPurchaseID();
        String[] cName = insuranceMaintain.getClaimsName();
        String[] pDate = insuranceMaintain.getAllPurchaseDate();
        String[] cContact= insuranceMaintain.getAllCustomerContact();
        String[] cIC = insuranceMaintain.getAllCustomerIC();
        //String[] iClaims = insuranceMaintain.getClaims();
        JComboBox b = new JComboBox(Pid);
        
        Box boxes1 = Box.createHorizontalBox();
        boxes1.add(jlblPurchaseID);
        boxes1.add(b);
        boxes1.add(jbtCheck);
        add(boxes1);
        
        Box boxes2 = Box.createHorizontalBox();
        boxes2.add(jlblCustomerName);
        boxes2.add(jtfCustomerName);
        add(boxes2);
        
        Box boxes3 = Box.createHorizontalBox();
        boxes3.add(jlblPurchaseDate);
        boxes3.add(jtfPurchaseDate);
        add(boxes3);
        
        Box boxes4 = Box.createHorizontalBox();
        boxes4.add(jlblCustomerContact);
        boxes4.add(jtfCustomerContact);
        add(boxes4);
        
        Box boxes5 = Box.createHorizontalBox();
        boxes5.add(jlblCustomerIC);
        boxes5.add(jtfCustomerIC);
        add(boxes5);
        
        Box boxes6 = Box.createHorizontalBox();
        boxes6.add(jlblInsuranceClaims);
        boxes6.add(jtfInsuranceClaims);
        add(boxes6);
        
        jtfCustomerName.setEditable(false);
        jtfPurchaseDate.setEditable(false);
        jtfCustomerContact.setEditable(false);
        jtfCustomerIC.setEditable(false);
        

        
        
        JPanel p1 = new JPanel(new GridLayout(6,1));
        p1.setOpaque(false);
        
        p1.add(boxes1);
        p1.add(boxes2);
        
        p1.add(boxes3);
        p1.add(boxes4);
        p1.add(boxes5);
        p1.add(boxes6);
        
    
        setLayout(new BorderLayout());
        add(p1,BorderLayout.NORTH);
        
        JPanel LastPanel = new JPanel();
        LastPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        LastPanel.setOpaque(false);
        LastPanel.add(jbtAdd);
        LastPanel.add(jbtBack);
        add(LastPanel, BorderLayout.SOUTH);
        
        jbtCheck.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String jtfPurchaseID="";
                for(int i=0; i<jtfPurchaseID.length() ;i++){
                    if(b.getSelectedIndex()== i){
                           jtfPurchaseID += Pid[i];
                           jtfCustomerName.setText(cName[i]);
                           jtfPurchaseDate.setText(pDate[i]);
                           jtfCustomerContact.setText(cContact[i]);
                           jtfCustomerIC.setText(cIC[i]);
                           //jtfInsuranceClaims.setText(iClaims[i]);
                    }
                }
                
                Insurance insurance = insuranceMaintain.selectRecord(jtfPurchaseID);
                int jtfcName =b.getSelectedIndex();
                jtfCustomerName.setText(cName[jtfcName]);
                int jtfPdate =b.getSelectedIndex();
                jtfPurchaseDate.setText(pDate[jtfPdate]);
                int jtfCcontact =b.getSelectedIndex();
                jtfCustomerContact.setText(cContact[jtfCcontact]);
                int jtfCic =b.getSelectedIndex();
                jtfCustomerIC.setText(cIC[jtfCic]);
            }
            });
        jbtBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });
        jbtAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
        try{    
            
            
            
            //if(insurance != null){
               // JOptionPane.showMessageDialog(null, "Your Customer info is already exist.", "DUPLICATE SCHEDULE", JOptionPane.ERROR_MESSAGE);
            //}
            
 
            //else{
                 
                String jtfPurchaseID="";
                for(int i=0; i<31 ;i++){
                    if(b.getSelectedIndex()== i){
                           jtfPurchaseID += Pid[i];
                           jtfCustomerName.setText(cName[i]);
                           jtfPurchaseDate.setText(pDate[i]);
                           jtfCustomerContact.setText(cContact[i]);
                           jtfCustomerIC.setText(cIC[i]);
                           //jtfInsuranceClaims.setText(iClaims[i]);
                    }
                }
                Insurance insurance = insuranceMaintain.selectRecord(jtfPurchaseID);
                int jtfcName =b.getSelectedIndex();
                jtfCustomerName.setText(cName[jtfcName]);
                int jtfPdate =b.getSelectedIndex();
                jtfPurchaseDate.setText(pDate[jtfPdate]);
                int jtfCcontact =b.getSelectedIndex();
                jtfCustomerContact.setText(cContact[jtfCcontact]);
                int jtfCic =b.getSelectedIndex();
                jtfCustomerIC.setText(cIC[jtfCic]);
                //int jtfIclaims =b.getSelectedIndex();
                //jtfInsuranceClaims.setText(iClaims[jtfIclaims]);
                int Valid;
                Valid = 1;
                if(!jtfInsuranceClaims.getText().matches("[0-9]+.[0-9]+")&&!jtfInsuranceClaims.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Insurance Claims must double number. e.g:12.30");
                    Valid=0;
                }
                
                if(Valid==0){
                    
                }
                else{
                int yes=1;
                
                yes = JOptionPane.showConfirmDialog(null, "Are you sure to add?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if(yes==JOptionPane.YES_OPTION){
                    
                  
                    insurance = new Insurance(jtfPurchaseID,jtfCustomerName.getText(), jtfCustomerContact.getText(), jtfCustomerIC.getText(), Double.parseDouble(jtfInsuranceClaims.getText()),jtfPurchaseDate.getText());
                    insuranceMaintain.updateRecord(insurance);

                    JOptionPane.showMessageDialog(null, "Insurance Added");
                    setVisible(false);
               }
                
            }
                 
            
        }catch(IllegalArgumentException ex){
            if(jtfInsuranceClaims.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill up insurance claims Information !", "Invalid Add", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        }});
     
 
        
        
        

        setTitle("Add Insurance");
        //setUndecorated(true);
        setSize(500,250);
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    
    /*public void clear(){
        jtfID.setText("");
        jtfName.setText("");
        jtfIC.setText("");
        jtfSecIC.setText("");
        jtfthirdIC.setText("");
        jtaAddress.setText("");
        jtfPhoneNo.setText("");
        jcbDobDay.setSelectedItem("1");
        jcbDobMth.setSelectedItem("1");
        jcbDobYr.setSelectedItem("2016");
        jcbDay.setSelectedItem("1");
        jcbMth.setSelectedItem("1");
        jcbYr.setSelectedItem("2016");
        group.clearSelection();
        group1.clearSelection();
    }*/
      
    }
    
    
     
     
    public static void main(String[] args) {
        new AddInsurance();
    }
    
}