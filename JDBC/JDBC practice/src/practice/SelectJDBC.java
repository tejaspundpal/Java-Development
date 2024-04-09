package practice;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
public class SelectJDBC {
    public static void main(String[] args) {
        try {
            Connection conn = ConnnectionProvider.getConnection();
            String str = "Select * from student";

            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(str);
            while (set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                int prn = set.getInt(3);

                System.out.println(id+"  "+name+"  "+prn);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
