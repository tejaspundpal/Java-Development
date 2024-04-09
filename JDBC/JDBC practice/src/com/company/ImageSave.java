package com.company;
import java.sql.*;
import java.io.*;
import java.util.*;

public class ImageSave {
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

            String str ="insert into images(pic) values(?)";
            PreparedStatement pstmt = conn.prepareStatement(str);
            // Read image file
            File imageFile = new File("C:\\Users\\Tejas Pundpal\\Documents\\Java\\JDBC\\src\\com\\company\\bike.jpeg");
            FileInputStream fis = new FileInputStream(imageFile);

            // Set binary stream as parameter
            pstmt.setBinaryStream(1, fis, (int) imageFile.length());
            pstmt.executeUpdate();

            System.out.println("Image successfully inserted...");
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
