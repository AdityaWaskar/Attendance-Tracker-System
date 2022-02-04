package com.company;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class new_teacher extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10,l11;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    JButton b1, b2;
    JComboBox c1,c2;
    JDateChooser calendar;

    new_teacher()
    {
        super("New Teacher");
        setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,130,900,600);

        JLabel l = new JLabel("New Teacher Details");
        l.setBounds(350,10,300 , 60);
        l.setFont(new Font("serif",Font.ITALIC,25));
        l.setForeground(Color.BLACK);
        add(l);


        //Labels

        l1 = new JLabel("Full Name ");
        l1.setBounds(100, 120, 100 , 30);
        add(l1);

        l2 = new JLabel("Teacher id");
        l2.setBounds(450, 120, 100 , 30);
        add(l2);

        l3 = new JLabel("Age");
        l3.setBounds(100, 180, 100 , 30);
        add(l3);

        l4 = new JLabel("DOB(dd/mm/yyyy)");
        l4.setBounds(450, 180, 100 , 30);
        add(l4);

        l5 = new JLabel("Email");
        l5.setBounds(100, 240, 100 , 30);
        add(l5);

        l6 = new JLabel("Aadhar no.");
        l6.setBounds(450, 240, 100 , 30);
        add(l6);

        l7 = new JLabel("Phone No.");
        l7.setBounds(100, 300, 100 , 30);
        add(l7);

        l8 = new JLabel("Class X(%)");
        l8.setBounds(450, 300, 100 , 30);
        add(l8);

        l9 = new JLabel("Class XII(%)");
        l9.setBounds(100, 360, 100 , 30);
        add(l9);


        l10 = new JLabel("Department");
        l10.setBounds(100, 420, 150 , 30);
        add(l10);

        l11 = new JLabel("Education");
        l11.setBounds(450, 360, 100 , 30);
        add(l11);

        //Taking input
        t1 = new JTextField();
        t1.setBounds(200, 120, 150 , 30);
        add(t1);

        t2 = new JTextField();
        t2.setBounds(550, 120, 150 , 30);
        add(t2);

        t3 = new JTextField();
        t3.setBounds(200, 180, 150 , 30);
        add(t3);

        calendar = new JDateChooser();
        calendar.setDateFormatString("yyyy-MM-dd");
        calendar.setBounds(550, 180, 150 , 30);
        add(calendar);

        t5 = new JTextField();
        t5.setBounds(200, 240, 150 , 30);
        add(t5);

        t6 = new JTextField();
        t6.setBounds(550, 240, 150 , 30);
        add(t6);

        t7 = new JTextField();
        t7.setBounds(200, 300, 150 , 30);
        add(t7);

        t8 = new JTextField();
        t8.setBounds(550, 300, 150 , 30);
        add(t8);

        t9 = new JTextField();
        t9.setBounds(200,360,150,30);
        add(t9);

        String branch[] = {"Information Technology","Computer Science","Mechanical Engineering","Civil Engineering","Electrical Engineering","Electronics and Communication Engineering"};
        c2 = new JComboBox(branch);
        c2.setBackground(Color.WHITE);
        c2.setBounds(200, 420, 150 , 30);
        add(c2);

        String course[] = {"B.Tech","BE","Bsc","BBA","Msc","MCA","BA","BCom"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(550, 360, 150 , 30);
        add(c1);

        b1 = new JButton(("Cancel"));
        b1.setBounds(450,470,130,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton(("Summit"));
        b2.setBounds(250,470,130,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        JLabel l13 = new JLabel();
        l13.setBounds(0,0,1250 ,700);
        l13.setLayout(null);
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\15.jpg"));
        Image i2 = ic1.getImage().getScaledInstance(1900,950,Image.SCALE_DEFAULT);
        ImageIcon icon4 = new ImageIcon((i2));
        l13.setIcon(icon4);
        add(l13);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String a = t1.getText();
        String b = t2.getText();
        String c = t3.getText();
        Date date = calendar.getDate();
        DateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
        String d = d1.format(date);// Getting and format the date text.
        System.out.println(d);
        String e = t5.getText();
        String f = t6.getText();
        String g = t7.getText();
        String h = t8.getText();
        String i = t9.getText();
        String j = (String)c1.getSelectedItem();
        String k = (String)c2.getSelectedItem();
        if( ae.getSource() == b2 )
        {
            try
            {
                conn cc = new conn();
                String q = "INSERT INTO teacher VALUES('" + a + "','" + b + "','" + c + "','" + d + "','" + e + "','" + f + "','" + g + "','" + h + "','" + i + "','" + j + "','" + k + "')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Teacher data insert successfully");
                setVisible(false);
            }
            catch (Exception ee)
            {
                JOptionPane.showMessageDialog(null, ee);
                System.out.println("The error is : "+ee);
            }
        }
        else if ( ae.getSource() == b1)
        {
            setVisible(false);
//            new Project().setVisible(true);
        }

    }


    public static void main(String[] args) {
        new_teacher a = new new_teacher();
        a.setVisible(true);
    }
}
