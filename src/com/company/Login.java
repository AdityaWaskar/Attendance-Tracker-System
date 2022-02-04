package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2, b3;

    Login()
    {
        super("Login");

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100 , 30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100 , 30);
        add(l2);

        t1 = new JTextField("username");
        t1.setBounds(150, 20, 150 , 30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150 , 30);
        add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(160,140,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,50,130,150);
        add(l3);

        b1 = new JButton(("Login"));
        b1.setBounds(80,130,130,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton(("Cancal"));
        b2.setBounds(160,185,95,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b3 = new JButton(("New"));
        b3.setBounds(40,185,95,30);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setLocation(500,200);
        setSize(600,300);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try
            {
                conn c1 = new conn();
                String u = t1.getText();
                String v = t2.getText();

                String q = "select * from login where username='"+u+"' and password='"+v+"'";
                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next())
                {
                    new Project().setVisible(true);
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid login");
//                    setVisible(false);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == b3)
        {
            CreateAcc New = new CreateAcc();
            New.setVisible(true);
        }
        else if(ae.getSource() == b2)
        {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new Login();

    }
}
