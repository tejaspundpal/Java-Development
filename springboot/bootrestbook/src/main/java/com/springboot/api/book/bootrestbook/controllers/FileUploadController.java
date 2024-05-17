package com.springboot.api.book.bootrestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.api.book.bootrestbook.helper.FileUploadHelper;


@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("letter") MultipartFile file){
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());

        try {
            
        if(file.isEmpty())
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");

        if(!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/jpg"))
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG and jpg files are supported");

        boolean b = fileUploadHelper.fileUpload(file);

        if(b){
        // return ResponseEntity.ok("File uploaded successfully !");
        return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong !");
    }
    
}
