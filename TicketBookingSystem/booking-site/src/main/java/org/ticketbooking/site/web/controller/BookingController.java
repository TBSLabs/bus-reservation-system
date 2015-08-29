package org.ticketbooking.site.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	@ResponseBody public String bookingDetails(@PathVariable String name){
		return "Hi "+name;
	}
	
}
