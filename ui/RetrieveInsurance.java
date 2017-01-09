package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import da.ScheduleDA;
import javax.swing.border.TitledBorder;
import da.AllTableModel;
import java.util.regex.PatternSyntaxException;

public class RetrieveInsurance extends JFrame{

    static final String DATABASE_URL = "jdbc:derby://localhost:1527/BusSystem";
    static final String USERNAME = "nbuser";
    static final String PASSWORD = "nbuser";
    static final String DEFAULT = "SELECT PurchaseID,CustomerName,PurchaseDate,CustomerContact,CustomerIC,InsuranceCllaims FROM PurchaseOrder WHERE InsuranceCllaims !=0";
    private AllTableModel tableModel;
    private JTable resultTable;
    private TableRowSorter<TableModel> sorter;
    
    private JTextField filterText = new JTextField(95);
    private JButton Read = new JButton("Read Bus ID");
    private JButton Reset = new JButton("Reset");
    private JButton Back = new JButton("Back");
    
    
    public RetrieveInsurance(){
        try {
            tableModel = new AllTableModel(DATABASE_URL, USERNAME, PASSWORD,DEFAULT);
            resultTable = new JTable(tableModel);
            
            JPanel r = new JPanel(new FlowLayout());
            r.setBorder(new TitledBorder("Insurance Information"));
            r.add(filterText);
            r.add(Read);
            r.add(Reset);
            
            add(r,BorderLayout.NORTH);
                filterText.addActionListener(new searchFunction());
                Read.addActionListener(new ReadListener());
            
            Reset.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                filterText.setText("");
                try{
                tableModel.setQuery(DEFAULT);
                }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error1", JOptionPane.ERROR_MESSAGE);
                }
            }
            });
            
            Back.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setVisible(false);
                }
            });
            
            add(new JScrollPane(resultTable), BorderLayout.CENTER);

            sorter = new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);
            // ensure database connection is closed when user quits application
            addWindowListener(new WindowCloseListener());
            
            JPanel backButton = new JPanel();
            backButton.add(Back);
            add(backButton, BorderLayout.SOUTH);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            tableModel.disconnectFromDatabase();
            System.exit(1);
        }
        
        setTitle("Insurance Information");
        setSize(1300,200);
        setLocationRelativeTo(null);
        setUndecorated(true);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/v.png")));
    }
    
    private class ReadListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
       try{ 
            
            
            String query=DEFAULT;
            
            if(!filterText.getText().equals(""))
            query = "SELECT PurchaseID,CustomerName,PurchaseDate,CustomerContact,CustomerIC,InsuranceCllaims FROM PurchaseOrder WHERE PurchaseID= '"+filterText.getText()+"'";
            
            
            
            try {
                tableModel.setQuery(query);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error1", JOptionPane.ERROR_MESSAGE);

                try {
                    
                    tableModel.setQuery(DEFAULT);
                    
                } catch (SQLException ex2) {
                    JOptionPane.showMessageDialog(null, ex2.getMessage(), "Database Error2", JOptionPane.ERROR_MESSAGE);
                    tableModel.disconnectFromDatabase();
                    System.exit(1);
                }
            }
       }catch(IllegalArgumentException ex){
                    if(filterText.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Purchase ID can't be empty !", "INVALID TYPE", JOptionPane.ERROR_MESSAGE);
                        filterText.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "ID Does Not Exits", "ID NOT FOUND", JOptionPane.ERROR_MESSAGE);
                        filterText.setText("");
                    }
       }
    }
    }
    private class searchFunction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = filterText.getText();
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
        new RetrieveInsurance();
    }
}

