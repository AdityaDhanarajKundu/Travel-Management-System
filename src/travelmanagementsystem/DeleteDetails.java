package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DeleteDetails extends JFrame implements ActionListener {
    String username,password;
    JLabel labelname,labelid,labelnumber,labelusername,labelgender,labelcountry,labeladdress,labelphone,labelemail;
    JButton back,delete;
    DeleteDetails(String username,String password){
        this.username= username;
        this.password = password;

        JPanel p1 = new JPanel(null);
        p1.setBounds(0,0,870,50);
        p1.setBackground(new Color(0,0,102));
        add(p1);
        JLabel heading = new JLabel("Delete Personal Details");
        heading.setBounds(250,5,300,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,22));
        heading.setForeground(Color.WHITE);
        p1.add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,60,150,25);
        add(lblname);
        labelname = new JLabel();
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
        labelusername = new JLabel(username);
        labelusername.setBounds(220,240,150,25);
        add(labelusername);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,300,150,25);
        add(lblgender);
        labelgender = new JLabel();
        labelgender.setBounds(220,300,150,25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500,60,100,25);
        add(lblcountry);
        labelcountry = new JLabel();
        labelcountry.setBounds(630,60,150,25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500,120,100,25);
        add(lbladdress);
        labeladdress = new JLabel();
        labeladdress.setBounds(630,120,150,25);
        add(labeladdress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500,180,100,25);
        add(lblphone);
        labelphone = new JLabel();
        labelphone.setBounds(630,180,100,25);
        add(labelphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500,240,100,25);
        add(lblemail);
        labelemail = new JLabel();
        labelemail.setBounds(630,240,160,25);
        add(labelemail);

        back = new JButton("Back");
        back.setBounds(350,350,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        delete = new JButton("Delete");
        delete.setBounds(550,350,100,25);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(40,300,700,400);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Delete Details");
        setVisible(true);
    }

    public static void main(String[] args) {
        new DeleteDetails("Shakira","2478");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==delete){
            int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?","Delete Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if(result==JOptionPane.YES_OPTION){
                try {
                    Conn c = new Conn();

                    String query1 = "delete from account where username = '"+username+"' and password = '"+password+"'";
                    String query2 = "delete from customer where username = '"+username+"'";
                    String query3 = "delete from bookpackage where username = '"+username+"'";
                    String query4 = "delete from bookhotel where username = '"+username+"'";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                    c.s.executeUpdate(query4);

                    JOptionPane.showMessageDialog(null,"Details Deleted Successfully");
                    //close the program
                    System.exit(0);
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        }
        else {
            setVisible(false);
        }
    }
}
