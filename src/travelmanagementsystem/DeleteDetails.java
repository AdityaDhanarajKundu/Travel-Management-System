package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class DeleteDetails extends JFrame {
    String username,password;
    JLabel labelname,labelid,labelnumber,labelusername,labelgender,labelcountry,labeladdress,labelphone,labelemail;
    JButton back,delete;
    DeleteDetails(String username,String password){
        this.username= username;
        this.password = password;



        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Delete Details");
        setVisible(true);
    }

    public static void main(String[] args) {
        new DeleteDetails("","");
    }
}
