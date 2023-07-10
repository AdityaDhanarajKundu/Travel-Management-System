package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    JTextArea area;
    JButton back;
    About(){
        JPanel p1 = new JPanel(null);
        p1.setBounds(0,0,500,50);
        p1.setBackground(new Color(0,0,102));
        add(p1);
        JLabel heading = new JLabel("ABOUT");
        heading.setBounds(60,0,300,60);
        heading.setFont(new Font("Tahoma",Font.BOLD,28));
        heading.setForeground(Color.YELLOW);
        p1.add(heading);

        String message = "Hello, I am Aditya Dhanaraj Kundu.\n"+"I have made this java project \n\n"
                +"                                   About Projects          \n  "+ "\nThe objective of the Travel and Tourism Management System"
                + "project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
                + "\nFriendly Environment by providing warning messages."
                + "\ntravelers details can be provided"
                + "\nbooking confirmation notification";

        area = new JTextArea(message,40,10);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        area.setBackground(new Color(229, 228, 226));
        area.setFont(new Font("Raleway",Font.PLAIN,15));
        area.setForeground(Color.BLACK);
        add(area);
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setBounds(20, 100, 450, 300);
        add(scrollPane);

        back = new JButton("Back");
        back.setBounds(200,420,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setBounds(600,200,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
