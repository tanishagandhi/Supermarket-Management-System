package supermarketsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Homepage extends JFrame implements ActionListener{
    JLabel l1,lable;
    JButton b7;
    
    
    Homepage(){
        
        setSize(1540,850);
        setTitle("BIG BITES MART");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/homepage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 1540, 850);
        add(l2);
        
        l1 = new JLabel("WELCOME TO");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 45));
        l1.setBounds(420,50,700,50);
        l2.add(l1);
        
        lable = new JLabel("BIG BITES MART");
        lable.setForeground(Color.RED);
        lable.setFont(new Font("System", Font.BOLD, 60));
        lable.setBounds(300,100,700,50);
        l2.add(lable);
       
        
        b7 = new JButton("LET'S BEGIN");

        
        b7.setBounds(550,450,140,60);
        b7.addActionListener(this);
        l2.add(b7);
        

        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b7){ 
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[]){
        new Homepage();
    }
}