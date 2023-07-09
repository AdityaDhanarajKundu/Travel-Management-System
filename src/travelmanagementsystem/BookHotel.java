package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener {
    String username,password;
    JLabel labelname,labelid,labelnumber,labelphone,labeltotal;
    JComboBox labelpackage;
    JSpinner spinner;
    JButton checkprice,book,back;
    BookHotel(String username,String password){
        this.username=username;
        this.password=password;

        JPanel p1 = new JPanel(null);
        p1.setBounds(0,0,1100,40);
        p1.setBackground(new Color(0,0,102));
        add(p1);
        JLabel heading = new JLabel("Book Hotel");
        heading.setBounds(150,10,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setForeground(Color.YELLOW);
        p1.add(heading);

        JPanel p2 = new JPanel(null);
        p2.setBounds(0,0,520,500);
        p2.setBackground(new Color(219 ,68 ,55));
        add(p2);

        JLabel lblname = new JLabel("Username");
        lblname.setBounds(40,70,100,20);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblname.setForeground(Color.WHITE);
        p2.add(lblname);
        labelname = new JLabel(username);
        labelname.setFont(new Font("Tahoma",Font.BOLD,16));
        labelname.setBounds(250,60,100,20);
        labelname.setForeground(Color.WHITE);
        p2.add(labelname);

        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpackage.setBounds(40,110,150,20);
        lblpackage.setForeground(Color.WHITE);
        p2.add(lblpackage);
        String[] packagechoice = {"Gold Package","Silver Package","Bronze Package"};
        labelpackage= new JComboBox<>(packagechoice);
        labelpackage.setBackground(Color.WHITE);
        labelpackage.setForeground(Color.BLACK);
        labelpackage.setBounds(250,110,150,20);
        labelpackage.setForeground(Color.WHITE);
        p2.add(labelpackage);

        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblperson.setBounds(40,150,150,20);
        lblperson.setForeground(Color.WHITE);
        p2.add(lblperson);
        //adding a number spinner to input the no. of persons
        //initialising the range of the spinner
        SpinnerNumberModel init = new SpinnerNumberModel(1,1,10,1);
        spinner = new JSpinner(init);
        spinner.setBounds(250,150,50,20);
        p2.add(spinner);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(40,190,150,25);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblid.setForeground(Color.WHITE);
        p2.add(lblid);
        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma",Font.BOLD,16));
        labelid.setBounds(250,190,150,25);
        labelid.setForeground(Color.WHITE);
        p2.add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,230,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnumber.setForeground(Color.WHITE);
        p2.add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(250,230,150,25);
        labelnumber.setFont(new Font("Tahoma",Font.BOLD,16));
        labelnumber.setForeground(Color.WHITE);
        p2.add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,270,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblphone.setForeground(Color.WHITE);
        p2.add(lblphone);
        labelphone = new JLabel();
        labelphone.setBounds(250,270,150,25);
        labelphone.setFont(new Font("Tahoma",Font.BOLD,16));
        labelphone.setForeground(Color.WHITE);
        p2.add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,310,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltotal.setForeground(Color.WHITE);
        p2.add(lbltotal);
        labeltotal = new JLabel();
        labeltotal.setBounds(250,310,150,25);
        labeltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        labeltotal.setForeground(Color.WHITE);
        p2.add(labeltotal);

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.WHITE);
        checkprice.setForeground(Color.BLACK);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        p2.add(checkprice);

        book = new JButton("Book Package");
        book.setBackground(Color.WHITE);
        book.setForeground(Color.BLACK);
        book.setBounds(200,380,120,25);
        book.addActionListener(this);
        p2.add(book);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        p2.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(560,70,500,300);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BookHotel("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
