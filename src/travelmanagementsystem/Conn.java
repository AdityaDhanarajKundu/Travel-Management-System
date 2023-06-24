package travelmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//5 important steps of Java Database Connectivity
//1. Register the driver class
//2. Creating the connection string
public class Conn {

    Connection c;
    Statement s;
    Conn(){
        try{
            //registering the sql driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establishing the connection string
            c= DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","adityakundu");
            s=c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
