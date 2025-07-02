
package com.ImageData.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ImageData.Model.ImageData;
import com.ImageData.Service.ImageDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/image")
public class ImageDtoController {


	@Autowired
	private ImageDataService dataservice;

	@PostMapping("/uploadImage")
	public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
	    String uploadedFilePath = dataservice.uploadimage(file);
	    
	    if (uploadedFilePath != null && !uploadedFilePath.isEmpty()) {
	        return ResponseEntity.ok(uploadedFilePath);
	    } else {
	        throw new RuntimeException("File upload failed. Please try again later.");
	    }
	}
}