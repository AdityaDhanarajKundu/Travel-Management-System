package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckPackages extends JFrame implements ActionListener {
    JTabbedPane tab;
    JPanel closeButtonPanel;
    JButton back;
    CheckPackages(){
        String[] package1 = new String[]{"package1.jpg","GOLD PACKAGE","6 days and 7 Nights", "Airport Assistance at Aiport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", "Summer Special", "Rs 25000 only"};
        String[] package2 = new String[]{"package2.jpg","SILVER PACKAGE","4 days and 3 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Aiport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW", "Winter Special", "Rs 15000 only"};
        String[] package3 = new String[]{"package3.jpg","DIAMOND PACKAGE","6 days and 5 Nights", "Return Airfare", "Free Clubbing & Horse Ride", "Welcome drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW", "Winter Special", "Rs 32000 only"};

        tab = new JTabbedPane();    //creating the tab object
        JPanel p1 = create_package(package1);
        tab.addTab("Package 1",null,p1);
        JPanel p2 = create_package(package2);
        tab.addTab("Package 2",null,p2);
        JPanel p3 = create_package(package3);
        tab.addTab("Package 3",null,p3);
        add(tab);

        addCloseButtonToPackage(p1);
        addCloseButtonToPackage(p2);
        addCloseButtonToPackage(p3);

        setBounds(450,200,900,600);
        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
        setTitle("Check Packages");
        setVisible(true);

    }
    private void addCloseButtonToPackage(JPanel packagePanel) {
        JPanel closeButtonPanel = new JPanel();
        closeButtonPanel.setBackground(new Color(236, 236, 236));
        closeButtonPanel.setLayout(null);
        closeButtonPanel.setBounds(600, 500, 200, 40);
        packagePanel.add(closeButtonPanel);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(50, 5, 100, 25);
        back.addActionListener(this);
        closeButtonPanel.add(back);
    }
    //creating a function to create the different panels upon calling the function
    public JPanel create_package(String[]pack){
        JPanel p1 = new JPanel(null);
        p1.setBackground(new Color(236,236,236));
        add(p1);
        JPanel header = new JPanel(null);
        header.setBounds(0,0,900,40);
        header.setBackground(new Color(0,0,102));
        p1.add(header);

        JLabel l1 = new JLabel(pack[1]);
        l1.setBounds(50,5,400,30);
        l1.setForeground(Color.YELLOW);
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        header.add(l1);

        JLabel l2 = new JLabel(pack[2]);
        l2.setBounds(30,60,300,30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l2);

        JLabel l3 = new JLabel(pack[3]);
        l3.setBounds(30,110,300,30);
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l3);

        JLabel l4 = new JLabel(pack[4]);
        l4.setBounds(30,160,300,30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l4);

        JLabel l5 = new JLabel(pack[5]);
        l5.setBounds(30,210,300,30);
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l5);

        JLabel l6 = new JLabel(pack[6]);
        l6.setBounds(30,260,300,30);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l6);

        JLabel l7 = new JLabel(pack[7]);
        l7.setBounds(30,310,300,30);
        l7.setForeground(Color.BLUE);
        l7.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l7);

        JLabel l8 = new JLabel(pack[8]);
        l8.setBounds(30,360,300,30);
        l8.setForeground(Color.RED);
        l8.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l8);

        JLabel l9 = new JLabel(pack[9]);
        l9.setBounds(30,430,300,30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("San Serif", Font.BOLD, 25));
        p1.add(l9);

        JLabel l10 = new JLabel(pack[10]);
        l10.setBounds(30,480,300,30);
        l10.setForeground(Color.MAGENTA);
        l10.setFont(new Font("San Serif", Font.BOLD, 25));
        p1.add(l10);

        JLabel l11 = new JLabel(pack[11]);
        l11.setBounds(400,480,300,30);
        l11.setForeground(new Color(66, 133, 244));
        l11.setFont(new Font("San Serif", Font.BOLD, 25));
        p1.add(l11);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[0]));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,100,500,300);
        p1.add(image);

        return p1;
    }
    public static void main(String[] args) {
        new CheckPackages();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
    }
}
