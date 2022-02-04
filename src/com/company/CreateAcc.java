package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class CreateAcc extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b;
    JPasswordField t8;


    CreateAcc()
    {
        super("New Account");
        l1 = new JLabel("Full Name ");
        l1.setBounds(150, 60, 100 , 30);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(300, 60, 150 , 30);
        add(t1);



        l2 = new JLabel("DOB");
        l2.setBounds(150, 120, 100 , 30);
        add(l2);

        t2 = new JTextField("dd/mm/yy");
        t2.setBounds(300, 120, 150 , 30);
        add(t2);



        l3 = new JLabel("Mail");
        l3.setBounds(150, 180, 100 , 30);
        add(l3);

        t3 = new JTextField("@gmail.com");
        t3.setBounds(300, 180,100 , 30);
        add(t3);



        l4 = new JLabel("Phone No.");
        l4.setBounds(150, 240, 100 , 30);
        add(l4);

        t4 = new JTextField();
        t4.setBounds(300, 240, 150 , 30);
        add(t4);



        l5 = new JLabel("College Name ");
        l5.setBounds(150, 300, 150 , 30);
        add(l5);

        t5 = new JTextField("school/college");
        t5.setBounds(300, 300,200 , 30);
        add(t5);

        l6 = new JLabel("Username");
        l6.setBounds(150, 360, 100 , 30);
        add(l6);

        t6 = new JTextField();
        t6.setBounds(300, 360, 150 , 30);
        add(t6);

        l7 = new JLabel("Create Password");
        l7.setBounds(150, 420, 100 , 30);
        add(l7);

        t7 = new JTextField();
        t7.setBounds(300, 420, 150 , 30);
        add(t7);

        l8 = new JLabel("Confirm Password");
        l8.setBounds(150, 470, 150 , 30);
        add(l8);

        t8 = new JPasswordField();
        t8.setBounds(300, 470, 150 , 30);
        add(t8);

        b = new JButton("Submit");
        b.setBounds(750,510,100,30);
        add(b);

        b.addActionListener(this);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\2.jpg"));
        Image i1 = ic.getImage().getScaledInstance(1900,950,Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon((i1));
        JLabel l9 = new JLabel(icon3);
        add(l9);


        setLayout(null);
        setVisible(true);
        setBounds(300,80,900,600);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String a = t6.getText();
        String b1 = t7.getText();
        String b2 = t8.getText();
        if( ae.getSource() == b )
        {
            if(b1.equals(b2)) {
                try {
                    conn c1 = new conn();

                    String q = "insert into login values ('" + a + "' ,'" + b2 + "')";
                    int rs = c1.s.executeUpdate(q);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Account created");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Password not match!");

            }
        }
    }




    public static void main(String[] args) {
        CreateAcc a = new CreateAcc();
    }
}
