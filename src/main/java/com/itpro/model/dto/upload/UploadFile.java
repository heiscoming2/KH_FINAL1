package com.itpro.model.dto.upload;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadFile {
	private String name;
	private String desc;
	private MultipartFile mpfile;
}
