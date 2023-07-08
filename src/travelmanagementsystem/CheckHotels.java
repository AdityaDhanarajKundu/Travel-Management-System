package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class CheckHotels extends JFrame implements Runnable{
    String username,password;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JLabel[] imagelabel = {l1,l2,l3,l4,l5,l6,l7,l8,l9,l10};
    Thread t1;
    @Override
    public void run() {

        try{
            for(int i=0;i<10;i++){
                imagelabel[i].setVisible(true);
                Thread.sleep(2500);
                imagelabel[i].setVisible(false);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    CheckHotels(String username,String password){
        this.username=username;
        this.password=password;

        ImageIcon i1=null,i2=null,i3=null,i4=null,i5=null,i6=null,i7=null,i8=null,i9=null,i10=null;
        ImageIcon[] imageiconarr1 = {i1,i2,i3,i4,i5,i6,i7,i8,i9,i10};

        Image j1=null,j2=null,j3=null,j4=null,j5=null,j6=null,j7=null,j8=null,j9=null,j10=null;
        Image[] imagearr1 = {j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};

        ImageIcon k1=null,k2=null,k3=null,k4=null,k5=null,k6=null,k7=null,k8=null,k9=null,k10=null;
        ImageIcon[] imageiconarr2 = {k1,k2,k3,k4,k5,k6,k7,k8,k9,k10};

        //adding a for loop to add all the 10 hotel images on the frame for slideshow
        for(int i =0; i<10;i++){
            imageiconarr1[i] = new ImageIcon(ClassLoader.getSystemResource("icons/hotel"+(i+1)+".jpg"));
            imagearr1[i] = imageiconarr1[i].getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
            imageiconarr2[i] = new ImageIcon(imagearr1[i]);
            imagelabel[i] = new JLabel(imageiconarr2[i]);
            imagelabel[i].setBounds(0,0,800,600);
            add(imagelabel[i]);
        }

        setBounds(500,200,800,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("View Hotels");
        setVisible(true);
    }
    public static void main(String[] args) {
        new CheckHotels("","");
    }
}
