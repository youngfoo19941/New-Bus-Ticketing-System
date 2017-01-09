package ui;
import control.MaintainInsurance;
import domain.Insurance;
import da.InsuranceDA;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class DeleteInsurance extends JFrame{

    private MaintainInsurance insuranceMaintain = new MaintainInsurance();
    
    
    private JButton jbtDelete = new JButton("Delete");
    private JButton jbtBack = new JButton("Back");
    private String[] staff = insuranceMaintain.getCustomerName();  
    private JList list = new JList(staff);

    public DeleteInsurance() {
        add(new JLabel("INSURANCE MENU"),BorderLayout.NORTH);
   
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(list);
        
        JPanel Add = new JPanel();
        Add.add(jbtDelete);
        Add.add(jbtBack);
        add(Add, BorderLayout.SOUTH);
        jbtDelete.addActionListener(new DeleteListener());
        jbtBack.addActionListener(new Back());

        setTitle("Insurance Delete");
        setUndecorated(true);
        setSize(700,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        String customerName = String.format("%s",list.getSelectedValue());
        new DeleteInsurance1(customerName);
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
        new DeleteInsurance();
    }
    
}
