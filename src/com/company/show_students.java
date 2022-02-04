package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class show_students extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTable t1;
    JButton b1, b2, b3;
    JTextField t2;
    String x[]={"Name","ID","Div","DOB","Email","Aadhar no.","Class X(%)","Class XII(%)","Year","Branch"};
    String y[][] = new String[120][10];
    int i = 0, j = 0;

    show_students()
    {
        super("student details");

        l1 = new JLabel("Enter roll no to be delete student ");
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

        l2 = new JLabel("Add new Student: ");
        l2.setBounds(50,450, 400,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        add(l2);

        b2 = new JButton("Add Student ");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300, 450, 150, 30);
        add(b2);

        l3 = new JLabel("Update Student Detail : ");
        l3.setBounds(50,490, 400,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        add(l3);

        b3 = new JButton("Update student ");
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
            String s1 = "SELECT * FROM student;";
            ResultSet rs = c1.s.executeQuery(s1);
            while(rs.next())
            {
                y[i][j++]= rs.getString("name");
                y[i][j++]= rs.getString("id");
                y[i][j++]= rs.getString("division");
                y[i][j++]= rs.getString("DOB");
                y[i][j++]= rs.getString("Email");
                y[i][j++]= rs.getString("Aadhar_no");
                y[i][j++]= rs.getString("X");
                y[i][j++]= rs.getString("XII");
                y[i][j++]= rs.getString("Year");
                y[i][j++]= rs.getString("course");
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

        JLabel l13 = new JLabel();
        l13.setBounds(0,0,1260 ,650);
        l13.setLayout(null);
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\15.jpg"));
        Image i2 = ic1.getImage().getScaledInstance(1900,950,Image.SCALE_DEFAULT);
        ImageIcon icon4 = new ImageIcon((i2));
        l13.setIcon(icon4);
        add(l13);

        setSize(1260, 650);
        setLocation(200, 100);
        setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == b1)
        {
        String  a= t2.getText();
        System.out.println(a);
        String []year1 = new String[1];
            try {
                try {
                    conn c2 = new conn();
                    String q1 = "select year from student where id = '" + a + "';";
                    ResultSet rs1 = c2.s.executeQuery(q1);
                    int i = 0;
                    while (rs1.next()) {
                        year1[i] = rs1.getString("year");
                        i++;
                        System.out.println(year1[0]);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                try {
                    conn c1 = new conn();
                    String q = "DELETE FROM student WHERE id = '" + a + "';";
                    c1.s.executeUpdate(q);
                } catch (Exception e) {
                }
            }
            catch(Exception e){}

            if(year1[0].equals("FE"))
            {
                try
                {
                System.out.println(a);
                    conn c1 = new conn();
                    String q2 = " alter table bee_fe_attendance drop column a"+a+" ;";
                    c1.s.executeUpdate(q2);
                    String q3 = "delete from bee_fe_defaulter where id = "+a+" ;";
                    c1.s.executeUpdate(q3);
                    String q4 = " alter table mech_fe_attendance drop column a"+a+" ;";
                    c1.s.executeUpdate(q4);
                    String q5 = "delete from mech_fe_defaulter where id = "+a+" ;";
                    c1.s.executeUpdate(q5);
                }
                catch(Exception e){}
            }
            if(year1[0].equals("SE"))
            {
                try
                {
                System.out.println(a);
                    conn c1 = new conn();
                    String q2 = " alter table dsa_se_attendance drop column a"+a+" ;";
                    c1.s.executeUpdate(q2);
                    String q3 = "delete from dsa_se_defaulter where id = "+a+" ;";
                    c1.s.executeUpdate(q3);
                    String q4 = " alter table java_se_attendance drop column a"+a+" ;";
                    c1.s.executeUpdate(q4);
                    String q5 = "delete from java_se_defaulter where id = "+a+" ;";
                    c1.s.executeUpdate(q5);
                }
                catch(Exception e){}
            }
            if(year1[0].equals("TE"))
            {
                try
                {
                    System.out.println(a);
                    conn c1 = new conn();
                    String q2 = " alter table math_te_attendance drop column a"+a+" ;";
                    c1.s.executeUpdate(q2);
                    String q3 = "delete from math_te_defaulter where id = "+a+" ;";
                    c1.s.executeUpdate(q3);
                    String q4 = " alter table dbms_te_attendance drop column a"+a+" ;";
                    c1.s.executeUpdate(q4);
                    String q5 = "delete from dbms_te_defaulter where id = "+a+" ;";
                    c1.s.executeUpdate(q5);
                }
                catch(Exception e){}
            }
            if(year1[0].equals("BE"))
            {
                try
                {
                    System.out.println(a);
                    conn c1 = new conn();
                    String q2 = " alter table opp_be_attendance drop column a"+a+" ;";
                    c1.s.executeUpdate(q2);
                    String q3 = "delete from opp_be_defaulter where id = "+a+" ;";
                    c1.s.executeUpdate(q3);
                    String q4 = " alter table python_be_attendance drop column a"+a+" ;";
                    c1.s.executeUpdate(q4);
                    String q5 = "delete from python_be_defaulter where id = "+a+" ;";
                    c1.s.executeUpdate(q5);
                }
                catch(Exception e){}
            }
         new show_students().setVisible(true);
                this.setVisible(false);
        }
        else if(ae.getSource() == b2)
        {
            new new_student().setVisible(true);
            this.setVisible(false);
        }
        else if (ae.getSource() == b3)
        {
            new Updatestudent().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new show_students().setVisible(true);
    }
}
