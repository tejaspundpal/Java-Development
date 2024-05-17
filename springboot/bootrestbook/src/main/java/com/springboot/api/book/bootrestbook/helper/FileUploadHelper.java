package com.springboot.api.book.bootrestbook.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    // public final String upload_dir = "C:\\Users\\Tejas Pundpal\\Documents\\Java\\Java Development\\springboot\\bootrestbook\\src\\main\\resources\\static\\images";
    public final String upload_dir = new ClassPathResource("static/images/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException{

    }

    public boolean fileUpload(MultipartFile f){
        boolean temp = false;
        try {

            // //using stream api
            // InputStream is = f.getInputStream();
            // byte data[] = new byte[is.available()];
            // is.read(data);

            // FileOutputStream fos = new FileOutputStream(upload_dir+"\\"+f.getOriginalFilename());
            // fos.write(data);
            // fos.flush();
            // fos.close();

            //easy method
            Files.copy(f.getInputStream(),Paths.get(upload_dir+File.separator+f.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);

            temp = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
}
