package com.fileupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fileupload.entities.FileUpload;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {
	
}