package supermarketsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
   
    JButton login,clear;
    JTextField ct;
    JPasswordField pt;
    
    Login(){
        setTitle("BIG BITES MART");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("BIG BITES MART");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,700,60);
        add(text);
        
        JLabel username = new JLabel("Username");
        username.setFont(new Font("Serif", Font.BOLD, 25));
        username.setBounds(125,135,300,75);
        add(username);
        
        ct = new JTextField(15);
        ct.setBounds(300,150,230,30);
        ct.setFont(new Font("Arial", Font.BOLD, 14));
        add(ct);
        
        JLabel pin = new JLabel("Password:");
        pin.setFont(new Font("Serif", Font.BOLD, 25));
        pin.setBounds(125,250,375,30);
        add(pin);
        
        pt = new JPasswordField(15);
        pt.setFont(new Font("Arial", Font.BOLD, 14));
        pt.setBounds(300,250,230,30);
        add(pt);
        
        login = new JButton("LOGIN");
        login.setBounds(300,350,100,50);
        login.setBackground(Color.ORANGE);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,350,100,50);
        clear.setBackground(Color.RED);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);
       
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            ct.setText("");
            pt.setText("");
            
        }
        else if(ae.getSource() ==  login){
            Conn conn= new Conn();
            String username = ct.getText();
            String pinnumber = pt.getText();
            String query = "select * from login where username = '"+username+"' and password = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Menu().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Credentials");
                    
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
    
}