package com.company;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class take_attendance extends JFrame implements ActionListener {

    Choice c1, c2;
    JComboBox c3;
    JButton b1, b2, b3;
    DefaultTableModel model;
    final JTable table;
    JTextField t1;
    JDateChooser calendar;

    public take_attendance()
    {
        setTitle("take attendance");

        JLabel l = new JLabel("Attendance");
        l.setBounds(20,10, 300,50);
        l.setFont(new Font("serif",Font.BOLD,30));
        add(l);

        getContentPane().setLayout(null);

        JScrollPane sp = new JScrollPane();
//        sp.setBounds(20, 20,800,330);
        getContentPane().add(sp);

        table = new JTable();
        sp.setViewportView(table);
        sp.setBounds(50, 130,800,350);

        model = new DefaultTableModel()
        {
            @Override
            public Class<?> getColumnClass(int column) {
                switch (column)
                {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return String.class;
                }
            }
        };
        table.setModel(model);
        model.addColumn("Attendance");
        model.addColumn("ID");
        model.addColumn("Name");


        b1 = new JButton("Submit");
        b1.setBounds(720,500,100,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);


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
        c1.setBounds(70,80,150,50);
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
        c2.setBounds(260,80,90,50);
        add(c2);

        String [] subject = {" ", "FE-BEE", "FE-MECHANICS","SE-DSA","SE-JAVA LAB","TE-DBMS","TE-MATHS","BE-OOP","BE-PYTHON"};
        c3 = new JComboBox(subject);
        c3.setBackground(Color.WHITE);
        c3.setBounds(380, 80, 120 , 20);
        add(c3);

        calendar = new JDateChooser();
        calendar.setDateFormatString("dd-MM-yyyy");
        calendar.setBounds(550, 80, 100 , 20);
        add(calendar);


        b2 = new JButton(("Ok"));
        b2.setBounds(720,40,100,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b3 = new JButton(("Reset"));
        b3.setBounds(720,80,100,30);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);

        JLabel l13 = new JLabel();
        l13.setBounds(0,0,900 ,700);
        l13.setLayout(null);
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\15.jpg"));
        Image i2 = ic1.getImage().getScaledInstance(1900,950,Image.SCALE_DEFAULT);
        ImageIcon icon4 = new ImageIcon((i2));
        l13.setIcon(icon4);
        add(l13);

        setBounds(300, 130, 900, 600);
    }



    @Override
    public void actionPerformed(ActionEvent ae) {
        String a = (String)c1.getSelectedItem();// branch data
        String b = c2.getSelectedItem();// year data
        String e = (String)c3.getSelectedItem();//subject

        Date date = calendar.getDate();
        DateFormat d1 = new SimpleDateFormat("dd-MM-yyyy");
        String d = d1.format(date);// Getting and format the date text.
        System.out.println(d);

        conn c = new conn();
        ResultSet rs1, rs2,rs3, rs4;
        System.out.println(b+b1);

        if(ae.getSource() == b2)
        {
            if(b.equals("FE"))
            {
                if(e.equals("FE-BEE") ||  e.equals("FE-MECHANICS"))
                //"FE-BEE", "FE-MECHANICS","SE-DSA","SE-JAVA LAB","TE-DBMS","TE-MATHS","BE-OPP","BE-PYTHON"
                {}
                else {
                    JOptionPane.showMessageDialog(null, "Enter either BEE or MECHANICS");
                    this.setVisible(false);
                    new take_attendance().setVisible(true);
                }
            }
            else if(b.equals("SE"))
            {
                //"FE-BEE", "FE-MECHANICS","SE-DSA","SE-JAVA LAB","TE-DBMS","TE-MATHS","BE-OPP","BE-PYTHON"
                if(e.equals("SE-DSA") ||  e.equals("SE-JAVA LAB"))
                {}
                else {
                    JOptionPane.showMessageDialog(null, "Enter either DSA or JAVA LAB");
                    this.setVisible(false);
                    new take_attendance().setVisible(true);
                }
            }
            else if(b.equals("TE"))
            {
                //"FE-BEE", "FE-MECHANICS","SE-DSA","SE-JAVA LAB","TE-DBMS","TE-MATHS","BE-OPP","BE-PYTHON"
                if(e.equals("TE-DBMS") ||  e.equals("TE-MATHS"))
                {}
                else {
                    JOptionPane.showMessageDialog(null, "Enter either DBMS or MATHS");
                    this.setVisible(false);
                    new take_attendance().setVisible(true);
                }
            }
            else if(b.equals("BE"))
            {
                //"FE-BEE", "FE-MECHANICS","SE-DSA","SE-JAVA LAB","TE-DBMS","TE-MATHS","BE-OPP","BE-PYTHON"
                if(e.equals("BE-OOP") ||  e.equals("BE-PYTHON"))
                {}
                else {
                    JOptionPane.showMessageDialog(null, "Enter either OPP or PYTHON");
                    this.setVisible(false);
                    new take_attendance().setVisible(true);
                }
            }
            try {
                rs2 = c.s.executeQuery("SELECT * FROM student WHERE course = '" + a + "'AND year = '" + b + "' ");
                int i=0, j=0;

                while(rs2.next()) {
                    String str1 = rs2.getString("id");
                    String str2 = rs2.getString("name");
                    model.addRow(new Object[0]);
                    model.setValueAt(true, i, j++);
                    model.setValueAt(str1, i, j++);
                    model.setValueAt(str2, i, j++);
                    i++;
                    j=0;
                }
            } catch (SQLException e1e) {
                System.out.println("thank you!");
            }
        }

        else if(ae.getSource() == b3)
        {
            this.setVisible(false);
            new take_attendance().setVisible(true);
        }

        else if(ae.getSource() == b1)
        {

            try {
                // condition for creating row in the respective tables
                if(e.equals("FE-BEE")) {
                    String q2 = "INSERT INTO bee_FE_attendance (date) values('" + d + "');";
                    c.s.executeUpdate(q2);
                }
                else if(e.equals("FE-MECHANICS")) {
                    String q2 = "INSERT INTO mech_FE_attendance (date) values('" + d + "');";
                    c.s.executeUpdate(q2);
                }
                else if(e.equals("SE-DSA")) {
                    String q2 = "INSERT INTO dsa_SE_attendance (date) values('" + d + "');";
                    c.s.executeUpdate(q2);
                }
                else if(e.equals("SE-JAVA LAB")) {
                    String q2 = "INSERT INTO java_SE_attendance (date) values('" + d + "');";
                    c.s.executeUpdate(q2);
                }
                else if(e.equals("TE-MATHS")) {
                    String q2 = "INSERT INTO maths_TE_attendance (date) values('" + d + "');";
                    c.s.executeUpdate(q2);
                }
                else if(e.equals("TE-DBMS")) {
                    String q2 = "INSERT INTO dbms_TE_attendance (date) values('" + d + "');";
                    c.s.executeUpdate(q2);
                }
                else if(e.equals("BE-PYTHON")) {
                    String q2 = "INSERT INTO python_BE_attendance (date) values('" + d + "');";
                    c.s.executeUpdate(q2);
                }
                else if(e.equals("BE-OOP")) {
                    System.out.println("xffg");
                    String q2 = "INSERT INTO opp_BE_attendance (date) values('" + d + "');";
                    c.s.executeUpdate(q2);
                }

                //condition for inserting the values(true, false) in the table
                if(e.equals("FE-BEE")) {
                    int z=0;
                    rs1 = c.s.executeQuery("SELECT * FROM student where year = 'FE';");
                    while(rs1.next())
                    {
                        System.out.println(z);
                        z++;
                    }
                    for(int j=0; j<z; j++)
                    {
                        Boolean value = Boolean.valueOf(table.getValueAt(j, 0).toString());
                        String  id = table.getValueAt(j, 1).toString();
                        String q = "UPDATE bee_FE_attendance SET  a" + id + "='" + value +"' WHERE date = '" + d + "';";
                        c.s.executeUpdate(q);
                    }
                    z=0;
                    JOptionPane.showMessageDialog(null, "Summited");
                }
                else if(e.equals("FE-MECHANICS")) {
                    int z=0;
                    rs1 = c.s.executeQuery("SELECT * FROM student where year = 'FE';");
                    while(rs1.next())
                    {
                        System.out.println(z);
                        z++;
                    }
                    for(int j=0; j<z; j++)
                    {
                        Boolean value = Boolean.valueOf(table.getValueAt(j, 0).toString());
                        String  id = table.getValueAt(j, 1).toString();
                        String q = "UPDATE mech_FE_attendance SET  a" + id + "='" + value +"' WHERE date = '" + d + "';";
                        c.s.executeUpdate(q);
                    }
                    z=0;
                    JOptionPane.showMessageDialog(null, "Summited");

                }
                else if(e.equals("SE-DSA")) {
                    int z=0;
                    rs1 = c.s.executeQuery("SELECT * FROM student where year = 'SE';");
                    while(rs1.next())
                    {
                        System.out.println(z);
                        z++;
                    }
                    for(int j=0; j<z; j++)
                    {
                        Boolean value = Boolean.valueOf(table.getValueAt(j, 0).toString());
                        String  id = table.getValueAt(j, 1).toString();
                        String q = "UPDATE dsa_SE_attendance SET  a" + id + "='" + value +"' WHERE date = '" + d + "';";
                        c.s.executeUpdate(q);
                    }
                    z=0;
                    JOptionPane.showMessageDialog(null, "Summited");
                }
                else if(e.equals("SE-JAVA LAB")) {
                    int z=0;
                    rs1 = c.s.executeQuery("SELECT * FROM student where year = 'SE';");
                    while(rs1.next())
                    {
                        System.out.println(z);
                        z++;
                    }
                    for(int j=0; j<z; j++)
                    {
                        Boolean value = Boolean.valueOf(table.getValueAt(j, 0).toString());
                        String  id = table.getValueAt(j, 1).toString();
                        String q = "UPDATE java_SE_attendance SET  a" + id + "='" + value +"' WHERE date = '" + d + "';";
                        c.s.executeUpdate(q);
                    }
                    z=0;
                    JOptionPane.showMessageDialog(null, "Summited");

                }
                else if(e.equals("TE-MATHS")) {
                    int z=0;
                    rs1 = c.s.executeQuery("SELECT * FROM student where year = 'TE';");
                    while(rs1.next())
                    {
                        System.out.println(z);
                        z++;
                    }
                    for(int j=0; j<z; j++)
                    {
                        Boolean value = Boolean.valueOf(table.getValueAt(j, 0).toString());
                        String  id = table.getValueAt(j, 1).toString();
                        String q = "UPDATE math_TE_attendance SET  a" + id + "='" + value +"' WHERE date = '" + d + "';";
                        c.s.executeUpdate(q);
                    }
                    z=0;
                    JOptionPane.showMessageDialog(null, "Summited");
                }
                else if(e.equals("TE-DBMS")) {
                    int z=0;
                    rs1 = c.s.executeQuery("SELECT * FROM student where year = 'TE';");
                    while(rs1.next())
                    {
                        System.out.println(z);
                        z++;
                    }
                    for(int j=0; j<z; j++)
                    {
                        Boolean value = Boolean.valueOf(table.getValueAt(j, 0).toString());
                        String  id = table.getValueAt(j, 1).toString();
                        String q = "UPDATE dbms_TE_attendance SET  a" + id + "='" + value +"' WHERE date = '" + d + "';";
                        c.s.executeUpdate(q);
                    }
                    z=0;
                    JOptionPane.showMessageDialog(null, "Summited");
                }
                else if(e.equals("BE-PYTHON")) {
                    int z=0;
                    rs1 = c.s.executeQuery("SELECT * FROM student where year = 'BE';");
                    while(rs1.next())
                    {
                        System.out.println(z);
                        z++;
                    }
                    for(int j=0; j<z; j++)
                    {
                        Boolean value = Boolean.valueOf(table.getValueAt(j, 0).toString());
                        String  id = table.getValueAt(j, 1).toString();
                        String q = "UPDATE python_BE_attendance SET  a" + id + "='" + value +"' WHERE date = '" + d + "';";
                        c.s.executeUpdate(q);
                    }
                    z=0;
                    JOptionPane.showMessageDialog(null, "Summited");
                }
                else if(e.equals("BE-OOP")) {
                    System.out.println("hhlk;l");
                    int z=0;
                    rs1 = c.s.executeQuery("SELECT * FROM student where year = 'BE';");
                    while(rs1.next())
                    {
                        System.out.println(z);
                        z++;
                    }
                    for(int j=0; j<z; j++)
                    {
                        System.out.println("j");
                        Boolean value = Boolean.valueOf(table.getValueAt(j, 0).toString());
                        String  id = table.getValueAt(j, 1).toString();
                        String q = "UPDATE opp_BE_attendance SET  a" + id + "='" + value +"' WHERE date = '" + d + "';";
                        c.s.executeUpdate(q);
                    }
                    z=0;
                    JOptionPane.showMessageDialog(null, "Submitted");

                }
            } catch (SQLException ee) {
                System.out.println("");
            }
            this.setVisible(false);
        }
    }

    public static void main(String [] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                take_attendance form = new take_attendance();
                form.setVisible(true);
            }
        });
    }
}


















