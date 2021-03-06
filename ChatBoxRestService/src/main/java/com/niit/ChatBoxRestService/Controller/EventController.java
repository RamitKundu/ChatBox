package com.niit.ChatBoxRestService.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.niit.ChatBoxBackEnd.Dao.EventDao;
import com.niit.ChatBoxBackEnd.Model.Event;



@RestController
public class EventController {
	
	@Autowired
	EventDao eventDao;
	
	
	
	
	@PostMapping("/addevent")
	public ResponseEntity<Event> registerUser(@RequestBody Event event) {
        event.setDateTime(new Date());
		eventDao.save(event);
		

		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	
	@GetMapping("/getallevent")
	public ResponseEntity<List<Event>> listofEvent() {
		List<Event> eventlist= eventDao.getAllEvent();
		
		return new ResponseEntity<List<Event>>(eventlist, HttpStatus.OK);

	}
    
	@PostMapping("/uploadfile")
	public @ResponseBody String uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("event")String evnt){
		
		String fileName=null;
		
		if(!file.isEmpty()){
			try {
			 fileName=file.getOriginalFilename();
             Gson gson=new Gson(); 
             
             Event event = gson.fromJson(evnt, Event.class);
             
			System.out.println(fileName);
			event.setImageURL(fileName);
			event.setDateTime(new Date());
			eventDao.save(event);
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
	
	
	
	
	
	
	
	
	
	
}
