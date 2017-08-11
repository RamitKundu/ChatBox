package com.niit.ChatBoxBackEnd.Util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	private static String path=System.getProperty("catalina.home");
	
	private static String imageFolder="Collaboration";
	
	
	
	
	
	public static void upload(MultipartFile file,String fileName){
		
		if(!file.isEmpty()){
			try{
			byte[] bytes=file.getBytes();
			
			File dir=new File(path+File.separator+imageFolder);
			if(!dir.exists())
				
				dir.mkdirs();
				
				
				File serverFile=new File(dir.getAbsolutePath()+File.separator+fileName+".jpg");
				
				
					BufferedOutputStream stream= new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
				
			} catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}

}
