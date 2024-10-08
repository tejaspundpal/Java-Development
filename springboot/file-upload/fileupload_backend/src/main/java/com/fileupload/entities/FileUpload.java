package com.fileupload.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="FILE")
public class FileUpload {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherName;
    private String subject;
    private String description;
    private String fileName;
    private LocalDate uploadDate;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] fileData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LocalDate getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public FileUpload(Long id, String teacherName, String subject, String description, String fileName,
			LocalDate uploadDate, byte[] fileData) {
		super();
		this.id = id;
		this.teacherName = teacherName;
		this.subject = subject;
		this.description = description;
		this.fileName = fileName;
		this.uploadDate = uploadDate;
		this.fileData = fileData;
	}

	public FileUpload() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}