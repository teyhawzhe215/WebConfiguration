package com.tutorial.Controller.template;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController {

	
	
	@RequestMapping(value="/image/{url}" , method = RequestMethod.GET)
	@ResponseBody
	public String createImage(@PathVariable String url,HttpServletResponse response) {
		
		System.out.println("url="+url);
		
		//String rootPath = System.getProperty("catalina.home");
		//File dir = new File(rootPath + File.separator + "tmpFiles");
		String rootPath = System.getProperty("jetty.base");
		
		File dir = new File("images" + File.separator + "tmpFiles");
		
		FileInputStream fis = null;  
	    OutputStream os = null;  
		
	    try {
	    	 fis = new FileInputStream(dir.getAbsolutePath()+"/"+url);  
	    	 os = response.getOutputStream();
	    	 int count = 0;
	    	 
	    	 byte[] buffer = new byte[1024*8];
	    	 
	    	 while( (count = fis.read(buffer)) !=-1 ) {
	    		 os.write(buffer,0,count);
	    		 os.flush();
	    	 }
	    }catch(Exception ex) {
	    	System.out.println(ex);
	    }
	    try {
	    	
	    	fis.close();
	    	os.close();
	    	
	    }catch(Exception ex) {
	    	System.out.println(ex.toString());
	    }
	    
	    
		return "ok";
	}
	
	
}
