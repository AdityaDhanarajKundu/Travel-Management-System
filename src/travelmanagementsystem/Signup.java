package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {

    JTextField username,name,answer;
    JPasswordField password;
    JComboBox qdrop;
    JButton create,back;
    Signup(){

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setLayout(null);
        p1.setBounds(0,0,500,400);
        add(p1);

        JLabel uname = new JLabel("Username");
        uname.setFont(new Font("Tahoma",Font.BOLD,14));
        uname.setBounds(50,20,125,25);
        p1.add(uname);
        username = new JTextField();
        username.setBounds(190,20,180,25);
        username.setFont(new Font("Raleway",Font.BOLD,15));
        username.setBorder(BorderFactory.createEmptyBorder());
        p1.add(username);

        JLabel lname = new JLabel("Name");
        lname.setFont(new Font("Tahoma",Font.BOLD,14));
        lname.setBounds(50,60,125,25);
        p1.add(lname);
        name = new JTextField();
        name.setBounds(190,60,180,25);
        name.setFont(new Font("Raleway",Font.BOLD,15));
        name.setBorder(BorderFactory.createEmptyBorder());
        p1.add(name);

        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("Tahoma",Font.BOLD,14));
        pass.setBounds(50,100,125,25);
        p1.add(pass);
        password = new JPasswordField();
        password.setBounds(190,100,180,25);
        password.setFont(new Font("Raleway",Font.BOLD,15));
        password.setBorder(BorderFactory.createEmptyBorder());
        p1.add(password);

        JLabel sec_q = new JLabel("Security Question");
        sec_q.setFont(new Font("Tahoma",Font.BOLD,14));
        sec_q.setBounds(50,140,125,25);
        p1.add(sec_q);
        String[] questions = {"Favourite WebSeries","Favourite Footballer","Favourite SuperHero","Favourite Dish"};
        qdrop = new JComboBox<>(questions);
        qdrop.setBounds(190,140,180,25);
        p1.add(qdrop);

        JLabel ans = new JLabel("Answer");
        ans.setFont(new Font("Tahoma",Font.BOLD,14));
        ans.setBounds(50,180,125,25);
        p1.add(ans);
        answer = new JTextField();
        answer.setBounds(190,180,180,25);
        answer.setFont(new Font("Raleway",Font.BOLD,15));
        answer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(answer);

        create = new JButton("CREATE");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setFont(new Font("Raleway",Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,10,250,250);
        add(image);

        setSize(900,360);
        setLayout(null);
        setTitle("Signup Page");
        setLocation(350,200);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Signup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==create){
            String s_username = username.getText();
            String s_name = name.getText();
            String s_pass = password.getText();
            String s_question = qdrop.getSelectedItem().toString();
            String s_answer = answer.getText();

            try{
                Conn c = new Conn();
                String query = "insert into account values ('"+s_username+"', '"+s_name+"', '"+s_pass+"', '"+s_question+"', '"+s_answer+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account created successfully");
                setVisible(false);
                new Login().setVisible(true);
            }
            catch(Exception e1){
                System.out.println(e1);
            }

        } else if (e.getSource()==back) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
