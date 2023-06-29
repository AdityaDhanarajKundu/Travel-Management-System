package travelmanagementsystem;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login,signup,forgot;
    JTextField username;
    JPasswordField password;
    Login(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,115,200,200);
        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(236,236,236));
        p2.setBounds(400,30,450,300);
        add(p2);

        JLabel name = new JLabel("Username");
        name.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        name.setBounds(60,20,100,25);
        p2.add(name);
        username = new JTextField();
        username.setBounds(60,60,300,30);
        username.setFont(new Font("Raleway",Font.BOLD,15));
        username.setBorder(BorderFactory.createEmptyBorder());
        p2.add(username);

        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        pass.setBounds(60,110,100,25);
        p2.add(pass);
        password = new JPasswordField();
        password.setBounds(60,150,300,30);
        password.setFont(new Font("Raleway",Font.BOLD,15));
        password.setBorder(BorderFactory.createEmptyBorder());
        p2.add(password);

        login = new JButton("LOGIN");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(131,193,233));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Raleway",Font.BOLD,18));
        login.setBorder(new LineBorder(new Color(131,193,233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("SIGNUP");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(131,193,233));
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("Raleway",Font.BOLD,18));
        signup.setBorder(new LineBorder(new Color(131,193,233)));
        signup.addActionListener(this);
        p2.add(signup);

        forgot = new JButton("FORGET PASSWORD");
        forgot.setBounds(130,250,130,30);
        forgot.setBackground(new Color(131,193,233));
        forgot.setForeground(Color.WHITE);
        forgot.setFont(new Font("Raleway",Font.BOLD,12));
        forgot.setBorder(new LineBorder(new Color(131,193,233)));
        forgot.addActionListener(this);
        p2.add(forgot);

        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(300,258,150,20);
        text.setForeground(Color.red);
        p2.add(text);

        setSize(900,400);
        setLayout(null);
        setTitle("Login Page");
        setLocation(350,200);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==signup){
            setVisible(false);
            new Signup().setVisible(true);
        } else if (e.getSource()==forgot) {
            setVisible(false);
            new ForgetPassword().setVisible(true);
        } else if (e.getSource()==login) {
            try{
                String user = username.getText();
                String pass = password.getText();

                Conn c = new Conn();
                String query= "select * from account where password = '"+pass+"' AND username = '"+user+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    String u_name = rs.getString("username");
                    setVisible(false);
                    new Loading(u_name,pass).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
                }
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }
}
