package ui;
import control.MaintainInsurance;
import da.InsuranceDA;
import domain.Insurance;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateInsurance1 extends JFrame{

    private MaintainInsurance insuranceMaintain;
    private JLabel jlblPurchaseID = new JLabel("     Puchase ID:                        ");
    private JTextField jtfPurchaseID = new JTextField(10);
    private JLabel jlblCustomerName = new JLabel("     Customer Name:               ");
    private JTextField jtfCustomerName = new JTextField();
    private JLabel jlblPurchaseDate = new JLabel("     Purchase Date:                  ");
    private JTextField jtfPurchaseDate = new JTextField();
    private JLabel jlblCustomerContact = new JLabel("     Customer Contact:            ");
    private JTextField jtfCustomerContact = new JTextField();
    
    
    private JLabel jlblCustomerIC = new JLabel("    Customer IC:                        ");
    private JTextField jtfCustomerIC = new JTextField();
    private JLabel jlblInsuranceClaims = new JLabel("     Insurance Claims:             ");
    private JTextField jtfInsuranceClaims = new JTextField();
    
    private JLabel jlblPurchaseID2 = new JLabel("     Puchase ID:                        ");
    private JTextField jtfPurchaseID2 = new JTextField(10);
    private JLabel jlblCustomerName2 = new JLabel("     Customer Name:               ");
    private JTextField jtfCustomerName2 = new JTextField();
    private JLabel jlblPurchaseDate2 = new JLabel("     Purchase Date:                  ");
    private JTextField jtfPurchaseDate2 = new JTextField();
    private JLabel jlblCustomerContact2 = new JLabel("     Customer Contact:            ");
    private JTextField jtfCustomerContact2 = new JTextField();
    
    
    private JLabel jlblCustomerIC2 = new JLabel("    Customer IC:                        ");
    private JTextField jtfCustomerIC2 = new JTextField();
    private JLabel jlblInsuranceClaims2 = new JLabel("     Insurance Claims:             ");
    private JTextField jtfInsuranceClaims2 = new JTextField();
    
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtBack = new JButton("Back");
    
    //private String[] staff = staffMaintain.getStaffName();
   // private JList list = new JList(staff);
  
    public UpdateInsurance1(String name){
        insuranceMaintain = new MaintainInsurance();
        Insurance insurance = insuranceMaintain.getName(name);
        Box boxes1 = Box.createHorizontalBox();
        boxes1.add(jlblPurchaseID);
        boxes1.add(jtfPurchaseID);
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
        
        

        
        
        JPanel p1 = new JPanel(new GridLayout(10,1));
        p1.setOpaque(false);
        p1.setBorder(new TitledBorder("Current Staff Information"));
        p1.add(boxes1);
        p1.add(boxes2);
        p1.add(boxes3);
        p1.add(boxes4);
        p1.add(boxes5);
        p1.add(boxes6);
        
        add(p1);
        
        jtfPurchaseID.setText(String.format("%s",insurance.getpurchaseID()));
        jtfPurchaseID.setEditable(false);
        jtfPurchaseID2.setText(String.format("%s",insurance.getpurchaseID()));
        jtfPurchaseID2.setEditable(false);
        jtfCustomerName.setText(String.format("%s",insurance.getcustomerName()));
        jtfCustomerName.setEditable(false);
        jtfCustomerName2.setText(String.format("%s",insurance.getcustomerName()));
        jtfCustomerName2.setEditable(false);
        jtfPurchaseDate.setText(String.format("%s",insurance.getPurchaseDate()));
        jtfPurchaseDate.setEditable(false);
        jtfPurchaseDate2.setText(String.format("%s",insurance.getPurchaseDate()));
        jtfPurchaseDate2.setEditable(false);
        jtfCustomerContact.setText(String.format("%s",insurance.getCustomerContact()));
        jtfCustomerContact.setEditable(false);
        jtfCustomerContact2.setText(String.format("%s",insurance.getCustomerContact()));
        jtfCustomerContact2.setEditable(false);
        jtfCustomerIC.setText(String.format("%s",insurance.getCustomerIC()));
        jtfCustomerIC.setEditable(false);
        jtfCustomerIC2.setText(String.format("%s",insurance.getCustomerIC()));
        jtfCustomerIC2.setEditable(false);
        jtfInsuranceClaims.setText(String.format("%s",insurance.getInsuranceClaims()));
        jtfInsuranceClaims.setEditable(false);
        
        
        
        Box boxes7 = Box.createHorizontalBox();
        boxes7.add(jlblPurchaseID2);
        boxes7.add(jtfPurchaseID2);
        add(boxes7);
        
        Box boxes8 = Box.createHorizontalBox();
        boxes8.add(jlblCustomerName2);
        boxes8.add(jtfCustomerName2);
        add(boxes8);
        
        Box boxes9 = Box.createHorizontalBox();
        boxes9.add(jlblPurchaseDate2);
        boxes9.add(jtfPurchaseDate2);
        add(boxes9);
        
        Box boxes10 = Box.createHorizontalBox();
        boxes10.add(jlblCustomerContact2);
        boxes10.add(jtfCustomerContact2);
        add(boxes10);
        
        Box boxes11 = Box.createHorizontalBox();
        boxes11.add(jlblCustomerIC2);
        boxes11.add(jtfCustomerIC2);
        add(boxes11);
        
        Box boxes12 = Box.createHorizontalBox();
        boxes12.add(jlblInsuranceClaims2);
        boxes12.add(jtfInsuranceClaims2);
        add(boxes12);
        
   
        JPanel p2 = new JPanel(new GridLayout(11,1));
        p2.setOpaque(false);
        p2.setBorder(new TitledBorder("Current Staff Information"));
        p2.add(boxes7);
        p2.add(boxes8);
        p2.add(boxes9);
        p2.add(boxes10);
        p2.add(boxes11);
        p2.add(boxes12);
        
        add(p2);
        
        JPanel BigPanel = new JPanel(new GridLayout(1,2));
        BigPanel.add(p1, BorderLayout.EAST);
        BigPanel.add(p2, BorderLayout.WEST);
        add(BigPanel);
        
        JPanel LastPanel = new JPanel();
        LastPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        LastPanel.setOpaque(false);
        LastPanel.add(jbtUpdate);
        LastPanel.add(jbtBack);
        add(LastPanel, BorderLayout.SOUTH);
        
        jbtUpdate.addActionListener(new UpdateListener());
        jbtBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new UpdateSchedule();
                setVisible(false);
            }
        });
        
        setTitle("Staff CRUD");
        setSize(1000,600);
        //setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
      
    }
    
    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        Insurance insurance = insuranceMaintain.selectRecord(jtfPurchaseID.getText());
            int Valid;
            Valid=1;
            if(jtfInsuranceClaims2.getText().equals("")){
                jtfInsuranceClaims2.setText(String.format("%s",jtfInsuranceClaims.getText()));
            }
            
            if(!jtfInsuranceClaims2.getText().matches("[0-9]+.[0-9]+")&&!jtfInsuranceClaims.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Insurance Claims must double number. e.g:12.30");
                    Valid=0;
                    
                }
            
            if(Valid==0){
                
            }
            
            
            
            else{
            if (insurance != null) {
                     int yes = JOptionPane.showConfirmDialog(null,"Sure to Update staff information?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
             if(yes==JOptionPane.YES_OPTION){
                 
             insurance = new Insurance(jtfPurchaseID2.getText(),jtfCustomerName2.getText(), jtfCustomerContact2.getText(), jtfCustomerIC2.getText(), Double.parseDouble(jtfInsuranceClaims2.getText()), jtfPurchaseDate2.getText());
                
              insuranceMaintain.updateRecord(insurance);
                 
              JOptionPane.showMessageDialog(null, "New Staff Updated !");
            }
            } else {
                
               JOptionPane.showMessageDialog(null, "Staff ID are not exist","Staff ID not found",JOptionPane.ERROR_MESSAGE);
             
            }
        }}
    }
 
     
     
    public static void main(String[] args) {
        new UpdateInsurance1("Sam");
    }
    
}
