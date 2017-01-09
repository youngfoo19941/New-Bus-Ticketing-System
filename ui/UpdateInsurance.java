package ui;
import control.MaintainInsurance;
import domain.Insurance;
import da.InsuranceDA;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateInsurance extends JFrame{

    private MaintainInsurance insuranceMaintain = new MaintainInsurance();
    
    //private JTextField jtfStaffID = new JTextField();
    //private JTextField jtfStaffName = new JTextField();
    //private JTextField jtfIC = new JTextField();
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtBack = new JButton("Back");
    private String[] customer = insuranceMaintain.getCustomerName();  
    private JList list = new JList(customer);

    public UpdateInsurance() {
        add(new JLabel("Insurance List"),BorderLayout.NORTH);
   
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(list);
        
        JPanel Add = new JPanel();
        Add.add(jbtUpdate);
        Add.add(jbtBack);
        add(Add, BorderLayout.SOUTH);
        jbtUpdate.addActionListener(new UpdateListener());
        jbtBack.addActionListener(new Back());

        setTitle("Insurance Lsit");
        setUndecorated(true);
        setSize(700,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        String cusName = String.format("%s",list.getSelectedValue());
        new UpdateInsurance1(cusName);
        setVisible(false);
        }
    }
    
    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateInsurance();
    }
    
}
