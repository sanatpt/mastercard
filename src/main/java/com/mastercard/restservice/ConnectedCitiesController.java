/* Spring boot Controller class with get url for requirement
 * 
 * 
 */

package com.mastercard.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.Cities;
@RestController
public class ConnectedCitiesController {
	@GetMapping("/connected")
	public String connected(@RequestParam(value = "origin") String origin,@RequestParam(value = "destination") String destination) {
		
		return isConnected(origin, destination);
	}
	/**
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 */
	private String isConnected(String origin,String destination)
	{
		if (origin==null || destination==null)
			return "no";
	
		String returnVal=(String)Cities.getOrigDest().get(origin + "-" + destination);
		if(returnVal==null)
			return "no";
		
		returnVal = returnVal.equals("YES")? "yes":"no";
		
		return returnVal;
	}

}
