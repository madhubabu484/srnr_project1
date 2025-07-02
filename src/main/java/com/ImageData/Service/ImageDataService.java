package com.ImageData.Service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ImageData.Model.ImageData;
import com.ImageData.Repository.ImageDtaRepo;
import com.ImageData.Utility.ImageUtility;

@Service
public class ImageDataService {
	
	
	@Autowired
	private ImageDtaRepo imageRepo;
	
	
	public String uploadimage(MultipartFile file) throws IOException   // Step : 1 we have Upload the file to our Folder.
	{
		
		
	ImageData upload = imageRepo.save(ImageData.builder()
				                    .filename(file.getOriginalFilename())
				                    .type(file.getContentType())
				                    .imagedata(ImageUtility.compressImage(file.getBytes())).build());
		

	       if(upload!=null)
	       {
	    	   
	    	   return "Image Sucessfully Upload";
	       }
	       
	       else {
	    	   
	    	   
	    	    return null;
	
				
				
	
	       }
	       
	       //Step :2  we have to After the Uplaod image then we have to downlaod the Image
	       
	       
	}
	
    public byte[] findbyname(String filename)
    {
    	
    	
    	 Optional<ImageData> Optionaldownlaod =    imageRepo.findByfilename(filename); // This step is used to find the image using image Name.
    	 
    	 
    byte [] images =	 ImageUtility.decompressImage(Optionaldownlaod.get().getImagedata());
    
    return images;
    	 
    	 
    }


}

 