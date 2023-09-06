package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController {
	
	@RequestMapping("/main")
	@ResponseBody
	public String showMainPage() {
		return "Tämä on pääsivu :) jee";
	}
	
	@RequestMapping("/moi")
	@ResponseBody
	public String sayHello(@RequestParam (name="nimesi") String nimi) {
		return ("Hei vaan sinullekkin " + nimi + " :))");
	}
	
	@RequestMapping("/moi2")
	@ResponseBody
	public String sayHello2(@RequestParam (name="nimesi", required=false, defaultValue="ystävä") String nimi) {
		return ("Hei vaan sinullekkin " + nimi + " :))");
	}
	
	@RequestMapping("/moi3")
	@ResponseBody
	public String sayHello3(@RequestParam (name="nimesi", required=false, defaultValue="ystävä") String nimi, 
			@RequestParam (name="ika") int age) {
		return ("Hei vaan sinullekkin " + nimi + " " + age + " vuotta" + " :))");
	}
	
	/**
	 * 
	 * Tästä alkaa viikkotehtävät chapter 1
	 */
	
	@RequestMapping("/inde1x")
	@ResponseBody
	public String showIndex() {
		return "This is the main page";
	}
	
	@RequestMapping("/contact")
	@ResponseBody
	public String showContact() {
		return "This is the contact page";
	}
	
	
	@RequestMapping("/hello2")
	@ResponseBody
	public String hello(@RequestParam (name="location") String location, 
			@RequestParam (name="name") String name) {
		return ("Welcome to the " + location + " " + name + "!");
		
	}

}
