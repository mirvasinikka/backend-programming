package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Student;

@Controller
public class StudentController {
	
	@RequestMapping("/hello-student")
	public String showStudents(Model model) {
		System.out.println("students");
		
		// kovakoodataan opiskelijat
		List<Student> student = new ArrayList<>();
		student.add(new Student("Mikko", "Mallikas"));
		student.add(new Student("Malla", "Mallikas"));
		
		model.addAttribute("students", student);
		return "studentList";
	}
	
	
	@GetMapping("/hello-age")
	public String helloAge(@RequestParam (name="name") String name, 
			@RequestParam (name="age") int age, Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return ("helloAge");
	}

}
