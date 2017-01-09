package ui;
import control.MaintainInsurance;
import da.InsuranceDA;
import domain.Insurance;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class DeleteInsurance1 extends JFrame{

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
    
    
    
    private JButton jbtDelete = new JButton("Delete");
    private JButton jbtBack = new JButton("Back");
    
    //private String[] staff = staffMaintain.getStaffName();
   // private JList list = new JList(staff);
  
    public DeleteInsurance1(String name){
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
        
        jtfCustomerName.setText(String.format("%s",insurance.getcustomerName()));
        jtfCustomerName.setEditable(false);
        
        jtfPurchaseDate.setText(String.format("%s",insurance.getPurchaseDate()));
        jtfPurchaseDate.setEditable(false);
        
        jtfCustomerContact.setText(String.format("%s",insurance.getCustomerContact()));
        jtfCustomerContact.setEditable(false);
        
        jtfCustomerIC.setText(String.format("%s",insurance.getCustomerIC()));
        jtfCustomerIC.setEditable(false);
        
        jtfInsuranceClaims.setText(String.format("%s",insurance.getInsuranceClaims()));
        jtfInsuranceClaims.setEditable(false);
        
        
        jbtBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
            });
        
        
   
        
        
        
        
        JPanel LastPanel = new JPanel();
        LastPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        LastPanel.setOpaque(false);
        LastPanel.add(jbtDelete);
        LastPanel.add(jbtBack);
        add(LastPanel, BorderLayout.SOUTH);
        
        jbtDelete.addActionListener(new DeleteListener());
        
        setTitle("Insurance CRUD");
        setSize(1000,600);
        //setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
      
    }
    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        Insurance insurance = insuranceMaintain.selectRecord(jtfPurchaseID.getText());
        jtfInsuranceClaims.setText("0");
                int i = JOptionPane.showConfirmDialog(null, "Are you sure delete?","Record Delete",JOptionPane.YES_NO_OPTION);
            
            if (insurance != null) {
              if(i==0){
                  
                insurance = new Insurance(jtfPurchaseID.getText(),jtfCustomerName.getText(), jtfCustomerContact.getText(), jtfCustomerIC.getText(), Double.parseDouble(jtfInsuranceClaims.getText()),jtfPurchaseDate.getText());
                    insuranceMaintain.updateRecord(insurance);
                JOptionPane.showMessageDialog(null, "Insurance Deleted! ");
                setVisible(false);
                new DeleteInsurance();
              }
            } else {
               JOptionPane.showMessageDialog(null, "Schedule ID are not exist","Schedule ID not found",JOptionPane.ERROR_MESSAGE);
            }
        }
    }        
    
        
    public static void main(String[] args) {
        new DeleteInsurance1("Sam");
    }
    
}
