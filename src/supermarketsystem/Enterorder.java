
package supermarketsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Enterorder extends JFrame implements ActionListener {
    
    JTextField tfpname,tfcname,tfquant,tfamt,tfmethod,tfaddress;
    JButton cancel, submit;
    
    Enterorder() {
        
        setSize(1000, 500);
        setLocation(300, 150);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/order.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        add(image);
        
        JLabel heading = new JLabel("Enter Order Details");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
       
       
        JLabel lblentersubject = new JLabel("Enter Product Name");
        lblentersubject.setBounds(50, 50, 200, 40);
        add(lblentersubject);
        
        tfpname = new JTextField();
        tfpname.setBounds(200, 50, 200, 20);
        add(tfpname);
        
        JLabel lblentermarks = new JLabel("Enter Customer Name");
        lblentermarks.setBounds(50, 100, 200, 40);
        add(lblentermarks);
        
        
        tfcname = new JTextField();
        tfcname.setBounds(200, 100, 200, 20);
        add(tfcname);
        
        JLabel quant = new JLabel("Quantity");
        quant.setBounds(50, 150, 200, 40);
        add(quant);
        
        tfquant = new JTextField();
        tfquant.setBounds(200, 150, 200, 20);
        add(tfquant);
        
        JLabel p = new JLabel("Total price");
        p.setBounds(50, 200, 200, 40);
        add(p);
        
        tfamt = new JTextField();
        tfamt.setBounds(200, 200, 200, 20);
        add(tfamt);
        
        JLabel m = new JLabel("Payment method");
        m.setBounds(50, 250, 200, 40);
        add(m);
        
        tfmethod = new JTextField();
        tfmethod.setBounds(200, 250, 200, 20);
        add(tfmethod);
        
        JLabel a= new JLabel("Address");
        a.setBounds(50, 300, 200, 40);
        add(a);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 300, 200, 20);
        add(tfaddress);
        
        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(280, 360, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                Conn c = new Conn();
                
                String query1 = "insert into orderdetails values('"+tfpname.getText()+"', '"+tfcname.getText()+"', '"+tfquant.getText()+"', '"+tfamt.getText()+"', '"+tfmethod.getText()+"', '"+tfaddress.getText()+"')";
            
                c.s.executeUpdate(query1);
                
                JOptionPane.showMessageDialog(null, "Order Placed Sucessfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Enterorder();
    }
}