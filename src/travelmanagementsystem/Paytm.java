package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {
    // In this class we will load the entire website of paytm in a TextArea inside the JFrame
    JEditorPane pane; //using a JEditorPane object instead of a JTextField object
    JScrollPane sp;
    JButton back;
    Paytm(){

        pane = new JEditorPane();
        pane.setEditable(false);

        // Since we are trying to load a website so it might be also unavailable sometimes and might
        // throw exception or error so we need to use the try catch block here
        try {
            pane.setPage("https://pay.google.com/about/"); //it takes a string url
        }
        catch (Exception e){
            pane.setContentType("text/html"); //to denote the string content in the editor pane is actually a html text not a simple text
            //setting the text if the webpage didn't load
            pane.setText("<html>Sorry, Could not load the webpage.</html>");
        }
        // We have to add a scrollable view to the frame
        sp = new JScrollPane(pane);
        getContentPane().add(sp);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setBounds(610,20,80,40);
        pane.add(back);

        setBounds(500,200,800,600);
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Paytm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Payments().setVisible(true);
    }
}
