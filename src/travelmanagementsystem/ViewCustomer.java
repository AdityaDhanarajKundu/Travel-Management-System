package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class ViewCustomer extends JFrame {
    String name,password;
    JLabel labelname,labelid,labelnumber,labelusername,labelgender,labelcountry;
    ViewCustomer(String name,String password){
        this.name=name;
        this.password=password;

        JPanel p1 = new JPanel(null);
        p1.setBounds(0,0,870,50);
        p1.setBackground(new Color(0,0,102));
        add(p1);
        JLabel heading = new JLabel("View Personal Details");
        heading.setBounds(250,5,300,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,22));
        heading.setForeground(Color.WHITE);
        p1.add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,60,150,25);
        add(lblname);
        labelname = new JLabel(name);
        labelname.setBounds(220,60,150,25);
        add(labelname);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,120,150,25);
        add(lblid);
        labelid = new JLabel();
        labelid.setBounds(220,120,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,180,150,25);
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(220,180,150,25);
        add(labelnumber);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,240,150,25);
        add(lblusername);
        labelusername = new JLabel();
        labelusername.setBounds(220,240,150,25);
        add(labelusername);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,300,150,25);
        add(lblgender);
        labelgender = new JLabel();
        labelgender.setBounds(220,300,150,25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30,360,150,25);
        add(lblcountry);
        labelcountry = new JLabel();
        labelcountry.setBounds(220,360,150,25);
        add(labelcountry);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,300,150,25);
        add(lblgender);
        labelgender = new JLabel();
        labelgender.setBounds(220,300,150,25);
        add(labelgender);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,300,150,25);
        add(lblgender);
        labelgender = new JLabel();
        labelgender.setBounds(220,300,150,25);
        add(labelgender);

        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("View Details");
        setVisible(true);
    }
    public static void main(String[] args) {
        new ViewCustomer("","");
    }
}
