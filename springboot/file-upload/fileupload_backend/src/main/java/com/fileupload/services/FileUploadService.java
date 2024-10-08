package com.fileupload.services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.entities.FileUpload;
import com.fileupload.repository.FileUploadRepository;

@Service
public class FileUploadService {
    @Autowired
    private FileUploadRepository repository;

    public FileUpload saveFile(MultipartFile file, String teacherName, String subject, String description) throws IOException {
        FileUpload fileUpload = new FileUpload();
        fileUpload.setTeacherName(teacherName);
        fileUpload.setSubject(subject);
        fileUpload.setDescription(description);
        fileUpload.setFileName(file.getOriginalFilename());
        fileUpload.setFileData(file.getBytes());
        fileUpload.setUploadDate(LocalDate.now());

        return repository.save(fileUpload);
    }

    public List<FileUpload> getAllFiles() {
        return repository.findAll();
    }
}
