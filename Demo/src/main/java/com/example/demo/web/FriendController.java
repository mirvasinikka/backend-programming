package com.example.demo.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Friend;

import jakarta.validation.Valid;

@Controller
public class FriendController {
	
	/**
	 * Initializing my best friends !! :) 
	 */
	List<Friend> friends = new ArrayList<>(Arrays.asList(
		    new Friend("Mikko Mallikas"),
		    new Friend("Malla Mallikas")
));

	@GetMapping("/index")
	public String showFriends(
			@RequestParam (name="name", required=false) String name,
			Model model) {
		model.addAttribute("friends", friends);
		model.addAttribute("friend", new Friend(name));
		
		return "friendList";
	}
	
	@PostMapping("/addFriend")
	public String addFriend(@Valid Friend friend, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "friendList";
		}
		friends.add(friend);
		model.addAttribute("friend", friend);
		return "redirect:/index";
	}
}
