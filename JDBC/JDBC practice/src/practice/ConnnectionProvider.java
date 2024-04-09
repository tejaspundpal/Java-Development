package practice;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnnectionProvider {
    private static Connection conn;
    public static Connection getConnection(){
       try {
           //connection is created here and used in another program in same package
           if (conn == null) {
               Class.forName("com.mysql.cj.jdbc.Driver");
               String url = "jdbc:mysql://localhost:3306/jdbc";
               String username = "root";
               String password = "1234";
               conn = DriverManager.getConnection(url,username,password);
           }
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return conn;
    }
}
