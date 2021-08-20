package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/taskcontroller")
@CrossOrigin
public class TaskController {
	@Autowired TaskService taskservice;
	
	@GetMapping("/find")
	
	public List<Task> findAll(){
		
		return taskservice.find();
	}
	
	@PostMapping( "/add")
	
	public String AddTask( @RequestBody Task task)
	{
//		System.out.println(task.task);
		taskservice.Addtask(task);
		return "success";
	}
	
@PostMapping( "/findTask")
	
	public String findTask( @RequestBody Task task)
	{
//		System.out.println(task.task);
		taskservice.findTask(task);
		return "success";
	}
	
}
