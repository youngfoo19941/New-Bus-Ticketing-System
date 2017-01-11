package ui;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
import da.AllTableModel;

import da.ScheduleDA;
import javax.swing.border.TitledBorder;
import da.AllTableModel;


public class DriverSchedule extends JFrame {

    static final String DATABASE_URL = "jdbc:derby://localhost:1527/BusSystem";
    static final String USERNAME = "nbuser";
    static final String PASSWORD = "nbuser";
    static final String DEFAULT = "SELECT * FROM SCHEDULE";
    
    private AllTableModel tableModel;
    private JTable resultTable;
    private TableRowSorter<TableModel> sorter;
    
    private JTextArea queryArea;
    
    
    private JLabel jlblDate= new JLabel("Date:");
    private JTextField jtfDate= new JTextField(); 
    private JButton button = new JButton("Choose Date");
    private JButton check = new JButton("Check");
    private JButton Cancel = new JButton("Cancel");
    private JButton Reset = new JButton("Reset");
    //add JPanel to the contentPane
    
    public DriverSchedule() {
        try {
            tableModel = new AllTableModel(DATABASE_URL, USERNAME, PASSWORD,DEFAULT);
            resultTable = new JTable(tableModel);
            
            
            jtfDate.setBounds(101, 107, 86, 20);
            //set columns
            jtfDate.setColumns(10);
            jtfDate.setEditable(false);
            Box box1 = Box.createHorizontalBox();
            box1.add(jlblDate);
            box1.add(jtfDate);
            box1.add(button);
            box1.add(check);
            
            Box box2 = Box.createHorizontalBox();
            box2.add(new JScrollPane(resultTable));
            
            
            JPanel LastPanel = new JPanel();
                LastPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
                LastPanel.setOpaque(false);
                LastPanel.add(Reset);
                LastPanel.add(Cancel);
                add(LastPanel);
           
            
            
            button.addActionListener(new ActionListener(){ 
            //performed action
            public void actionPerformed(ActionEvent arg0){
                //create frame new object  f
                 final JFrame f = new JFrame();
                //set text which is collected by date picker i.e. set date 
                jtfDate.setText(new ui.DatePicker(f).setPickedDate());
                
                }
            });
            
            check.addActionListener(new FilterButtonListener());
            Reset.addActionListener(new Reset());
            Cancel.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setVisible(false);
                }
            });
            
            
            
            JPanel p = new JPanel(new GridLayout(3,1)); 
            p.add(box1,BorderLayout.NORTH);
            p.add(box2, BorderLayout.CENTER);
            p.add(LastPanel);
            add(p);
            sorter = new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);
            
           

            // ensure database connection is closed when user quits application
            addWindowListener(new WindowCloseListener());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            tableModel.disconnectFromDatabase();
            System.exit(1);
        }
        setTitle("Displaying Driver Schedule");
        setSize(1000, 250);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
   
    private class FilterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = jtfDate.getText();
            if (text.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                try {
                    sorter.setRowFilter(RowFilter.regexFilter(text));
                } catch (PatternSyntaxException pse) {
                    JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex pattern", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
    }
    private class Reset implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jtfDate.setText("");
            String text = jtfDate.getText();
            if (text.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                try {
                    sorter.setRowFilter(RowFilter.regexFilter(text));
                } catch (PatternSyntaxException pse) {
                    JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex pattern", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
    }

    private class WindowCloseListener extends WindowAdapter {

        @Override
        public void windowClosed(WindowEvent event) {
            tableModel.disconnectFromDatabase();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new DriverSchedule();
        
    }
}
