package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class CheckPackages extends JFrame {
    JTabbedPane tab;
    CheckPackages(){

        JPanel p1 = new JPanel(null);
        p1.setBackground(Color.WHITE);

        tab = new JTabbedPane();
        tab.addTab("Package 1",null,p1);
        add(tab);

        JLabel l1 = new JLabel("GOLD PACKAGE");
        l1.setBounds(50,5,300,30);
        l1.setForeground(Color.YELLOW);
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add()

        setBounds(450,200,900,600);
        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
        setTitle("Check Packages");
        setVisible(true);

    }
    public static void main(String[] args) {
        new CheckPackages();
    }
}
