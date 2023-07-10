package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewHotel extends JFrame implements ActionListener {
    String username,password;
    JLabel labelname,labelfood,labeltype,labelhotel,labelperson,labelid,labelnumber,labelprice,labelphone,labeldays;
    JButton back;
    ViewHotel(String username,String password){
        this.username=username;
        this.password=password;

        JPanel p1 = new JPanel(null);
        p1.setBounds(0,0,1000,50);
        p1.setBackground(new Color(0,0,102));
        add(p1);
        JLabel heading = new JLabel("Booked Hotel Details");
        heading.setBounds(250,5,300,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,22));
        heading.setForeground(Color.WHITE);
        p1.add(heading);

        JLabel lblname = new JLabel("Username");
        lblname.setBounds(30,60,150,25);
        add(lblname);
        labelname = new JLabel(username);
        labelname.setBounds(220,60,150,25);
        add(labelname);

        JLabel lblhotel = new JLabel("Hotel Name");
        lblhotel.setBounds(30,100,150,25);
        add(lblhotel);
        labelhotel = new JLabel();
        labelhotel.setBounds(220,100,150,25);
        labelhotel.setFont(new Font("Tahoma",Font.BOLD,18));
        labelhotel.setForeground(new Color(31,81,255));
        add(labelhotel);

        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setBounds(30,140,150,25);
        add(lblperson);
        labelperson = new JLabel();
        labelperson.setBounds(220,140,150,25);
        add(labelperson);

        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(30,180,150,25);
        add(lbldays);
        labeldays = new JLabel();
        labeldays.setBounds(220,180,150,25);
        add(labeldays);

        JLabel lbltype = new JLabel("Type");
        lbltype.setBounds(30,220,150,25);
        add(lbltype);
        labeltype = new JLabel();
        labeltype.setBounds(220,220,150,25);
        add(labeltype);

        JLabel lblfood = new JLabel("Food Included?");
        lblfood.setBounds(30,260,150,25);
        add(lblfood);
        labelfood = new JLabel();
        labelfood.setBounds(220,260,150,25);
        add(labelfood);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,300,150,25);
        add(lblid);
        labelid = new JLabel();
        labelid.setBounds(220,300,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,340,150,25);
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(220,340,150,25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,380,100,25);
        add(lblphone);
        labelphone = new JLabel();
        labelphone.setBounds(220,380,100,25);
        add(labelphone);

        JLabel lblprice = new JLabel("Total Cost");
        lblprice.setBounds(30,420,100,25);
        add(lblprice);
        labelprice = new JLabel();
        labelprice.setBounds(220,420,150,25);
        labelprice.setFont(new Font("Tahoma",Font.BOLD,18));
        labelprice.setForeground(new Color(31,81,255));
        add(labelprice);

        back = new JButton("Back");
        back.setBounds(220,480,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,70,500,400);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bookhotel where username = '"+username+"'");
            if(rs.next()){
                labelhotel.setText(rs.getString("hotel"));
                labelperson.setText(rs.getString("person"));
                labelprice.setText(rs.getString("price"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labeltype.setText(rs.getString("type"));
                labeldays.setText(rs.getString("days"));
                labelfood.setText(rs.getString("food"));
            }
            else{
                JOptionPane.showMessageDialog(null,"You have not booked any package");
                setVisible(false);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        setBounds(450,200,1000,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("View Hotel");
        setVisible(true);
    }
    public static void main(String[] args) {
        new ViewHotel("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            setVisible(false);
        }
    }
}
