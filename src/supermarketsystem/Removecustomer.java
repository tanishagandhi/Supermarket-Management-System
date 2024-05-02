
package supermarketsystem;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Removecustomer extends JFrame implements ActionListener {
    Choice crollno;
    JTable table;
    JButton search, delete, cancel;
    
    Removecustomer()
    {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Customer Id");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customerdetails");
            while(rs.next()) {
                crollno.add(rs.getString("customerid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customerdetails");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        delete = new JButton("Delete");
        delete.setBounds(220, 70, 80, 20);
        delete.addActionListener(this);
        add(delete);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == search)
        {
            String query = "select * from customerdetails where customerid = '"+crollno.getSelectedItem()+"'";
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == delete)
        {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Customer?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                String rollno = crollno.getSelectedItem();
                
                try {
                    String query = "delete from customerdetails where customerid='" + rollno + "'";
                    Conn con = new Conn();
                    con.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Customer Information Deleted Successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            setVisible(false);
            new Menu().setVisible(true);
        }
    }
    
    public static void main (String[] args)
    {
        new Removecustomer();
    }
}
