package com.example.demo.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DbSequence;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
@Service
public class TaskServiceImpl implements TaskService {

@Autowired TaskRepository taskRepository;
	public List<Task> find() {
		System.out.println(taskRepository.findAll());
		return taskRepository.findAll();
	}
	
	 @Autowired
	    private MongoOperations mongoOperations;


	    public int getSequenceNumber(String sequenceName) {
	       
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	       
	        Update update = new Update().inc("seqNo", 1);
	        
	        DbSequence counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequence.class);
	        
	        return !Objects.isNull(counter) ? counter.getSeqNo() : 1;
	    }

	@Override
	public void Addtask(Task task) {
		task.setId(getSequenceNumber("user_sequence"));
		taskRepository.save(task);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void findTask(Task tasks){
	    
		 System.out.println(tasks.getId());
		@SuppressWarnings("rawtypes")
		List task = taskRepository.findAll();
		for (int i = 0; i < task.size();i++) {		    
		 Task t = (Task) task.get(i);
		 
		 System.out.println("");
		 
		 
		 if (t.getId().compareTo(tasks.getId())== 0){
			 System.out.println(t.getId());
			 
			 if (t.getStatus() == true) {
				 t.setStatus(false);
			 }else {
				 t.setStatus(true);
			 }
			 
			 taskRepository.save(t);

		 }
		 
		}

			
			
		
		
		
		
//		if (task.getId() == id) {
//			task.setStatus(true);
//		}
//		taskRepository.save(task);
	}
	
	

}
