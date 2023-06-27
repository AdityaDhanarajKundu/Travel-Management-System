package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    String username;
    JProgressBar bar;
    Thread t;
    Loading(String username){
        this.username= username;

        t = new Thread(this);
        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        text.setForeground(Color.BLUE);
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel wait = new JLabel("Loading, please wait...");
        wait.setBounds(230,130,170,30);
        wait.setFont(new Font("Raleway",Font.BOLD,16));
        wait.setForeground(Color.red);
        add(wait);

        JLabel welcome = new JLabel("Welcome, "+username);
        welcome.setBounds(20,310,400,40);
        welcome.setFont(new Font("Raleway",Font.BOLD,16));
        welcome.setForeground(Color.RED);
        add(welcome);

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
