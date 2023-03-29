package bank_Managment;
import java.sql.*;
public class Connec {
    Connection con;Statement s;

    Connec() throws ClassNotFoundException {



       try{
        String userName = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost/bank_Managment";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url,userName,pass);
        s=con.createStatement() ;
        System.out.println("DataBase Connected");
    }catch (Exception e){

       }

   }


}
