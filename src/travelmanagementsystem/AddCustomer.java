package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class AddCustomer extends JFrame {
    AddCustomer(){
        

        setBounds(450,200,850,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Add Details");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new AddCustomer();
    }
}
