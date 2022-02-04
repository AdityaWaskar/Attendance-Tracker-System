package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class performance extends JFrame implements ActionListener {
    JLabel l1, l2,l3;
    Choice c1, c2;
    JComboBox c3;
    JButton b1,b2;
    JTable t1;
    String x[]={"SR_No","ID","Name","Email","performance"};
    String y[][] = new String[120][5];
    int i = 0, j = 0;

    performance()
    {
        super("Performance");

        JLabel l = new JLabel("REPORT");
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
        String c = (String)c3.getSelectedItem(); // subject data
        String[] arr = new String[60];
        String[] bee_arr = new String[60];
        String[] mech_arr = new String[60];
        String[] java_arr = new String[60];
        String[] dsa_arr = new String[60];
        String[] math_arr = new String[60];
        String[] dbms_arr = new String[60];
        String[] opp_arr = new String[60];
        String[] python_arr = new String[60];

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
                    new performance().setVisible(true);
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
                    new performance().setVisible(true);
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
                    new performance().setVisible(true);
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
                    new performance().setVisible(true);
                }
            }
            try
            {
                conn c1 = new conn();
                int k = 0;
                int q = 0;
                int e1 = 0;
                try
                {
                    String s1 = "SELECT * FROM student WHERE course = '" + a + "' AND year = '" + b + "' order by id; ";
                    ResultSet rs = c1.s.executeQuery(s1);
                    int z = 0, i = 0;
                    //display id , name , Email in table
                    while (rs.next())
                    {
                        y[i][j++]= String.valueOf(i+1);
                        y[i][j++] = rs.getString("id");
                        arr[i] = rs.getString("id");
                        System.out.println(arr[i]);
                        y[i][j++] = rs.getString("name");
                        y[i][j++] = rs.getString("Email");
                        i++;
                        q++;
                        e1++;
                        j = 0;
                    }
                    t1 = new JTable(y, x);

                }
                catch (SQLException throwables)
                {throwables.printStackTrace();}
                catch (Exception e) {e.printStackTrace();}
// for 1st year
                if (c.equals("FE-BEE")) {
                    int i = 0;
                    for (k = 0; k < q; k++) {
                        if (arr[k] == "NULL") {
                        } else {
                            String s = "select (count(a" + arr[k] + ")*100/(select count(*) from bee_fe_attendance)) as score from bee_fe_attendance where a" + arr[k] + " = 'true';";
                            ResultSet rs1 = c1.s.executeQuery(s);

                            while (rs1.next()) {
                                int j1 = 4;
                                y[i][j1++] = rs1.getString("score");
                                bee_arr[i] = rs1.getString("score");
                                j1 = 0;
                            }
                            i++;
                        }
                    }
                    for(int e=0; e<e1 ; e++)
                    {
                        String q1 = "UPDATE bee_FE_defaulter set performance = "+Float.parseFloat(bee_arr[e])+"where id = '"+arr[e]+"';";
                        c1.s.executeUpdate(q1);
                    }
                }
                else if (c.equals("FE-MECHANICS")) {
                    int i = 0;
                    for (k = 0; k < q; k++) {
                        if (arr[k] == "NULL") {
                        } else {
                            String s = "select (count(a" + arr[k] + ")*100/(select count(*) from mech_fe_attendance)) as score from mech_fe_attendance where a" + arr[k] + " = 'true';";
//                            select (count(a" + arr[k] + ")*100/(select count(*) from dbms_te_attendance)) as score from dbms_te_attendance where a" + arr[k] + " = 'true';
                            ResultSet rs1 = c1.s.executeQuery(s);

                            while (rs1.next()) {
                                int j1 = 4;
                                y[i][j1++] = rs1.getString("score");
                                mech_arr[i] = rs1.getString("score");
                                j1 = 0;
                            }
                            i++;
                        }
                    }
                    for(int e=0; e<e1 ; e++)
                    {
                        String q1 = "UPDATE mech_FE_defaulter set performance = "+Float.parseFloat(mech_arr[e])+"where id = '"+arr[e]+"';";
                        c1.s.executeUpdate(q1);
                    }
                }
//for 2nd year
                else if (c.equals("SE-DSA")) {
                    int i = 0;
                    for (k = 0; k < q; k++) {
                        if (arr[k] == "NULL") {
                        } else {
                            String s = "select (count(a" + arr[k] + ")*100/(select count(*) from dsa_se_attendance)) as score from dsa_se_attendance where a" + arr[k] + " = 'true';";
                            ResultSet rs1 = c1.s.executeQuery(s);

                            while (rs1.next()) {
                                int j1 = 4;
                                y[i][j1++] = rs1.getString("score");
                                dsa_arr[i] = rs1.getString("score");
                                j1 = 0;
                            }
                            i++;
                        }
                    }
                    for(int e=0; e<e1 ; e++)
                    {
                        String q2 = "UPDATE dsa_SE_defaulter set performance = "+Float.parseFloat(dsa_arr[e])+"where id = '"+arr[e]+"';";
                        c1.s.executeUpdate(q2);
                    }
                }
                else if (c.equals("SE-JAVA LAB")) {
                    int i = 0;
                    for (k = 0; k < q; k++) {
                        if (arr[k] == "NULL") {
                        } else {
                            String s = "select (count(a" + arr[k] + ")*100/(select count(*) from java_se_attendance)) as score from java_se_attendance where a" + arr[k] + " = 'true';";
                            ResultSet rs1 = c1.s.executeQuery(s);

                            while (rs1.next()) {
                                int j1 = 4;
                                y[i][j1++] = rs1.getString("score");
                                java_arr[i] = rs1.getString("score");
                                j1 = 0;
                            }
                            i++;
                        }
                    }
                    for(int e=0; e<e1 ; e++)
                    {
                        String q2 = "UPDATE java_SE_defaulter set performance = "+Float.parseFloat(java_arr[e])+"where id = '"+arr[e]+"';";
                        c1.s.executeUpdate(q2);
                    }
                }
//for 3rd year
                else if (c.equals("TE-MATHS")) {
                    int i = 0;
                    for (k = 0; k < q; k++) {
                        if (arr[k] == "NULL") {
                        } else {
                            System.out.println(arr[k]);
                            String s = "select (count(a" + arr[k] + ")*100/(select count(*) from math_te_attendance)) as score from math_te_attendance where a" + arr[k] + " = 'true';";
                            ResultSet rs1 = c1.s.executeQuery(s);

                                while (rs1.next()) {
                                    int j1 = 4;
                                    y[i][j1++] = rs1.getString("score");
                                    math_arr[i] = rs1.getString("score");
                                    j1 = 0;
                                }
                                i++;

                        }
                    }
                    System.out.println(e1);
                    for(int e=0; e<e1 ; e++)
                    {
                        String q3 = "UPDATE math_TE_defaulter set performance = "+Float.parseFloat(math_arr[e])+"where id = '"+arr[e]+"';";
                        c1.s.executeUpdate(q3);
                    }
                }
                else if (c.equals("TE-DBMS")) {
                    int i = 0;
                    for (k = 0; k < q; k++) {
                        if (arr[k] == "NULL") {
                        } else {
                            String s = "select (count(a" + arr[k] + ")*100/(select count(*) from dbms_te_attendance)) as score from dbms_te_attendance where a" + arr[k] + " = 'true';";
                            ResultSet rs1 = c1.s.executeQuery(s);

                                while (rs1.next()) {
                                    int j1 = 4;
                                    y[i][j1++] = rs1.getString("score");
                                    dbms_arr[i] = rs1.getString("score");
                                    System.out.println(dbms_arr[i]);
                                    j1 = 0;
                                }

                                i++;

                        }
                    }
                    System.out.println(e1);
                    for(int e=0; e<e1 ; e++)
                    {
                        String q3 = "UPDATE dbms_TE_defaulter set performance = "+Float.parseFloat(dbms_arr[e])+"where id = '"+arr[e]+"';";
                        c1.s.executeUpdate(q3);
                    }
                }

// for BE
                else if (c.equals("BE-OPP")) {
                    int i = 0;
                    for (k = 0; k < q; k++) {
                        if (arr[k] == "NULL") {
                        } else {
                            String s = "select (count(a" + arr[k] + ")*100/(select count(*) from opp_be_attendance)) as score from opp_be_attendance where a" + arr[k] + " = 'true';";
                            ResultSet rs1 = c1.s.executeQuery(s);

                            while (rs1.next()) {
                                int j1 = 4;
                                y[i][j1++] = rs1.getString("score");
                                opp_arr[i] = rs1.getString("score");
                                System.out.println(opp_arr[i]);
                                j1 = 0;
                            }
                            i++;
                        }
                    }
                    for(int e=0; e<e1 ; e++)
                    {
                        System.out.println(opp_arr[e]);
                        String q4 = "UPDATE opp_BE_defaulter set performance = "+Float.parseFloat(opp_arr[e])+"where id = '"+arr[e]+"';";
//                        String q3 = "UPDATE dbms_TE_defaulter set performance = "+Float.parseFloat(dbms_arr[e])+"where id = '"+arr[e]+"';";
                        c1.s.executeUpdate(q4);
                    }
                }
                else if (c.equals("BE-PYTHON")) {
                    int i = 0;
                    for (k = 0; k < q; k++) {
                        if (arr[k] == "NULL") {
                        } else {
                            String s = "select (count(a" + arr[k] + ")*100/(select count(*) from python_be_attendance)) as score from python_be_attendance where a" + arr[k] + " = 'true';";
                            ResultSet rs1 = c1.s.executeQuery(s);

                            while (rs1.next()) {
                                int j1 = 4;
                                y[i][j1++] = rs1.getString("score");
                                python_arr[i] = rs1.getString("score");
                                j1 = 0;
                            }
                            i++;
                        }
                    }
                    for(int e=0; e<e1 ; e++)
                    {
                        String q4 = "UPDATE python_BE_defaulter set performance = "+Float.parseFloat(python_arr[e])+"where id = '"+arr[e]+"';";
                        c1.s.executeUpdate(q4);
                    }
                }

                    t1 = new JTable(y, x);
                    JScrollPane sp = new JScrollPane(t1);
                    sp.setBounds(15, 180, 850, 330);
                    add(sp);
                    getContentPane().setBackground(Color.WHITE);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else if (ae.getSource() == b2) {
                this.setVisible(false);
                new performance().setVisible(true);
            }
        }
    public static void main(String[] args)
    {
        performance p = new performance();
    }

}
