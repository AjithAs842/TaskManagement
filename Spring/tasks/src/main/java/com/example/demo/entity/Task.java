package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Task")
	public class Task {
	
	@Transient
	private static final String SEQUENCE_NAME="user_sequence";
	
		@Id
	private String id;
	
	public void setId(int id) {
		String newId = Integer.toString(id);
			this.id = newId;
		}

	public String  task;
	public void setTask(String task) {
		this.task = task;
	}

	private boolean status;

	public String getId() {
		return id;
	}
	
	public String getTask() {
		return task;	
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", task=" + task + ", status=" + status + "]";
	}
	
	
}
