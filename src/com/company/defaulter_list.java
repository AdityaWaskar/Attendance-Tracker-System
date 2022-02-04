package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class defaulter_list extends JFrame implements ActionListener {
    JLabel l1, l2,l3;
    Choice c1, c2;
    JComboBox c3;
    JButton b1,b2;
    JTable t1;
    String x[]={"Sr No","ID","Name","Email","Record"};
    String y[][] = new String[120][5];
    int i = 0, j = 0;

    defaulter_list()
    {
        super("Defaulter List");

        JLabel l = new JLabel("Defaulter List");
        l.setBounds(20,10, 300,50);
        l.setFont(new Font("serif",Font.BOLD,30));
        add(l);

        c1 = new Choice();
        try
        {
            conn c = new conn();
            ResultSet rs2 = c.s.executeQuery("SELECT distinct(course) FROM student");
            while(rs2.next())
            {
                c1.add(rs2.getString("course"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        c1.setBounds(70,90,180,50);
        add(c1);

        c2 = new Choice();
        try
        {
            conn c = new conn();
            ResultSet rs2 = c.s.executeQuery("SELECT distinct(year) FROM student");
            while(rs2.next())
            {
                c2.add(rs2.getString("year"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        c2.setBounds(300,90,90,50);
        add(c2);

        String [] subject = {" ", "FE-BEE", "FE-MECHANICS","SE-DSA","SE-JAVA LAB","TE-DBMS","TE-MATHS","BE-OPP","BE-PYTHON"};
        c3 = new JComboBox(subject);
        c3.setBackground(Color.WHITE);
        c3.setBounds(450, 90, 120 , 20);
        add(c3);

        b1 = new JButton("Show");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(720,60,100,30);
        add(b1);

        b2 = new JButton("Reset");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(720,100,100,30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        JLabel l13 = new JLabel();
        l13.setBounds(0,0,900 ,700);
        l13.setLayout(null);
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\15.jpg"));
        Image i2 = ic1.getImage().getScaledInstance(1900,950,Image.SCALE_DEFAULT);
        ImageIcon icon4 = new ImageIcon((i2));
        l13.setIcon(icon4);
        add(l13);

        setBackground(Color.WHITE);

        setLayout(null);
        setBounds(300, 130, 900, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String a = (String) c1.getSelectedItem(); // course data
        String b = (String) c2.getSelectedItem(); // year data
        String c = (String) c3.getSelectedItem(); // subject data

        if (ae.getSource() == b1)
        {
            if(b.equals("FE"))
            {
                if(c.equals("FE-BEE") ||  c.equals("FE-MECHANICS"))
                //"FE-BEE", "FE-MECHANICS","SE-DSA","SE-JAVA LAB","TE-DBMS","TE-MATHS","BE-OPP","BE-PYTHON"
                {}
                else {
                    JOptionPane.showMessageDialog(null, "Enter either BEE or MECHANICS");
                    this.setVisible(false);
                    new defaulter_list().setVisible(true);
                }
            }
            else if(b.equals("SE"))
            {
                //"FE-BEE", "FE-MECHANICS","SE-DSA","SE-JAVA LAB","TE-DBMS","TE-MATHS","BE-OPP","BE-PYTHON"
                if(c.equals("SE-DSA") ||  c.equals("SE-JAVA LAB"))
                {}
                else {
                    JOptionPane.showMessageDialog(null, "Enter either DSA or JAVA LAB");
                    this.setVisible(false);
                    new defaulter_list().setVisible(true);
                }
            }
            else if(b.equals("TE"))
            {
                //"FE-BEE", "FE-MECHANICS","SE-DSA","SE-JAVA LAB","TE-DBMS","TE-MATHS","BE-OPP","BE-PYTHON"
                if(c.equals("TE-DBMS") ||  c.equals("TE-MATHS"))
                {}
                else {
                    JOptionPane.showMessageDialog(null, "Enter either DBMS or MATHS");
                    this.setVisible(false);
                    new defaulter_list().setVisible(true);
                }
            }
            else if(b.equals("BE"))
            {
                //"FE-BEE", "FE-MECHANICS","SE-DSA","SE-JAVA LAB","TE-DBMS","TE-MATHS","BE-OPP","BE-PYTHON"
                if(c.equals("BE-OPP") ||  c.equals("BE-PYTHON"))
                {}
                else {
                    JOptionPane.showMessageDialog(null, "Enter either OPP or PYTHON");
                    this.setVisible(false);
                    new defaulter_list().setVisible(true);
                }
            }
// for 1st year
            if (c.equals("FE-BEE")) {
                conn c1 = new conn();
                try
                {
                    String s1 = "SELECT * FROM bee_FE_defaulter WHERE performance < 75.00; ";
                    ResultSet rs = c1.s.executeQuery(s1);
                    int z = 1, i = 0;
                    //display id ,name ,Email in table
                    while (rs.next())
                    {

                        y[i][j++] = ""+z;
                        y[i][j++] = rs.getString("id");
                        y[i][j++] = rs.getString("name");
                        y[i][j++] = rs.getString("Email");
                        y[i][j++] = rs.getString("performance");
                        i++;
                        z++;
                        j = 0;
                    }
                    t1 = new JTable(y, x);

                }
                catch (SQLException throwables)
                {throwables.printStackTrace();}

            }
            else if (c.equals("FE-MECHANICS")) {
                conn c1 = new conn();
                try
                {
                    String s1 = "SELECT * FROM mech_FE_defaulter WHERE performance < 75.00; ";
                    ResultSet rs = c1.s.executeQuery(s1);
                    int z = 1, i = 0;
                    //display id ,name ,Email in table
                    while (rs.next())
                    {

                        y[i][j++] = ""+z;
                        y[i][j++] = rs.getString("id");
                        y[i][j++] = rs.getString("name");
                        y[i][j++] = rs.getString("Email");
                        y[i][j++] = rs.getString("performance");
                        i++;
                        z++;
                        j = 0;
                    }
                    t1 = new JTable(y, x);

                }
                catch (SQLException throwables)
                {throwables.printStackTrace();}

            }
//for 2nd year
            else if (c.equals("SE-JAVA LAB")) {
                 conn c1 = new conn();
            try
            {
                String s1 = "SELECT * FROM java_SE_defaulter WHERE performance < 75.00; ";
                ResultSet rs = c1.s.executeQuery(s1);
                int z = 1, i = 0;
                //display id ,name ,Email in table
                while (rs.next())
                {

                    y[i][j++] = ""+z;
                    y[i][j++] = rs.getString("id");
                    y[i][j++] = rs.getString("name");
                    y[i][j++] = rs.getString("Email");
                    y[i][j++] = rs.getString("performance");
                    i++;
                    z++;
                    j = 0;
                }
                t1 = new JTable(y, x);

            }
            catch (SQLException throwables)
            {throwables.printStackTrace();}

            }
            else if (c.equals("SE-DSA")) {
                 conn c1 = new conn();
            try
            {
                String s1 = "SELECT * FROM dsa_SE_defaulter WHERE performance < 75.00; ";
                ResultSet rs = c1.s.executeQuery(s1);
                int z = 1, i = 0;
                //display id ,name ,Email in table
                while (rs.next())
                {

                    y[i][j++] = ""+z;
                    y[i][j++] = rs.getString("id");
                    y[i][j++] = rs.getString("name");
                    y[i][j++] = rs.getString("Email");
                    y[i][j++] = rs.getString("performance");
                    i++;
                    z++;
                    j = 0;
                }
                t1 = new JTable(y, x);

            }
            catch (SQLException throwables)
            {throwables.printStackTrace();}

            }

//for 3rd year
            else if (c.equals("TE-MATH")) {
                 conn c1 = new conn();
            try
            {
                String s1 = "SELECT * FROM math_TE_defaulter WHERE performance < 75.00; ";
                ResultSet rs = c1.s.executeQuery(s1);
                int z = 1, i = 0;
                //display id ,name ,Email in table
                while (rs.next())
                {

                    y[i][j++] = ""+z;
                    y[i][j++] = rs.getString("id");
                    y[i][j++] = rs.getString("name");
                    y[i][j++] = rs.getString("Email");
                    y[i][j++] = rs.getString("performance");
                    i++;
                    z++;
                    j = 0;
                }
                t1 = new JTable(y, x);

            }
            catch (SQLException throwables)
            {throwables.printStackTrace();}

            }
            else if (c.equals("TE-DBMS")) {
                 conn c1 = new conn();
            try
            {
                String s1 = "SELECT * FROM dbms_TE_defaulter WHERE performance < 75.00; ";
                ResultSet rs = c1.s.executeQuery(s1);
                int z = 1, i = 0;
                //display id ,name ,Email in table
                while (rs.next())
                {

                    y[i][j++] = ""+z;
                    y[i][j++] = rs.getString("id");
                    y[i][j++] = rs.getString("name");
                    y[i][j++] = rs.getString("Email");
                    y[i][j++] = rs.getString("performance");
                    i++;
                    z++;
                    j = 0;
                }
                t1 = new JTable(y, x);

            }
            catch (SQLException throwables)
            {throwables.printStackTrace();}

            }

// for BE
            else if (c.equals("BE-OPP")) {
                 conn c1 = new conn();
            try
            {
                String s1 = "SELECT * FROM opp_BE_defaulter WHERE performance < 75.00; ";
                ResultSet rs = c1.s.executeQuery(s1);
                int z = 1, i = 0;
                //display id ,name ,Email in table
                while (rs.next())
                {

                    y[i][j++] = ""+z;
                    y[i][j++] = rs.getString("id");
                    y[i][j++] = rs.getString("name");
                    y[i][j++] = rs.getString("Email");
                    y[i][j++] = rs.getString("performance");
                    i++;
                    z++;
                    j = 0;
                }
                t1 = new JTable(y, x);

            }
            catch (SQLException throwables)
            {throwables.printStackTrace();}

            }
            else if (c.equals("BE-PYTHON")) {
                 conn c1 = new conn();
            try
            {
                String s1 = "SELECT * FROM python_BE_defaulter WHERE performance < 75.00; ";
                ResultSet rs = c1.s.executeQuery(s1);
                int z = 1, i = 0;
                //display id ,name ,Email in table
                while (rs.next())
                {

                    y[i][j++] = ""+z;
                    y[i][j++] = rs.getString("id");
                    y[i][j++] = rs.getString("name");
                    y[i][j++] = rs.getString("Email");
                    y[i][j++] = rs.getString("performance");
                    i++;
                    z++;
                    j = 0;
                }
                t1 = new JTable(y, x);

            }
            catch (SQLException throwables)
            {throwables.printStackTrace();}

            }

            t1 = new JTable(y, x);
            JScrollPane sp = new JScrollPane(t1);
            sp.setBounds(15, 180, 850, 330);
            add(sp);
            getContentPane().setBackground(Color.WHITE);

        }
        else if (ae.getSource() == b2) {
            this.setVisible(false);
            new defaulter_list().setVisible(true);
        }
    }
    public static void main(String[] args)
    {
         defaulter_list p = new defaulter_list();
    }

}
