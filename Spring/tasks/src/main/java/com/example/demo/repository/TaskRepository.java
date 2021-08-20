package com.example.demo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Task;


	public interface TaskRepository extends MongoRepository<Task, Integer> {

	}

