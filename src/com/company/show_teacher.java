package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class show_teacher extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTable t1;
    JButton b1, b2, b3;
    JTextField t2;
    String x[]={"Name","ID","Age","DOB","Email","Aadhar no.","Class X(%)","Class XII(%)","Branch","Course"};
    String y[][] = new String[20][11];
    int i = 0, j = 0;

    show_teacher()
    {
        super("Teacher Detail");
        setSize(1260, 650);
        setLocation(200, 100);
        setLayout(null);

        l1 = new JLabel("Enter teacher id to be deleted ");
        l1.setBounds(50,360, 300, 30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);

        t2 = new JTextField();
        t2.setBounds(370,360, 200, 30);
        t2.setFont(new Font("serif",Font.BOLD,20));
        add(t2);

        b1 = new JButton("Delete");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(620, 360, 100, 30);
        add(b1);

        l2 = new JLabel("Add new Teacher");
        l2.setBounds(50,450, 400,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        add(l2);

        b2 = new JButton("Add Teacher");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300, 450, 150, 30);
        add(b2);

        l3 = new JLabel("Update Teacher Detail");
        l3.setBounds(50,490, 400,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        add(l3);

        b3 = new JButton("Teacher update ");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(300, 490, 150, 30);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        try
        {
            conn c1 = new conn();
            String s1 = "SELECT * FROM teacher";
            ResultSet rs = c1.s.executeQuery(s1);
            while(rs.next())
            {
                y[i][j++]= rs.getString("name");
                y[i][j++]= rs.getString("id");
                y[i][j++]= rs.getString("age");
                y[i][j++]= rs.getString("DOB");
                y[i][j++]= rs.getString("Email");
                y[i][j++]= rs.getString("Aadhar_no");
                y[i][j++]= rs.getString("phone_no");
                y[i][j++]= rs.getString("X");
                y[i][j++]= rs.getString("XII");
                y[i][j++]= rs.getString("education");
                y[i][j++]= rs.getString("department");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20, 20,1200,330);
        add(sp);

        getContentPane().setBackground(Color.WHITE);
        b1.addActionListener(this);

        JLabel l13 = new JLabel();
        l13.setBounds(0,0,1500 ,700);
        l13.setLayout(null);
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\15.jpg"));
        Image i2 = ic1.getImage().getScaledInstance(1900,950,Image.SCALE_DEFAULT);
        ImageIcon icon4 = new ImageIcon((i2));
        l13.setIcon(icon4);
        add(l13);

    }


    @Override
    public void actionPerformed(ActionEvent ae) {

        conn c1 = new conn();
        if(ae.getSource() == b1)
        {
            try
            {
                String  a= t2.getText();
                String q = "DELETE FROM teacher WHERE id = '"+a+"'";
                c1.s.executeUpdate(q);
                this.setVisible(false);
                new show_teacher().setVisible(true);
            } catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == b2)
        {
            new new_teacher().setVisible(true);
            this.setVisible(false);
        }
        else if (ae.getSource() == b3)
        {
            new Updates_teacher().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        show_teacher t = new show_teacher();
        t.setVisible(true);
    }
}
