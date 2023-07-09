package travelmanagementsystem;

import javax.swing.*;

public class ViewHotel extends JFrame {
    String username,password;
    ViewHotel(String username,String password){
        this.username=username;
        this.password=password;

        
    }
    public static void main(String[] args) {
        new ViewHotel("","");
    }
}
