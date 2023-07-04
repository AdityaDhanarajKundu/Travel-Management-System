package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {
    JLabel labelname,labelid,labelnumber,labelphone,labeltotal;
    JComboBox labelpackage;
    JSpinner spinner;
    String username,password;
    JButton checkprice,book,back;
    BookPackage(String username,String password){

        this.username=username;
        this.password=password;

        JPanel p1 = new JPanel(null);
        p1.setBounds(0,0,1100,40);
        p1.setBackground(new Color(0,0,102));
        add(p1);
        JLabel heading = new JLabel("Book Package");
        heading.setBounds(150,10,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setForeground(Color.YELLOW);
        p1.add(heading);

        JLabel lblname = new JLabel("Username");
        lblname.setBounds(40,70,100,20);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        labelname = new JLabel(username);
        labelname.setFont(new Font("Tahoma",Font.BOLD,16));
        labelname.setBounds(250,60,100,20);
        add(labelname);

        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpackage.setBounds(40,110,150,20);
        add(lblpackage);
        String[] packagechoice = {"Gold Package","Silver Package","Bronze Package"};
        labelpackage= new JComboBox<>(packagechoice);
        labelpackage.setBackground(Color.WHITE);
        labelpackage.setForeground(Color.BLACK);
        labelpackage.setBounds(250,110,150,20);
        add(labelpackage);

        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblperson.setBounds(40,150,150,20);
        add(lblperson);
        //adding a number spinner to input the no. of persons
        //initialising the range of the spinner
        SpinnerNumberModel init = new SpinnerNumberModel(1,1,10,1);
        spinner = new JSpinner(init);
        spinner.setBounds(250,150,50,20);
        add(spinner);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(40,190,150,25);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma",Font.BOLD,16));
        labelid.setBounds(250,190,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,230,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(250,230,150,25);
        labelnumber.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,270,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        labelphone = new JLabel();
        labelphone.setBounds(250,270,150,25);
        labelphone.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,310,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        labeltotal = new JLabel();
        labeltotal.setBounds(250,310,150,25);
        labeltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labeltotal);

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        book = new JButton("Book Package");
        book.setBackground(Color.BLACK);
        book.setForeground(Color.WHITE);
        book.setBounds(200,380,120,25);
        book.addActionListener(this);
        add(book);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BookPackage("@Aditya","1234");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            setVisible(false);
        }
        else if (e.getSource()==checkprice) {
            String pack = labelpackage.getSelectedItem().toString();
            int cost = 0;
            int heads = (int)spinner.getValue();
            if(pack.equals("Gold Package")){
                cost+=25000;
            } else if (pack.equals("Silver Package")) {
                cost+= 15000;
            } else if (pack.equals("Diamond Package")) {
                cost+=32000;
            }
            cost*=heads;
            labeltotal.setText("Rs. "+cost);
        }
        else if (e.getSource()==book) {
            try{
                Conn c = new Conn();
                String pack = labelpackage.getSelectedItem().toString();
                String person = spinner.getValue().toString();

                String query = "insert into bookpackage values ('"+username+"','"+pack+"','"+person+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labeltotal.getText()+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
}
