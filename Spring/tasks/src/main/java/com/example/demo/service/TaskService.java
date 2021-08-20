package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Task;



public interface TaskService {

	List<Task> find();

	void Addtask(Task task);
	void findTask(Task task);
	public int getSequenceNumber(String sequenceName);





	



}
