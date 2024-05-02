
package supermarketsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Menu extends JFrame implements ActionListener{
    
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    Menu(){
        setSize(1540,850);
        setTitle("BIG BITES MART");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/menu1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i3);
        l2.setBounds(0, 0, 1540, 850);
        add(l2);
        
        l1 = new JLabel("BIG BITES MANAGEMENT SYSTEM");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 35));
        l1.setBounds(380,50,700,35);
        l2.add(l1);
        
       
        b1 = new JButton("ADD CUSTOMER");
        b1.setBounds(300,125,220,35);
        l2.add(b1);
        
        b2 = new JButton("ADD EMPLOYEE");
        b2.setBounds(900,125,220,35);
        l2.add(b2);
        
        b3 = new JButton("CUSTOMER DETAILS");
        b3.setBounds(300,250,220,35);
        l2.add(b3);
        
        b4 = new JButton("EMPLOYEE DETAILS");
        b4.setBounds(900,250,220,35);
        l2.add(b4);
        
        b5 = new JButton("REMOVE CUSTOMER");
        b5.setBounds(300,375,220,35);
        l2.add(b5);
        
        b6 = new JButton("REMOVE EMPLOYEE");
        b6.setBounds(900,375,220,35);
        l2.add(b6);
        
        b7 = new JButton("ENTER ORDER");
        b7.setBounds(300,500,220,35);
        l2.add(b7);
        
        b8 = new JButton("ADD ITEMS");
        b8.setBounds(900,500,220,35);
        l2.add(b8);
        
        
    
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        
//        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            setVisible(false);
            new Addcustomer().setVisible(true);
        }
        else if(ae.getSource()==b2){ 
            setVisible(false);
            new AddEmployee().setVisible(true);}
        else if(ae.getSource()==b3){ 
            setVisible(false);
            new Customerdetails().setVisible(true);}
        else if(ae.getSource()==b4){ 
            setVisible(false);
            new Employeedetails().setVisible(true);}
        else if(ae.getSource()==b5){ 
            setVisible(false);
            new Removecustomer().setVisible(true);
        }
        else if(ae.getSource()==b6){ 
            this.setVisible(false);
            new Removeemployee().setVisible(true);
        }
        else if(ae.getSource()==b7){ 
            setVisible(false);
            new Enterorder().setVisible(true);
        }
        else if(ae.getSource()==b8){ 
            setVisible(false);
            new Additems().setVisible(true);
        }
    }
    
    
    public static void main(String args[]){
        new Menu();
    }
}
