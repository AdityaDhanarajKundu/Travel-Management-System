package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JButton add_pdetails,update_pdetails,view_pdetails,delete_pdetails,view_booked_hotels,calculator,about;
    JButton check_package,book_package,view_package,view_hotels,book_hotels,destination,notepad,payments;
    String username,password;
    Dashboard(String username,String password){
        this.username=username;
        this.password=password;

        JPanel p1 = new JPanel(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,2000,65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5,0,70,70);
        p1.add(image);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        heading.setForeground(Color.WHITE);
        JLabel contacts1 = new JLabel("email : adityadhanarajkundu@gmail.com");
        contacts1.setFont(new Font("Tahoma",Font.BOLD,18));
        contacts1.setForeground(Color.WHITE);
        contacts1.setBounds(1500,30,400,40);
        p1.add(contacts1);
        p1.add(heading);

        JPanel p2 = new JPanel(null);
        p2.setBackground(new Color(215,0,64));
        p2.setBounds(0,65,300,1000);
        add(p2);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(2000,1200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(0,0,2000,1200);
        add(image2);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setFont(new Font("Raleway",Font.PLAIN,50));
        text.setBounds(650,90,1000,100);
        text.setForeground(Color.WHITE);
        image2.add(text);

        add_pdetails = new JButton("Add Personal Details");
        add_pdetails.setBounds(0,0,300,50);
        add_pdetails.setBackground(new Color(215,0,64));
        add_pdetails.setForeground(Color.WHITE);
        add_pdetails.setFont(new Font("Tahoma",Font.BOLD,20));
        add_pdetails.setMargin(new Insets(0,0,0,60)); //adds margin or padding
        add_pdetails.addActionListener(this);
        p2.add(add_pdetails);

        update_pdetails = new JButton("Update Personal Details");
        update_pdetails.setBounds(0,50,300,50);
        update_pdetails.setBackground(new Color(215,0,64));
        update_pdetails.setForeground(Color.WHITE);
        update_pdetails.setFont(new Font("Tahoma",Font.BOLD,20));
        update_pdetails.setMargin(new Insets(0,0,0,30)); //adds margin or padding
        update_pdetails.addActionListener(this);
        p2.add(update_pdetails);

        view_pdetails = new JButton("View Details");
        view_pdetails.setBounds(0,100,300,50);
        view_pdetails.setBackground(new Color(215,0,64));
        view_pdetails.setForeground(Color.WHITE);
        view_pdetails.setFont(new Font("Tahoma",Font.BOLD,20));
        view_pdetails.setMargin(new Insets(0,0,0,138)); //adds margin or padding
        view_pdetails.addActionListener(this);
        p2.add(view_pdetails);

        delete_pdetails = new JButton("Delete Personal Details");
        delete_pdetails.setBounds(0,150,300,50);
        delete_pdetails.setBackground(new Color(215,0,64));
        delete_pdetails.setForeground(Color.WHITE);
        delete_pdetails.setFont(new Font("Tahoma",Font.BOLD,20));
        delete_pdetails.setMargin(new Insets(0,0,0,34)); //adds margin or padding
        delete_pdetails.addActionListener(this);
        p2.add(delete_pdetails);

        check_package = new JButton("Check Package");
        check_package.setBounds(0,200,300,50);
        check_package.setBackground(new Color(215,0,64));
        check_package.setForeground(Color.WHITE);
        check_package.setFont(new Font("Tahoma",Font.BOLD,20));
        check_package.setMargin(new Insets(0,0,0,110)); //adds margin or padding
        check_package.addActionListener(this);
        p2.add(check_package);

        book_package = new JButton("Book Package");
        book_package.setBounds(0,250,300,50);
        book_package.setBackground(new Color(215,0,64));
        book_package.setForeground(Color.WHITE);
        book_package.setFont(new Font("Tahoma",Font.BOLD,20));
        book_package.setMargin(new Insets(0,0,0,120)); //adds margin or padding
        book_package.addActionListener(this);
        p2.add(book_package);

        view_package = new JButton("View Package");
        view_package.setBounds(0,300,300,50);
        view_package.setBackground(new Color(215,0,64));
        view_package.setForeground(Color.WHITE);
        view_package.setFont(new Font("Tahoma",Font.BOLD,20));
        view_package.setMargin(new Insets(0,0,0,120)); //adds margin or padding
        view_package.addActionListener(this);
        p2.add(view_package);

        view_hotels = new JButton("View Hotels");
        view_hotels.setBounds(0,350,300,50);
        view_hotels.setBackground(new Color(215,0,64));
        view_hotels.setForeground(Color.WHITE);
        view_hotels.setFont(new Font("Tahoma",Font.BOLD,20));
        view_hotels.setMargin(new Insets(0,0,0,140)); //adds margin or padding
        view_hotels.addActionListener(this);
        p2.add(view_hotels);

        book_hotels = new JButton("Book Hotels");
        book_hotels.setBounds(0,400,300,50);
        book_hotels.setBackground(new Color(215,0,64));
        book_hotels.setForeground(Color.WHITE);
        book_hotels.setFont(new Font("Tahoma",Font.BOLD,20));
        book_hotels.setMargin(new Insets(0,0,0,140)); //adds margin or padding
        book_hotels.addActionListener(this);
        p2.add(book_hotels);

        view_booked_hotels = new JButton("View Booked Hotels");
        view_booked_hotels.setBounds(0,450,300,50);
        view_booked_hotels.setBackground(new Color(215,0,64));
        view_booked_hotels.setForeground(Color.WHITE);
        view_booked_hotels.setFont(new Font("Tahoma",Font.BOLD,20));
        view_booked_hotels.setMargin(new Insets(0,0,0,60)); //adds margin or padding
        view_booked_hotels.addActionListener(this);
        p2.add(view_booked_hotels);

        destination = new JButton("Destinations");
        destination.setBounds(0,500,300,50);
        destination.setBackground(new Color(215,0,64));
        destination.setForeground(Color.WHITE);
        destination.setFont(new Font("Tahoma",Font.BOLD,20));
        destination.setMargin(new Insets(0,0,0,140)); //adds margin or padding
        destination.addActionListener(this);
        p2.add(destination);

        calculator = new JButton("Calculator");
        calculator.setBounds(0,550,300,50);
        calculator.setBackground(new Color(215,0,64));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma",Font.BOLD,20));
        calculator.setMargin(new Insets(0,0,0,160)); //adds margin or padding
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBounds(0,600,300,50);
        notepad.setBackground(new Color(215,0,64));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma",Font.BOLD,20));
        notepad.setMargin(new Insets(0,0,0,170)); //adds margin or padding
        notepad.addActionListener(this);
        p2.add(notepad);

        payments = new JButton("Payments");
        payments.setBounds(0,650,300,50);
        payments.setBackground(new Color(215,0,64));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma",Font.BOLD,20));
        payments.setMargin(new Insets(0,0,0,160)); //adds margin or padding
        payments.addActionListener(this);
        p2.add(payments);

        about = new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(215,0,64));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.BOLD,20));
        about.setMargin(new Insets(0,0,0,194)); //adds margin or padding
        about.addActionListener(this);
        p2.add(about);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Dashboard");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Dashboard("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add_pdetails){
            new AddCustomer(username,password).setVisible(true);
        } else if (e.getSource()==view_pdetails) {
            new ViewCustomer(username,password).setVisible(true);
        } else if (e.getSource()==update_pdetails) {
            new UpdateCustomer(username,password).setVisible(true);
        } else if (e.getSource()==check_package) {
            new CheckPackages().setVisible(true);
        } else if (e.getSource()==book_package) {
            new BookPackage(username,password).setVisible(true);
        } else if (e.getSource()==view_package) {
            new ViewPackage(username,password).setVisible(true);
        } else if (e.getSource()==view_hotels) {
            new CheckHotels(username,password).setVisible(true);
        } else if (e.getSource()==destination) {
            new Destination(username,password).setVisible(true);
        } else if (e.getSource()==book_hotels) {
            new BookHotel(username,password).setVisible(true);
        }else if(e.getSource()==view_booked_hotels){
            new ViewHotel(username,password).setVisible(true);
        } else if (e.getSource()==payments) {
            new Payments().setVisible(true);
        } else if (e.getSource()==calculator) {
            //since the calculator app is an external entity there is chance of errors and exceptions happening
            // So we need to use the try and catch block
            try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
        } else if (e.getSource()==notepad) {
            //since the notepad app is an external entity there is chance of errors and exceptions happening
            // So we need to use the try and catch block
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
        } else if (e.getSource()==about) {
            new About().setVisible(true);
        } else if (e.getSource()==delete_pdetails) {
            new DeleteDetails(username,password).setVisible(true);
        }
    }
}
