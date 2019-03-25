package com.writer.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Comment {
	
	private long id;
	private long topicId;
	private String comment;
	private long commentedById;
	private String since;
	private List<Topic>commentedTopics;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTopicId() {
		return topicId;
	}
	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public long getCommentedById() {
		return commentedById;
	}
	public void setCommentedById(long commentedById) {
		this.commentedById = commentedById;
	}
	public String getSince() {
		return since;
	}
	public void setSince(String since) {
		this.since = since;
	}
	
	public List<Topic> getCommentedTopics() {
		return commentedTopics;
	}
	public void setCommentedTopics(List<Topic> commentedTopics) {
		this.commentedTopics = commentedTopics;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", topicId=" + topicId + ", comment=" + comment + ", commentedById="
				+ commentedById + ", since=" + since + ", commentedTopics=" + commentedTopics + "]";
	}
	
	
	
	
	

}
