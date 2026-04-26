package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static{
        try{
            Class.forName("com.sql.cj.jdbc.Driver");
            System.out.println("Driver loaded Successfully");
        }
        catch(ClassNotFoundException e){
            System.out.println("Driver not found");
            e.printStackTrace();


        }
    }
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:sql//localhost:3306/ExpenseTracker";
        String user = "root";
        String password = "methodystic@9906";

        return DriverManager.getConnection(url,user,password);
    }
}


