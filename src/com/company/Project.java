package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Project extends JFrame implements ActionListener {
    Project()
    {
        super("Attendance Tracker");
        setSize(1930,1030);
        setLocation(-7,0);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\img1.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1900,950,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon((i3));
        JLabel l1 = new JLabel(icc3);
        add(l1);

        JMenuBar mb = new JMenuBar();

        JMenu master = new JMenu("Create Class");
        JMenuItem m1 = new JMenuItem("Add Student");
        JMenuItem m2 = new JMenuItem("Add Teacher");
        master.setForeground(Color.BLUE);

        m1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\icon1.jpg"));
        Image image1 = icon1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(image1));
        m1.setMnemonic('A');
        m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        setBackground(Color.WHITE);

        m2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\icon2.jpg"));
        Image image2 = icon2.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        m2.setIcon(new ImageIcon(image2));
        m2.setMnemonic('B');
        m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        setBackground(Color.WHITE);

        m1.addActionListener(this);
        m2.addActionListener(this);

        JMenu detail = new JMenu("Class Detail");
        JMenuItem m3 = new JMenuItem("Student");
        JMenuItem m4 = new JMenuItem("Teacher");
        detail.setForeground(Color.RED);;

        m3.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\icon3.jpg"));
        Image image3 = icon3.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        m3.setIcon(new ImageIcon(image3));
        m3.setMnemonic('C');
        m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        setBackground(Color.WHITE);

        m4.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\icon4.jpg"));
        Image image4 = icon4.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        m4.setIcon(new ImageIcon(image4));
        m4.setMnemonic('D');
        m4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        setBackground(Color.WHITE);

        m3.addActionListener(this);
        m4.addActionListener(this);

        JMenu attendance = new JMenu("Attendance");
        JMenuItem m5 = new JMenuItem("Attendance");
        attendance.setForeground(Color.BLUE);

        m5.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\icon5.jpg"));
        Image image5 = icon5.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        m5.setIcon(new ImageIcon(image5));
        m5.setMnemonic('E');
        m5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        setBackground(Color.WHITE);

        m5.addActionListener(this);

        JMenu report = new JMenu("Report");
        JMenuItem m6 = new JMenuItem("Performance");
        JMenuItem m7 = new JMenuItem("Defaulter List");
        report.setForeground(Color.RED);

        m3.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\icon6.jpg"));
        Image image6 = icon6.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        m6.setIcon(new ImageIcon(image6));
        m6.setMnemonic('F');
        m6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        setBackground(Color.WHITE);

        m7.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\icon7.jpg"));
        Image image7 = icon7.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        m7.setIcon(new ImageIcon(image7));
        m7.setMnemonic('G');
        m7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        setBackground(Color.WHITE);

        m6.addActionListener(this);
        m7.addActionListener(this);

        JMenu exit = new JMenu("Exit");
        JMenuItem m8 = new JMenuItem("Exit");
        exit.setForeground(Color.BLUE);

        m8.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("com\\company\\icons\\icon8.jpg"));
        Image image8 = icon8.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        m8.setIcon(new ImageIcon(image8));
        m8.setMnemonic('H');
        m8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        setBackground(Color.WHITE);

        m8.addActionListener(this);

        master.add(m1);
        master.add(m2);

        detail.add(m3);
        detail.add(m4);

        attendance.add(m5);

        report.add(m6);
        report.add(m7);

        exit.add(m8);

        mb.add(master);
        mb.add(detail);
        mb.add(attendance);
        mb.add(report);
        mb.add(exit);

        setJMenuBar(mb);

        setFont(new Font("senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if(msg.equals("Add Student"))
        {
            new new_student().setVisible(true);
        }
        else if(msg.equals("Add Teacher"))
        {
            new new_teacher().setVisible(true);
        }
        else if(msg.equals("Student"))
        {
            new show_students().setVisible(true);
        }
        else if(msg.equals("Teacher"))
        {
            new show_teacher().setVisible(true);
        }
        else if(msg.equals("Attendance"))
        {
            new take_attendance().setVisible(true);
        }
        else if(msg.equals("Performance"))
        {
            new performance().setVisible(true);
        }
        else if(msg.equals("Defaulter List"))
        {
            new defaulter_list().setVisible(true);
        }
        else if(msg.equals("Exit"))
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        Project c = new Project();
    }

}
