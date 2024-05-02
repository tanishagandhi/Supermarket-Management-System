
package supermarketsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Additems extends JFrame implements ActionListener {
    JTextField tfname, tfx, tfxii,tq;
    JButton submit, cancel;
    
    Additems(){
        setSize(900, 700);
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel heading = new JLabel("Add New Item Details in the Inventory");
        heading.setBounds(250, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        JLabel lblx = new JLabel("Product Id");
        lblx.setBounds(150, 150, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(500, 150, 200, 30);
        add(tfx);
        
        JLabel lblname = new JLabel("Product Name");
        lblname.setBounds(150, 200, 200, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(500, 200, 200, 30);
        add(tfname);
        
        JLabel lblxii = new JLabel("MRP");
        lblxii.setBounds(150, 250, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(500, 250, 200, 30);
        add(tfxii);
        
        JLabel quant = new JLabel("Quantity");
        quant.setBounds(150, 300, 200, 30);
        quant.setFont(new Font("serif", Font.BOLD, 20));
        add(quant);
        
        tq= new JTextField();
        tq.setBounds(500, 300, 200, 30);
        add(tq);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 400, 120, 30);
        submit.setBackground(Color.YELLOW);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 400, 120, 30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String product=tfx.getText();
            String name = tfname.getText();
            String mrp=tfxii.getText();
            String quant = tq.getText();
            
            try {
                String query = "insert into additems values('"+product+"', '"+name+"', '"+mrp+"', '"+quant+"')";

                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Item Details Inserted Successfully");
                setVisible(false);
                new Menu().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Menu().setVisible(true);
        }
    }

    public static void main(String args[]) {
         new Additems();
    }
}
