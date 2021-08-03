package com.api.book.bootrestbook.helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	//public final String UPLOAD_DIR = "C:\\Users\\BKP\\git\\Spring-Boot-Rest-Api-Project\\SpringBootRESTApiProject\\src\\main\\resources\\static\\image";

	public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException {
		
	}
	
	public boolean uploadFile(MultipartFile f) {
		boolean b = false;

		try {

			InputStream is = f.getInputStream();
			byte[] data = new byte[is.available()];
			is.read(data);

			// write
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+f.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();

			// Alternativaly write method
			Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR + "\\" + f.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			b = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return b;
	}

}
