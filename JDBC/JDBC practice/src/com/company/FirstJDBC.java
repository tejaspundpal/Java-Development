package com.company;
import javax.swing.plaf.nimbus.State;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.sql.*;

public class FirstJDBC {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "1234";
            Connection conn = DriverManager.getConnection(url,username,password);

            if(conn.isClosed()){
                System.out.println("Connection is closed");
            }else{
                System.out.println("Connection created...");
            }

//            String str = "create table student(id int(20) primary key auto_increment,name varchar(20),prn int(20))";
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(str);
//            System.out.println("Table created in database.");

            String str1 = "insert into student(name,prn) values (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(str1);

//          manually inputing info
//          pstmt.setString(1,"Tejas");
//          pstmt.setInt(2,112);

//          taking input from keyboard
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Name: ");
            String name = br.readLine();
            System.out.println("Enter PRN: ");
            int prn = br.read();

            pstmt.setString(1,name);
            pstmt.setInt(2,prn);
            pstmt.executeUpdate();

            System.out.println("Data inserted successfully !");

            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
