package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookHotel extends JFrame implements ActionListener {
    String username,password;
    JLabel labelname,labelid,labelnumber,labelphone,labeltotal;
    JTextField tfdays,tfperson;
    JComboBox labelhotel,cac;
    JRadioButton yes,no;
    JButton checkprice,book,back;
    //creating a JComboBox model
    DefaultComboBoxModel model;
    BookHotel(String username,String password){
        this.username=username;
        this.password=password;

        JPanel p1 = new JPanel(null);
        p1.setBounds(0,0,1100,40);
        p1.setBackground(new Color(0,0,102));
        add(p1);
        JLabel heading = new JLabel("Book Hotel");
        heading.setBounds(150,10,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setForeground(Color.YELLOW);
        p1.add(heading);

        JPanel p2 = new JPanel(null);
        p2.setBounds(0,0,520,600);
        p2.setBackground(new Color(219 ,68 ,55));
        add(p2);

        JLabel lblname = new JLabel("Username");
        lblname.setBounds(40,70,100,20);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblname.setForeground(Color.WHITE);
        p2.add(lblname);
        labelname = new JLabel(username);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelname.setBounds(250,60,100,20);
        labelname.setForeground(Color.WHITE);
        p2.add(labelname);

        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpackage.setBounds(40,110,150,20);
        lblpackage.setForeground(Color.WHITE);
        p2.add(lblpackage);
        //retrieving the hotel data from the database with a method
        List<String> data = retriveFromDatabase();
        model = new DefaultComboBoxModel<>();
        labelhotel= new JComboBox<>();
        //putting the hotel data stored in the data list into the defaultcomboboxmodel using a enhanced/for each loop
        for (String value:data){
            model.addElement(value);
        }
        labelhotel.setModel(model);
        labelhotel.repaint();
//        labelpackage.setBackground(Color.WHITE);
//        labelpackage.setForeground(Color.BLACK);
        labelhotel.setRenderer(new CustomComboBoxRenderer(data, Color.BLACK, Color.WHITE));
        labelhotel.setBounds(250,110,150,20);
        labelhotel.setForeground(Color.BLACK);
        p2.add(labelhotel);

        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbldays.setBounds(40,150,150,20);
        lbldays.setForeground(Color.WHITE);
        p2.add(lbldays);
        tfdays = new JTextField("1");
        tfdays.setBounds(250,150,150,25);
        p2.add(tfdays);

        JLabel lblperson = new JLabel("No. of Persons");
        lblperson.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblperson.setBounds(40,190,150,20);
        lblperson.setForeground(Color.WHITE);
        p2.add(lblperson);
        tfperson = new JTextField("1");
        tfperson.setBounds(250,190,150,25);
        p2.add(tfperson);

        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(40,230,150,25);
        lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblac.setForeground(Color.WHITE);
        p2.add(lblac);
        String[]choice={"AC","Non-AC"};
        cac= new JComboBox<>(choice);
        cac.setBounds(250,230,100,25);
        cac.setBackground(Color.WHITE);
        cac.setForeground(Color.BLACK);
        p2.add(cac);

        JLabel lblfood = new JLabel("Food");
        lblfood.setBounds(40,270,150,25);
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblfood.setForeground(Color.WHITE);
        p2.add(lblfood);
        yes=new JRadioButton("Yes");
        yes.setForeground(Color.WHITE);
        yes.setBackground(new Color(219 ,68 ,55));
        yes.setBounds(250,270,50,25);
        p2.add(yes);
        no=new JRadioButton("No");
        no.setForeground(Color.WHITE);
        no.setBackground(new Color(219 ,68 ,55));
        no.setBounds(330,270,50,25);
        p2.add(no);
        ButtonGroup group = new ButtonGroup();
        group.add(yes);
        group.add(no);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(40,310,150,25);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblid.setForeground(Color.WHITE);
        p2.add(lblid);
        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelid.setBounds(250,310,150,25);
        labelid.setForeground(Color.WHITE);
        p2.add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,350,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnumber.setForeground(Color.WHITE);
        p2.add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(250,350,150,25);
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelnumber.setForeground(Color.WHITE);
        p2.add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,390,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblphone.setForeground(Color.WHITE);
        p2.add(lblphone);
        labelphone = new JLabel();
        labelphone.setBounds(250,390,150,25);
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelphone.setForeground(Color.WHITE);
        p2.add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,430,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltotal.setForeground(Color.WHITE);
        p2.add(lbltotal);
        labeltotal = new JLabel();
        labeltotal.setBounds(250,430,150,25);
        labeltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        labeltotal.setForeground(Color.WHITE);
        p2.add(labeltotal);

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.WHITE);
        checkprice.setForeground(Color.BLACK);
        checkprice.setBounds(60,500,120,25);
        checkprice.addActionListener(this);
        p2.add(checkprice);

        book = new JButton("Book Hotel");
        book.setBackground(Color.WHITE);
        book.setForeground(Color.BLACK);
        book.setBounds(200,500,120,25);
        book.addActionListener(this);
        p2.add(book);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setBounds(340,500,120,25);
        back.addActionListener(this);
        p2.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,70,500,300);
        add(image);

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

        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    private static List<String> retriveFromDatabase() {
        List<String> data = new ArrayList<>();
        //retrieving the values from the database
        try {
            Conn c = new Conn();
            String query = "select * from hotels";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                String value = rs.getString("name");
                data.add(value); //adding the hotel names from the database to list to returned
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        new BookHotel("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            setVisible(false);
        }
        else if(e.getSource()==checkprice){
            try {
                Conn c = new Conn();
                String hotel = labelhotel.getSelectedItem().toString();
                String query = "select * from hotels where name = '"+hotel+"'";
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    int food = Integer.parseInt(rs.getString("fooding"));

                    int persons = Integer.parseInt(tfperson.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = cac.getSelectedItem().toString();
                    String foodselected="";
                    if(yes.isSelected()){
                        foodselected="Yes";
                    }else{
                        foodselected="No";
                    }
                    //condition checking coz we cant calculate price if anyone select 0 person for 0 days
                    if (persons*days>=1){
                        int total = 0;
                        total+= foodselected.equals("Yes")? food:0; //using the conditional operator instead of if else
                        total+= acselected.equals("AC")? ac:0;
                        total+=cost;
                        total=total*persons*days;
                        labeltotal.setText("Rs. "+total);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Please enter valid details for persons and days.");
                    }
                }
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
        }
        else if(e.getSource()==book){
            try{
                Conn c = new Conn();
                String hotel = labelhotel.getSelectedItem().toString();
                String persons = tfperson.getText();
                String foodselected="";
                if(yes.isSelected()){
                    foodselected="Yes";
                }else{
                    foodselected="No";
                }

                String query = "insert into bookhotel values ('"+username+"','"+hotel+"','"+tfdays.getText()+"','"+persons+"','"+cac.getSelectedItem()+"','"+foodselected+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labeltotal.getText()+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                setVisible(false);
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
    class CustomComboBoxRenderer extends DefaultListCellRenderer {
        private List<String> data;
        private Color foreground;
        private Color background;

        public CustomComboBoxRenderer(List<String> data, Color foreground, Color background) {
            this.data = data;
            this.foreground = foreground;
            this.background = background;
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (index >= 0 && index < data.size()) {
                String item = data.get(index);
                setText(item);
            }

            if (isSelected) {
                renderer.setBackground(list.getSelectionBackground());
                renderer.setForeground(list.getSelectionForeground());
            } else {
                renderer.setBackground(background);
                renderer.setForeground(foreground);
            }

            return renderer;
        }
    }
}
