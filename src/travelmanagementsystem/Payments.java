package travelmanagementsystem;

import javax.swing.*;

public class Payments extends JFrame {
    String username,password;
    Payments(String username, String password){
        this.username=username;
        this.password=password;


        
    }

    public static void main(String[] args) {
        new Payments("","");
    }
}
