package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField username_text,name_text,question_text,answer_text,password_text;
    JButton search,retrieve,back;

    ForgetPassword(){

        JPanel p1 = new JPanel(null);
        p1.setBounds(30,30,500,280);
        p1.setBackground(new Color(131,193,233));
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forget.jpg"));
        Image i2 = i1.getImage().getScaledInstance(280,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(560,20,280,300);
        add(image);

        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,25);
        username.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(username);
        username_text = new JTextField();
        username_text.setBounds(220,20,150,25);
        username_text.setBorder(BorderFactory.createEmptyBorder());
        p1.add(username_text);

        search = new JButton("SEARCH");
        search.setBackground(Color.WHITE);
        search.setForeground(Color.BLACK);
        search.setFont(new Font("Raleway",Font.BOLD,14));
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);

        JLabel name = new JLabel("Name");
        name.setBounds(40,60,100,25);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(name);
        name_text = new JTextField();
        name_text.setBounds(220,60,150,25);
        name_text.setBorder(BorderFactory.createEmptyBorder());
        p1.add(name_text);

        JLabel question = new JLabel("Your Security Question");
        question.setBounds(40,100,160,25);
        question.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(question);
        question_text = new JTextField();
        question_text.setBounds(220,100,150,25);
        question_text.setBorder(BorderFactory.createEmptyBorder());
        p1.add(question_text);

        JLabel answerl = new JLabel("Answer");
        answerl.setBounds(40,140,130,25);
        answerl.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(answerl);
        answer_text = new JTextField();
        answer_text.setBounds(220,140,150,25);
        answer_text.setBorder(BorderFactory.createEmptyBorder());
        p1.add(answer_text);

        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.WHITE);
        retrieve.setForeground(Color.BLACK);
        retrieve.setFont(new Font("Raleway",Font.BOLD,14));
        retrieve.addActionListener(this);
        retrieve.setBounds(380,140,100,25);
        p1.add(retrieve);

        JLabel password = new JLabel("Password");
        password.setBounds(40,180,130,25);
        password.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(password);
        password_text = new JTextField();
        password_text.setBounds(220,180,150,25);
        password_text.setBorder(BorderFactory.createEmptyBorder());
        p1.add(password_text);

        back = new JButton("BACK");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);

        setBounds(350,200,850,380);
        setTitle("Forget Password");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Login().setVisible(true);
        } if (e.getSource()==retrieve) {
            try{
                String query= "select * from account where answer = '"+answer_text.getText()+"' AND username = '"+username_text.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    password_text.setText(rs.getString("password"));
                }
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
        } if (e.getSource()==search) {
            try{
                String query= "select * from account where username = '"+username_text.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    name_text.setText(rs.getString("name"));
                    question_text.setText(rs.getString("question"));
                }
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }
}
