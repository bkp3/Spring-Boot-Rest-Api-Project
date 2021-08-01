package com.api.book.bootrestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.bootrestbook.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("upload-file")
	public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file) {

//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getName());
//		System.out.println(file.getContentType());

		try {
			// validation
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must contain file");
			}

			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG file is allowed");
			}

			// file upload code
			
			boolean f = fileUploadHelper.uploadFile(file);
			if(f) {
				return ResponseEntity.ok("File is Successfully uploaded");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went wrong ! try again");
	}

}
