package com.example.courses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.model.Courses;
import com.example.courses.repository.CourseRepository;


@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	CourseRepository repository;
	@GetMapping
	public String sayHi() {
		return "Hello springboot!!";
	}
	@GetMapping("/course")
	public List<Courses> getCourses(){
		List<Courses> courseList = repository.findAll();
		return courseList;
	}
	@GetMapping("/course/find/{id}")
	public Courses getCourseById(@PathVariable("id") int id){
		Optional<Courses> course = repository.findById(id);
		if(course.isPresent()) {
			return course.get();
		}
		else {
			return null;
		}
	}
}
