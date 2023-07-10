package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payments extends JFrame implements ActionListener {

    JButton pay,back;
    Payments(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,600);
        add(image);

        pay=new JButton("Pay");
        pay.setBounds(420,0,80,40);
        pay.addActionListener(this);
        pay.setBackground(Color.WHITE);
        pay.setForeground(Color.BLACK);
        pay.setBorder(BorderFactory.createEmptyBorder());
        pay.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(pay);

        back=new JButton("Back");
        back.setBounds(520,0,80,40);
        back.addActionListener(this);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway",Font.BOLD,20));
        back.setBorder(BorderFactory.createEmptyBorder());
        image.add(back);

        setBounds(500,200,800,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Payments");
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Payments();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pay){
            setVisible(false);
            new Paytm().setVisible(true);
        }
        else{
            setVisible(false);
        }
    }
}
