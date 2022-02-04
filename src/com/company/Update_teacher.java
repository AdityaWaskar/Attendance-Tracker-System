package com.company;
import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
class Updates_teacher extends JFrame implements  ActionListener {
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,lab,lab1,lab2;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t12;
    JButton b,b1,b2;
    JComboBox c1, c2;
    String id_emp;

    Updates_teacher() {
        super("Update Teacher");

        lab1 = new JLabel("Enter Teacher ID to update the data of student");
        lab1.setBounds(50, 100, 500, 30);
        lab1.setFont(new Font("serif", Font.ITALIC, 20));
        add(lab1);

        t12 = new JTextField();
        t12.setBounds(500, 100, 200, 30);
        add(t12);

        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(720, 100, 100, 30);
        add(b2);
        b2.addActionListener(this);

        id8 = new JLabel("Update Teacher Details");
        id8.setBounds(50, 10, 500, 50);
        id8.setFont(new Font("serif", Font.ITALIC, 40));
        id8.setForeground(Color.black);
        add(id8);

        id1 = new JLabel("Name");
        id1.setBounds(50, 170, 80, 30);
        id1.setFont(new Font("serif", Font.BOLD, 20));
        add(id1);

        t1 = new JTextField();
        t1.setBounds(200, 170, 150, 30);
        add(t1);

        id2 = new JLabel("Age");
        id2.setBounds(400, 170, 200, 30);
        id2.setFont(new Font("serif", Font.BOLD, 20));
        add(id2);

        t2 = new JTextField();
        t2.setBounds(600, 170, 150, 30);
        add(t2);

        id3 = new JLabel("DOB(dd/mm/yyyy)");
        id3.setBounds(50, 240, 150, 30);
        id3.setFont(new Font("serif", Font.BOLD, 20));
        add(id3);

        t3 = new JTextField();
        t3.setBounds(200, 240, 150, 30);
        add(t3);

        id4 = new JLabel("Email");
        id4.setBounds(400, 240, 200, 30);
        id4.setFont(new Font("serif", Font.BOLD, 20));
        add(id4);

        t4 = new JTextField();
        t4.setBounds(600, 240, 150, 30);
        add(t4);

        id5 = new JLabel("Aadhar No.");
        id5.setBounds(50, 310, 100, 30);
        id5.setFont(new Font("serif", Font.BOLD, 20));
        add(id5);

        t5 = new JTextField();
        t5.setBounds(200, 310, 150, 30);
        add(t5);

        id6 = new JLabel("Class X(%)");
        id6.setBounds(400, 310, 100, 30);
        id6.setFont(new Font("serif", Font.BOLD, 20));
        add(id6);

        t6 = new JTextField();
        t6.setBounds(600, 310, 150, 30);
        add(t6);

        id7 = new JLabel("Class XII(%)");
        id7.setBounds(50, 380, 130, 30);
        id7.setFont(new Font("serif", Font.BOLD, 20));
        add(id7);

        t7 = new JTextField();
        t7.setBounds(200, 380, 150, 30);
        add(t7);

        id11 = new JLabel("Department");
        id11.setBounds(400, 380, 150, 30);
        id11.setFont(new Font("serif", Font.BOLD, 20));
        add(id11);


        String branch[] = {"Information Technology","Computer Science","Mechanical Engineering","Civil Engineering","Electrical Engineering","Electronics and Communication Engineering"};
        c2 = new JComboBox(branch);
        c2.setBackground(Color.WHITE);
        c2.setBounds(600, 380, 150, 30);
        add(c2);

        id12 = new JLabel("Education");
        id12.setBounds(50, 450, 150, 30);
        id12.setFont(new Font("serif", Font.BOLD, 20));
        add(id12);

        String course[] = {"B.Tech","BE","Bsc","BBA","Msc","MCA","BA","BCom"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 450, 150, 30);
        add(c1);

        id8 = new JLabel("Phone No.");
        id8.setBounds(400, 450, 130, 30);
        id8.setFont(new Font("serif", Font.BOLD, 20));
        add(id8);

        t8 = new JTextField();
        t8.setBounds(600, 450, 150, 30);
        add(t8);

        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250, 530, 150, 40);
        add(b);

        b1 = new JButton("Cancle");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450, 530, 150, 40);
        add(b1);

        b.addActionListener(this);
        b1.addActionListener(this);

        JLabel l13 = new JLabel();
        l13.setBounds(0,0,900 ,700);
        l13.setLayout(null);
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\15.jpg"));
        Image i2 = ic1.getImage().getScaledInstance(1900,950,Image.SCALE_DEFAULT);
        ImageIcon icon4 = new ImageIcon((i2));
        l13.setIcon(icon4);
        add(l13);

        setLayout(null);
        setSize(900, 650);
        setLocation(260, 100);
        setBackground(Color.white);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b) {
            try {
                conn con = new conn();
                String str = "Update teacher set name='" + t1.getText() + "',age='" + t2.getText() + "',DOB='" + t3.getText() + "',Email='" + t4.getText() +"',Aadhar_no ='" + t5.getText() +"',X='" + t6.getText() +
                        "',XII='" + t7.getText() +"',education='" +(String)c1.getSelectedItem() +"',department='" + (String)c2.getSelectedItem() +"',phone_no='" + t8.getText()+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Successfully updated");
                setVisible(false);
                new show_students();
            } catch (Exception e) {
                System.out.println("The error is : " + e);
            }
        }
        if (ae.getSource() == b1) {
            setVisible(false);
            new Project().setVisible(true);
        }
        if (ae.getSource() == b2) {
            try {
//                String str2 = t12.getText();
                conn con = new conn();
                String str = "Select * from teacher where id ='" + t12.getText() + "'";
                ResultSet rs = con.s.executeQuery(str);

                if (rs.next()) {
                    t1.setText(rs.getString("name"));
                    t2.setText(rs.getString("age"));
                    t3.setText(rs.getString("DOB"));
                    t4.setText(rs.getString("Email"));
                    t5.setText(rs.getString("Aadhar_no"));
                    t6.setText(rs.getString("X"));
                    t7.setText(rs.getString("XII"));
                    t10.setText(rs.getString("department"));
                    t9.setText(rs.getString("education"));
                    t8.setText(rs.getString("phone_no"));

                    setVisible(true);
                }
            } catch (Exception ex){ }
        }
    }
    public static void main(String[] args){
        new Updates_teacher().setVisible(true);
    }
}