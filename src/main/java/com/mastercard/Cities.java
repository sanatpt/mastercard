/*
 * Initialized HasMap with combination of origin and destination cities
 * 
 * 
 */

package com.mastercard;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;


@Component
public class Cities {
	
	@Autowired
	private static HashMap<String,String> origDest;
    
	@PostConstruct
	public static void init() {
		
		try {
		Resource resource = new ClassPathResource("Cities");
        InputStream inputStream = resource.getInputStream();
        
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            String data = new String(bdata);
            StringTokenizer st = new StringTokenizer(data,"\n");
            origDest=new HashMap<String,String>();
            while (st.hasMoreTokens()) {  
              String strLine = st.nextToken();
              String[] origDestArr = strLine.split(",");
              origDest.put(origDestArr[0].trim() + "-" + origDestArr[1].trim(), "YES");
              origDest.put(origDestArr[1].trim() + "-" + origDestArr[0].trim(), "YES");
            }  
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public static  HashMap getOrigDest() {
		return origDest;
		
	}

}
