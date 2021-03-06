package ui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Toolkit;
import da.StaffDA;
import domain.Staff;
import control.MaintainStaff;

public class BusUI extends JFrame{ 
    private JMenuItem jmiManageBus,jmiManageSchedule,jmiStaff,jmiTicket,jmiReport,jmiInsurance,jmiStaffHelp,jmiTicketHelp,jmiBusHelp,jmiDriverHelp,jmiInsuranceHelp;
 
    ImageIcon a = new ImageIcon(getClass().getResource("/images/Background_1.jpg"));
    
    ImageIcon b = new ImageIcon(getClass().getResource("/images/Back.png"));
    private JButton Back = new JButton(b);
    ImageIcon c = new ImageIcon(getClass().getResource("/images/Back1.png"));
    private JButton back = new JButton(c);
    
    ImageIcon q = new ImageIcon(getClass().getResource("/images/exit1.png"));
    private JButton Quit = new JButton(q);
    ImageIcon q2 = new ImageIcon(getClass().getResource("/images/exit.png"));
    private JButton Quit1 = new JButton(q2);
    
    ImageIcon busInfoIcon = new ImageIcon(getClass().getResource("/images/Bus Info_1.fw.png"));
    private JButton jbtbusInfo = new JButton(busInfoIcon);
    ImageIcon busInfoIcon1 = new ImageIcon(getClass().getResource("/images/Bus Info.fw.png"));
    private JButton jbtbusInfo1 = new JButton(busInfoIcon1);
    
    ImageIcon busScheduleIcon = new ImageIcon(getClass().getResource("/images/Schedule_1.fw.png"));
    private JButton jbtbusSchedule = new JButton(busScheduleIcon);
    ImageIcon busScheduleIcon1 = new ImageIcon(getClass().getResource("/images/Schedule.png"));
    private JButton jbtbusSchedule1 = new JButton(busScheduleIcon1);
    Staff staff = new Staff();
public BusUI(Staff staff) {
        
        this.staff = staff;
        
        
    
    setTitle("Bus Page");
    setContentPane(new JLabel(a));
    setLayout(new FlowLayout());
    
        JPanel p2 = new JPanel(new GridLayout(1,9)); 
        p2.setOpaque(false);
        p2.add(Back);
       
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
        
        Back.setContentAreaFilled(false);
        Back.setRolloverIcon(c);
        Back.setBorder(null);
       
        Quit.setContentAreaFilled(false);
        Quit.setRolloverIcon(q2);
        Quit.setBorder(null);
        
        jbtbusInfo.setContentAreaFilled(false);
        jbtbusInfo.setRolloverIcon(busInfoIcon1);
        jbtbusInfo.setBorder(null);
        
        jbtbusSchedule.setContentAreaFilled(false);
        jbtbusSchedule.setRolloverIcon(busScheduleIcon1);
        jbtbusSchedule.setBorder(null);
        add(p2, BorderLayout.NORTH);
    
        JPanel p1 = new JPanel(new GridLayout(1,2));
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout(FlowLayout.LEFT,40,180));
        p1.add(jbtbusInfo);
        p1.add(jbtbusSchedule);
        add(p1,BorderLayout.NORTH);
        
        //jbtAdd.addActionListener(new addBus());
        Back.addActionListener(new back());
        Quit.addActionListener(new quit());
        jbtbusInfo.addActionListener(new busInfo());
        jbtbusSchedule.addActionListener(new busSchedule());
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
            
            jmiStaff.setEnabled(false);
            jmiManageBus.setEnabled(false);
            jmiManageSchedule.setEnabled(false);
            jmiTicket.setEnabled(false);
            jmiReport.setEnabled(false);
            
        }
        if(staff.getPosition().equals("Receptionist")){
            
            jmiStaff.setEnabled(false);
            jmiManageBus.setEnabled(false);
            jmiManageSchedule.setEnabled(false);
            jmiReport.setEnabled(false);
            jmiInsurance.setEnabled(false);
            
            
        }
        if(staff.getPosition().equals("Clerk")){
            
            jmiTicket.setEnabled(false);
            jmiReport.setEnabled(false);
            
        }

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
        

        setSize(1400,950);
        setLocationRelativeTo(null);
        setVisible(true);
}

private class busInfo implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        new BusInformationUI(staff);
        setVisible(false);
    }
}

private class busSchedule implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        new BusScheduleUI(staff);
        setVisible(false);
    }
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

private class back implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new mainMenu(staff);
            setVisible(false);
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
        //new BusUI();
    }   
}