package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    String username;
    JProgressBar bar;
    Thread t;
    Loading(String username){
        this.username= username;

        JPanel p1 = new JPanel(null);
        p1.setBounds(0,0,200,400);
        p1.setBackground(new Color(131,193,233));
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forget.jpg"));
        Image i2 = i1.getImage().getScaledInstance(280,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(560,20,280,300);
        add(image);

        t = new Thread(this);
        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(230,70,380,40);
        text.setFont(new Font("Raleway",Font.BOLD,25));
        text.setForeground(Color.BLUE);
        add(text);

        bar = new JProgressBar();
        bar.setBounds(230,150,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel wait = new JLabel("Loading, please wait...");
        wait.setBounds(230,190,170,30);
        wait.setFont(new Font("Raleway",Font.BOLD,16));
        wait.setForeground(Color.red);
        add(wait);

        JLabel welcome = new JLabel("Welcome, "+username);
        welcome.setBounds(20,310,400,40);
        welcome.setFont(new Font("Raleway",Font.BOLD,16));
        welcome.setForeground(Color.RED);
        p1.add(welcome);

        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Loading");
        t.start();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Loading("");
    }

    @Override
    public void run() {
        try{
            for (int i= 1;i<=101;i++){
                int max = bar.getMaximum();// to get the maximum value in progressbar
                int value = bar.getValue(); //to get the current value in progress bar

                if (value<max){
                    bar.setValue(value+1);
                }
                else { //when the value is more than 100
                    setVisible(false);

                }
                Thread.sleep(60);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
