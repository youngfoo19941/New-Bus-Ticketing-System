package ui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.border.*;
//import domain.*;
import domain.Staff;
import da.StaffDA;
import control.MaintainStaff;

public class mainMenu extends JFrame{
    ImageIcon backgroud = new ImageIcon(getClass().getResource("/images/Background_1.jpg"));
    ImageIcon q = new ImageIcon(getClass().getResource("/images/exit1.png"));
    private JButton Quit = new JButton(q);
    ImageIcon q2 = new ImageIcon(getClass().getResource("/images/exit.png"));
    private JButton Quit1 = new JButton(q2);
    
    ImageIcon staffIcon = new ImageIcon(getClass().getResource("/images/Staff_1.fw.png"));
    private JButton manageStaff = new JButton("Staff",staffIcon);
    ImageIcon staffIcon1 = new ImageIcon(getClass().getResource("/images/Staff.png"));
    private JButton manageStaff1 = new JButton("Staff",staffIcon1);
    
    ImageIcon ticketIcon = new ImageIcon(getClass().getResource("/images/Tickets_1.fw.png"));
    private JButton ticket = new JButton("Ticket",ticketIcon);
    ImageIcon ticketIcon1 = new ImageIcon(getClass().getResource("/images/Tickets.png"));
    private JButton ticket1 = new JButton("Ticket",ticketIcon1);
    
    ImageIcon busIcon = new ImageIcon(getClass().getResource("/images/Bus Icon_1.fw.png"));
    private JButton busSchedule = new JButton("Bus Schedule",busIcon);
    ImageIcon busIcon1 = new ImageIcon(getClass().getResource("/images/Bus Icon.fw.png"));
    private JButton busSchedule1 = new JButton("Bus Schedule",busIcon1);
    
    ImageIcon driverIcon = new ImageIcon(getClass().getResource("/images/Driver_1.fw.png"));
    private JButton driverSchedule = new JButton("Driver Schedule",driverIcon);
    ImageIcon driverIcon1 = new ImageIcon(getClass().getResource("/images/Driver.png"));
    private JButton driverSchedule1 = new JButton("Driver Schedule",driverIcon1);
    
    ImageIcon reportIcon = new ImageIcon(getClass().getResource("/images/report_1.fw.png"));
    private JButton manageReport = new JButton("Report",reportIcon);
    ImageIcon reportIcon1 = new ImageIcon(getClass().getResource("/images/report.png"));
    private JButton manageReport1 = new JButton("Report",reportIcon1);
    
    ImageIcon insuranceIcon = new ImageIcon(getClass().getResource("/images/insurance_1.fw.png"));
    private JButton insurance = new JButton("Insurance",insuranceIcon);
    ImageIcon insuranceIcon1 = new ImageIcon(getClass().getResource("/images/insurance.png"));
    private JButton insurance1 = new JButton("Insurance",insuranceIcon1);
    
    private JMenuItem jmiManageBus,jmiManageSchedule,jmiStaff,jmiTicket,jmiReport,jmiInsurance,jmiStaffHelp,jmiTicketHelp,jmiBusHelp,jmiDriverHelp,jmiInsuranceHelp;
    Staff staff = new Staff();

    public mainMenu(Staff staff){
        setContentPane(new JLabel(backgroud));
        this.staff = staff;
        //if(position.equals("clerk")){
            //manageStaff.setEnabled(false);
      //  }
        
        
        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);
        
        JMenu staffMenu = new JMenu("Staff");
        staffMenu.setMnemonic('S');
        staffMenu.add(jmiStaff = new JMenuItem("1.Manage Staff",'1'));
        jmb.add(staffMenu);
        
        
        JMenu ticketMenu = new JMenu("Ticket");
        ticketMenu.setMnemonic('T');
        ticketMenu.add(jmiTicket = new JMenuItem("1.Manage Ticket",'1'));
        jmb.add(ticketMenu);
        
        JMenu Bus = new JMenu("Bus");
        Bus.setMnemonic('B');
        jmb.add(Bus);
        Bus.add(jmiManageBus = new JMenuItem("1.Bus Infomation",'1'));
        Bus.add(jmiManageSchedule = new JMenuItem("2.Bus Schedule",'2'));
        
        JMenu Insurance = new JMenu("Insurance");
        Insurance.setMnemonic('I');
        jmb.add(Insurance);
        Insurance.add(jmiInsurance = new JMenuItem("1.Manage Insurance",'1'));
        
        JMenu report = new JMenu("Report");
        jmb.add(report);
        report.setMnemonic('R');
        report.add(jmiReport = new JMenuItem("1.Report Information",'1'));
        
        JMenu help = new JMenu("Help");
        help.setMnemonic('H');
        jmb.add(help);
        help.add(jmiStaffHelp = new JMenuItem("1.Staff Help",'1'));
        help.add(jmiTicketHelp = new JMenuItem("2.Ticket Help",'2'));
        help.add(jmiBusHelp = new JMenuItem("3.Bus Help",'3'));
        help.add(jmiDriverHelp = new JMenuItem("4.Driver Schedule Help",'4'));
        help.add(jmiInsuranceHelp = new JMenuItem("5.Insurance Help",'5'));
        
        
        jmiManageBus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
        jmiManageSchedule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.CTRL_MASK));
        jmiStaff.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
        jmiInsurance.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
        jmiTicket.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
        jmiReport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
        jmiStaffHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
        jmiTicketHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.CTRL_MASK));
        jmiBusHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.CTRL_MASK));
        jmiDriverHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,ActionEvent.CTRL_MASK));
        jmiInsuranceHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5,ActionEvent.CTRL_MASK));
        
        if(staff.getPosition().equals("Driver")){
            manageStaff.setEnabled(false);
            ticket.setEnabled(false);
            busSchedule.setEnabled(false);
            manageReport.setEnabled(false);
            insurance.setEnabled(false);
            
            jmiStaff.setEnabled(false);
            jmiManageBus.setEnabled(false);
            jmiManageSchedule.setEnabled(false);
            jmiTicket.setEnabled(false);
            jmiReport.setEnabled(false);
            
        }
        if(staff.getPosition().equals("Receptionist")){
            manageStaff.setEnabled(false);
            driverSchedule.setEnabled(false);
            busSchedule.setEnabled(false);
            manageReport.setEnabled(false);
            insurance.setEnabled(false);
            
            jmiStaff.setEnabled(false);
            jmiManageBus.setEnabled(false);
            jmiManageSchedule.setEnabled(false);
            jmiReport.setEnabled(false);
            jmiInsurance.setEnabled(false);
            
            
        }
        if(staff.getPosition().equals("Clerk")){
            
            ticket.setEnabled(false);
            manageReport.setEnabled(false);
            
            jmiTicket.setEnabled(false);
            jmiReport.setEnabled(false);
            
        }
        
        setLayout(new GridLayout());
        JPanel p2 = new JPanel(new GridLayout(1,10)); 
        p2.setOpaque(false);
        
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(Quit);
        //Quit.addActionListener(new quit());
        Quit.setContentAreaFilled(false);
        Quit.setRolloverIcon(q2);
        Quit.setBorder(null);
        
        manageStaff.setContentAreaFilled(false);
        manageStaff.setRolloverIcon(staffIcon1);
        manageStaff.setBorder(null);
        
        ticket.setContentAreaFilled(false);
        ticket.setRolloverIcon(ticketIcon1);
        ticket.setBorder(null);
        
        busSchedule.setContentAreaFilled(false);
        busSchedule.setRolloverIcon(busIcon1);
        busSchedule.setBorder(null);
        
        driverSchedule.setContentAreaFilled(false);
        driverSchedule.setRolloverIcon(driverIcon1);
        driverSchedule.setBorder(null);
        driverSchedule.setEnabled(false);
        
        manageReport.setContentAreaFilled(false);
        manageReport.setRolloverIcon(reportIcon1);
        manageReport.setBorder(null);
        manageReport.setEnabled(false);
        
        insurance.setContentAreaFilled(false);
        insurance.setRolloverIcon(insuranceIcon1);
        insurance.setBorder(null);
        
        
        add(p2, BorderLayout.NORTH);
        
        JPanel p = new JPanel(new GridLayout(2,6));
         p.setOpaque(false);
         p.add(manageStaff);
         p.add(new JLabel());
         p.add(ticket);
  
         p.add(new JLabel(""));
         p.add(busSchedule);
         p.add(driverSchedule);
         p.add(new JLabel(""));
         p.add(manageReport);
         p.add(new JLabel(""));
         p.add(insurance);
         add(p, BorderLayout.CENTER);
         
         
         manageStaff.setContentAreaFilled(false);
         manageStaff.setForeground(Color.BLACK);
         manageStaff.setBorder(null);
         manageStaff.setHorizontalTextPosition(SwingConstants.CENTER);
         manageStaff.setVerticalTextPosition(SwingConstants.BOTTOM);
         
         ticket.setContentAreaFilled(false);
         ticket.setForeground(Color.BLACK);
         ticket.setBorder(null);
         ticket.setHorizontalTextPosition(SwingConstants.CENTER);
         ticket.setVerticalTextPosition(SwingConstants.BOTTOM);
         
         busSchedule.setContentAreaFilled(false);
         busSchedule.setForeground(Color.BLACK);
         busSchedule.setBorder(null);
         busSchedule.setHorizontalTextPosition(SwingConstants.CENTER);
         busSchedule.setVerticalTextPosition(SwingConstants.BOTTOM);
         
         driverSchedule.setContentAreaFilled(false);
         driverSchedule.setForeground(Color.BLACK);
         driverSchedule.setBorder(null);
         driverSchedule.setHorizontalTextPosition(SwingConstants.CENTER);
         driverSchedule.setVerticalTextPosition(SwingConstants.BOTTOM);
         
         manageReport.setContentAreaFilled(false);
         manageReport.setForeground(Color.BLACK);
         manageReport.setBorder(null);
         manageReport.setHorizontalTextPosition(SwingConstants.CENTER);
         manageReport.setVerticalTextPosition(SwingConstants.BOTTOM);
         
         insurance.setContentAreaFilled(false);
         insurance.setForeground(Color.BLACK);
         insurance.setBorder(null);
         insurance.setHorizontalTextPosition(SwingConstants.CENTER);
         insurance.setVerticalTextPosition(SwingConstants.BOTTOM);
         
         manageStaff.addActionListener(new staffMenu());
         ticket.addActionListener(new ticketMenu());
         busSchedule.addActionListener(new busMenu());
         driverSchedule.addActionListener(new driverMenu());
         manageReport.addActionListener(new reportMenu());
         insurance.addActionListener(new insuranceMenu());
         Quit.addActionListener(new quit());
         
         jmiManageBus.addActionListener(new busInfoMenu());
         jmiManageSchedule.addActionListener(new busScheduleMenu());
         jmiStaff.addActionListener(new staffMenu());
         jmiInsurance.addActionListener(new insuranceMenu());
         jmiTicket.addActionListener(new ticketMenu());
         jmiReport.addActionListener(new reportMenu());
         
         jmiStaffHelp.addActionListener(new sHelp());
         jmiTicketHelp.addActionListener(new tHelp());
         jmiBusHelp.addActionListener(new bHelp());
         jmiDriverHelp.addActionListener(new dHelp());
         jmiInsuranceHelp.addActionListener(new iHelp());
      
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(1400,1000);
        setTitle("MainPage");
        setLocationRelativeTo(null);
        //setUndecorated(true);
    }
    
    private class staffMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new staffUI(staff);
            setVisible(false);
        }
    }
    
    
    private class ticketMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new TicketUI(staff);
            setVisible(false);
        }
    }
    
    private class busMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new BusUI(staff);
            setVisible(false);
        }
    }
    
    private class driverMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new DriverSchedule();
            
        }
    }
    
    private class reportMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
        }
    }
    
    private class insuranceMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new InsuranceUI(staff);
            setVisible(false);
        }
    }
    
    private class busScheduleMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new BusScheduleUI(staff);
            setVisible(false);
        }
    }
    
    private class busInfoMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new BusInformationUI(staff);
            setVisible(false);
        }
    }
    
    private class bHelp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
           JOptionPane.showMessageDialog(null, "1.	Bus Inside have two button, first is Manage bus, Second  is Mange Schedule.\n\n" +
                                               "2.	 Manage Bus have four button is create, retrieve, update and delete. \n\n" +
                                               "3.	Press first button to add the bus info, second button is use to search bus info, third is update bus information, fourth is delete bus information.\n\n" +
                                               "4.	Manage Schedule have four button is create, retrieve, update and delete. \n\n" +
                                               "5.	Press first button to add the schedule information, second button is use to search, third is update schedule information, fourth is delete schedule information.");
        }
    }
    private class sHelp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,"1.	Inside Manage staff button have four button is create, retrieve, update and delete. \n\n"  +
                                               "2.	Press first button to add the staff info, second button is use to search staff Information, \n  third is update staff information, fourth is delete staff information.");
        }
    }
    private class dHelp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "1.	Driver schedule is allow driver check schedule.");
        }
    }
    private class tHelp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
             JOptionPane.showMessageDialog(null, "1.	Inside Ticket have three button, first is purchase ticket, Second  is Check Purchase information,third is Check Payment Detail. \n\n" + 
                                                 "2.	Press first button to the purchase and payment ticket, second button is use to search Purchase Information, \n  third is search Payment information.");
        }
    }
    
    private class iHelp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,"1.	Inside innsurance button have four button is create, retrieve, update and delete. \n\n"  +
                                               "2.	Press first button to add the insurance info, second button is use to search insurance Information, \n  third is update Insurance information, fourth is delete insurance information.");
        }
    }
    
    private class quit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
             new LoginPage();
             setVisible(false);
        }
}
    
   
    
    public static void main(String[] args) {
        //new mainMenu();
    }
}