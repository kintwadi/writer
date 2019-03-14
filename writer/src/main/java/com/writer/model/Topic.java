package com.writer.model;

import org.springframework.stereotype.Component;

@Component
public class Topic {
	
	private String topic;
	private int feedback;
	private int rating;
	private int score;
	
	
	public Topic(String topic, int feedback, int rating, int score) {
		super();
		this.topic = topic;
		this.feedback = feedback;
		this.rating = rating;
		this.score = score;
	}
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getFeedback() {
		return feedback;
	}
	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	

}
