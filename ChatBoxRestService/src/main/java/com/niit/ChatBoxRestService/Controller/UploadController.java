/*package com.niit.ChatBoxRestService.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.niit.ChatBoxBackEnd.Dao.UploadDao;
import com.niit.ChatBoxBackEnd.Dao.UserDao;
import com.niit.ChatBoxBackEnd.Model.Upload;
import com.niit.ChatBoxBackEnd.Model.User;


@RestController
public class UploadController {

@Autowired
UploadDao uploadDao;	
	
	@PostMapping("/uploadfile")
	public @ResponseBody String uploadFile(@RequestParam("file") MultipartFile file){
		Upload upload=new Upload();
		String fileName=null;
		
		if(!file.isEmpty()){
			try {
			 fileName=file.getOriginalFilename();

			System.out.println(fileName);
			upload.setImageURL(fileName);
			uploadDao.addUpload(upload);
				byte [] bytes=file.getBytes();
				BufferedOutputStream buffer= new BufferedOutputStream(new FileOutputStream(new File("D:/Collaboration/" +fileName)));
			
				buffer.write(bytes);
				buffer.close();
				 return "You have successfully uploaded " + fileName;
			} catch (IOException e) {
				
				e.printStackTrace();
				 return "You failed to upload " + fileName + ": " + e.getMessage();
			}
		
		}		
		return "Unable to upload. File is empty.";
		
	}
	
	
	@GetMapping("/getimagebyuploadId/{uploadId}")
	public ResponseEntity <List<Upload>> getImageByUploadId(@PathVariable("uploadId")int uploadId){
		List<Upload> upload=uploadDao.getById(uploadId);
		
		
		return new ResponseEntity<List<Upload>>(upload,HttpStatus.OK);	
			
		}
	
	
	
	

}
*/