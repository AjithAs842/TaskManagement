package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Task")
public class DbSequence {
	
	
@Id
	private String id;
	private int seqNo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		System.out.println(id);
		this.id = id;
	}
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	@Override
	public String toString() {
		return "DbSequence [id=" + id + ", seqNo=" + seqNo + "]";
	}
	
	
}
