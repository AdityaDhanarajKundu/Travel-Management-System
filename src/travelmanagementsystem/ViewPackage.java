package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener {
    String password,username;
    JLabel labelname,labelpackage,labelperson,labelid,labelnumber,labelprice,labelphone;
    JButton back;
    ViewPackage(String username,String password){

        this.username=username;
        this.password=password;

        JPanel p1 = new JPanel(null);
        p1.setBounds(0,0,900,50);
        p1.setBackground(new Color(0,0,102));
        add(p1);
        JLabel heading = new JLabel("Booked Package Details");
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

        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30,100,150,25);
        add(lblpackage);
        labelpackage = new JLabel();
        labelpackage.setBounds(220,100,150,25);
        labelpackage.setFont(new Font("Tahoma",Font.BOLD,18));
        labelpackage.setForeground(new Color(31,81,255));
        add(labelpackage);

        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setBounds(30,140,150,25);
        add(lblperson);
        labelperson = new JLabel();
        labelperson.setBounds(220,140,150,25);
        add(labelperson);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,180,150,25);
        add(lblid);
        labelid = new JLabel();
        labelid.setBounds(220,180,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,220,150,25);
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(220,220,150,25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,260,100,25);
        add(lblphone);
        labelphone = new JLabel();
        labelphone.setBounds(220,260,100,25);
        add(labelphone);

        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30,300,100,25);
        add(lblprice);
        labelprice = new JLabel();
        labelprice.setBounds(220,300,150,25);
        labelprice.setFont(new Font("Tahoma",Font.BOLD,18));
        labelprice.setForeground(new Color(31,81,255));
        add(labelprice);

        back = new JButton("Back");
        back.setBounds(220,360,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bookpackage where username = '"+username+"'");
            if(rs.next()){
                labelpackage.setText(rs.getString("package"));
                labelperson.setText(rs.getString("persons"));
                labelprice.setText(rs.getString("price"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
            else{
                JOptionPane.showMessageDialog(null,"You have not booked any package");
                setVisible(false);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("View Package");
        setVisible(true);
    }
    public static void main(String[] args) {
        new ViewPackage("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            setVisible(false);
        }
    }
}
