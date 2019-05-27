package com.writer.model;

import org.springframework.stereotype.Component;

@Component
public class Topic {
	
	private long topicId;
	private String topic;
	private String title;
	private int commentCount;
	private int feedback;
	private int rating;
	private int score;
	private int likeCount;
	private int dislikeCount;
	private boolean share;
	
	
	public Topic(String topic, int feedback, int rating, int score,long topicId) {
		super();
		this.topicId = topicId;
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
	
	
	public boolean isShare() {
		return share;
	}
	public void setShare(boolean share) {
		this.share = share;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
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
	public long getTopicId() {
		return topicId;
	}
	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getDislikeCount() {
		return dislikeCount;
	}
	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}
	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topic=" + topic + ", title=" + title + ", commentCount=" + commentCount
				+ ", feedback=" + feedback + ", rating=" + rating + ", score=" + score + ", likeCount=" + likeCount
				+ ", dislikeCount=" + dislikeCount + "]";
	}
	
	
	
	
	

}