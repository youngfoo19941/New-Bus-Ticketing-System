package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import da.StaffDA;
import domain.Staff;
import control.MaintainStaff;

//import javafx.scene.layout.Border;

public class LoginPage extends JFrame{

    ImageIcon backgroud = new ImageIcon(getClass().getResource("/images/Background_1.jpg"));
    ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/Logo.png"));
    private MaintainStaff staffMaintain;
    private JLabel logo = new JLabel(logoIcon);
    private JLabel staffID = new JLabel("       Staff ID         ", JLabel.CENTER);
    private JTextField staffText = new JTextField();
    private JLabel Password = new JLabel("Password    ", JLabel.CENTER);
    private JPasswordField passwordText = new JPasswordField();
    private JButton jbtLogin = new JButton("Login");
    private JButton jbtReset = new JButton("Reset");
     private JButton jbtRecovery = new JButton("Recovery");


    public LoginPage(){
        staffMaintain = new MaintainStaff();
        setTitle("Login");
        setContentPane(new JLabel(backgroud));
        setLayout(new FlowLayout());
        
        JPanel panel1 = new JPanel();
        panel1.add(logo);
        panel1.setOpaque(false);
        add(panel1);
        
        JPanel panel2 = new JPanel(new GridLayout(5,2));
        
        panel2.add(new JLabel(""));
        panel2.add(new JLabel(""));
        panel2.add(new JLabel(""));
        panel2.add(new JLabel(""));
        panel2.add(staffID);
                    staffID.setForeground(Color.BLACK);
        panel2.add(staffText);
        panel2.add(new JLabel(""));
        panel2.add(new JLabel(""));
        panel2.add(Password);
                    Password.setForeground(Color.BLACK);
        panel2.add(passwordText);
        panel2.setOpaque(false);
        add(panel2);
        
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel3.add(jbtLogin);
        panel3.add(jbtReset);
        panel3.add(jbtRecovery);
        panel3.setOpaque(false);
        add(panel3);
        
        JPanel BigPanel = new JPanel(new GridLayout(3,2));
        BigPanel.add(panel1);
        BigPanel.add(panel2);
        BigPanel.add(panel3);
        BigPanel.setOpaque(false);
        add(BigPanel);
      
        setVisible(true);
        setSize(1000,650);
        
        setLocationRelativeTo(null);
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/v.png")));
        jbtLogin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                Staff staff = staffMaintain.selectRecord(staffText.getText());
                if(staff != null){
                    if(passwordText.getText().equals(staff.getPassword())){
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new mainMenu(staff);
                    setVisible(false);
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Staff ID or Password incorrect");
                    passwordText.setText("");
                }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Staff ID Are not exists");
                    staffText.setText("");
                    passwordText.setText("");
                }
                
            
            }
            });
        jbtRecovery.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Staff staff = staffMaintain.selectRecord(staffText.getText());
                if(staff != null){
                String input = JOptionPane.showInputDialog(null,"Please enter IC number","Password Recovery",JOptionPane.QUESTION_MESSAGE);
                if(input.equals(staff.getIC())){
                    String input1 = JOptionPane.showInputDialog(null,"Please enter a new password","Password Recovery",JOptionPane.QUESTION_MESSAGE);
                    staff = new Staff(staff.getID(),staff.getName(), staff.getIC(), staff.getAddress(), input1, staff.getGender(), staff.getPosition(),staff.getAge(),staff.getcontactNo(),staff.getEmail()); 
                    staffMaintain.updatepassword(staff);
                    JOptionPane.showMessageDialog(null, "Change password successful");
                }
                else{
                    JOptionPane.showMessageDialog(null,"IC is incorrect");
                }
                
                }
                else{
                     JOptionPane.showMessageDialog(null, "Staff ID not found");
                }
                    
                }
 
            });
        jbtReset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 staffText.setText("");
                    passwordText.setText("");
 
            }});
       
        
    }
    
    public static void main(String[] args) {
        new LoginPage();
    }
}