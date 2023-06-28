package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class AddCustomer extends JFrame {
    JLabel labelusername,labelname,lblcountry;
    JTextField number_text,country_text,address_text,phone_text,email_text;
    JComboBox idchoice;
    JRadioButton male,female,trans;
    JButton add,back;
    AddCustomer(){
        JPanel p1 = new JPanel(null);
        p1.setBounds(0,0,850,40);
        p1.setBackground(new Color(0,0,102));
        add(p1);
        JLabel heading = new JLabel("Add Personal Details");
        heading.setBounds(250,5,300,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,22));
        heading.setForeground(Color.WHITE);
        p1.add(heading);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        String[] ids = {"Passport","Aadhar Card","Voter Card","PAN Card","Driving Licence"};
        idchoice = new JComboBox(ids);
        idchoice.setBounds(220,90,150,25);
        idchoice.setBackground(Color.WHITE);
        add(idchoice);

        JLabel number = new JLabel("Number");
        number.setBounds(30,130,150,25);
        add(number);
        number_text = new JTextField();
        number_text.setBounds(220,130,150,25);
        add(number_text);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);

        JLabel sex = new JLabel("Gender :");
        sex.setBounds(30,210,150,25);
        add(sex);
        male=new JRadioButton("Male");
        male.setBounds(220, 210, 70, 25);
        male.setBackground(Color.WHITE);
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(300, 210, 70, 25);
        female.setBackground(Color.WHITE);
        add(female);
        trans=new JRadioButton("Transgender");
        trans.setBounds(380, 210, 100, 25);
        trans.setBackground(Color.WHITE);
        add(trans);
        ButtonGroup radiogroup;
        radiogroup = new ButtonGroup();
        radiogroup.add(male);
        radiogroup.add(female);
        radiogroup.add(trans);

        lblcountry = new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        country_text = new JTextField();
        country_text.setBounds(220,250,150,25);
        add(country_text);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        address_text = new JTextField();
        address_text.setBounds(220,290,150,25);
        add(address_text);

        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(30,330,150,25);
        add(lblphone);
        phone_text = new JTextField();
        phone_text.setBounds(220,330,150,25);
        add(phone_text);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30,370,150,25);
        add(lblemail);
        email_text = new JTextField();
        email_text.setBounds(220,370,150,25);
        add(email_text);

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70,430,100,25);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,430,100,25);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(430,50,400,500);
        add(image);

        setBounds(450,200,850,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Add Details");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new AddCustomer();
    }
}
