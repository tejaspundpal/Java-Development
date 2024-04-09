package practice;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
    try {
        //connection is used here
        Connection c = ConnnectionProvider.getConnection();
        String str = "insert into large_images(pic) values(?)";

        PreparedStatement p = c.prepareStatement(str);
        // one way to upload image (directly giving path of image to FileInputStram)
        //FileInputStream fis = new FileInputStream("C:\\Users\\Tejas Pundpal\\Documents\\Java\\JDBC\\src\\practice\\flowchart.jpg");

        //following code will open panel to upload image from system
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        File file = jfc.getSelectedFile();
        FileInputStream fis = new FileInputStream(file);

        p.setBinaryStream(1,fis,fis.available());
        p.executeUpdate();
        //System.out.println("Image successfully inserted...");

        JOptionPane.showMessageDialog(null,"Image successfully inserted...");

        c.close();
    }
    catch (Exception e){
        e.printStackTrace();
    }
    }
}
