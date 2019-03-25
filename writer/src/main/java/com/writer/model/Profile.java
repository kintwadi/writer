package com.writer.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Profile {

	private long userId;
	private String name;
	private String email;
	private String biography;
	private List<Topic>topics;
	private List<Comment>comments;
	private Topic topic;
	private Comment comment;
	
	

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public Profile(Topic topic, Comment comments) {
	
		this.topic = topic;
		this.comment = comment;
	}




	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getName() {
		return name;
	}



	public Topic getTopic() {
		return topic;
	}




	public void setTopic(Topic topic) {
		this.topic = topic;
	}




	public Comment getComment() {
		return comment;
	}




	public void setComment(Comment comment) {
		this.comment = comment;
	}




	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getBiography() {
		return biography;
	}



	public void setBiography(String biography) {
		this.biography = biography;
	}



	public List<Topic> getTopics() {
		return topics;
	}



	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	
	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	@Override
	public String toString() {
		return "Profile [userId=" + userId + ", name=" + name + ", email=" + email + ", biography=" + biography
				+ ", topics=" + topics + ", comments=" + comments + ", topic=" + topic + ", comment=" + comment + "]";
	}
	
	
}
