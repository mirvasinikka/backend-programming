package com.example.demo.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Friend {
	
	@NotNull(message = "Name is required")
	@Size(min=2, max=30, message = "Name length must be between {min} and {max} characters")
	private String name;
	
	public Friend() {
		super();
	}
	
	public Friend(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
