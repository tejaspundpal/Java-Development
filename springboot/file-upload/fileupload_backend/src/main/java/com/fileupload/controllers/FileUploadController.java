package com.fileupload.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.entities.FileUpload;
import com.fileupload.services.FileUploadService;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "http://localhost:3000") // Adjust according to your frontend URL
public class FileUploadController {
    @Autowired
    private FileUploadService service;

    @PostMapping("/upload")
    public ResponseEntity<FileUpload> uploadFile(@RequestParam("file") MultipartFile file,
                                                 @RequestParam("teacherName") String teacherName,
                                                 @RequestParam("subject") String subject,
                                                 @RequestParam("description") String description) throws IOException {
        return new ResponseEntity<>(service.saveFile(file, teacherName, subject, description), HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<FileUpload> getAllFiles() {
        return service.getAllFiles();
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        FileUpload fileUpload = service.getAllFiles().stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileUpload.getFileName() + "\"")
                .body(fileUpload.getFileData());
    }
}
