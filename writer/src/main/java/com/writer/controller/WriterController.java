package com.writer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.writer.model.Topic;

@Controller
public class WriterController {

	@Value("${str.welcome}")
	private String welcome;
	@Value("${str.title}")
	private String title;
	@Value("${str.slogan}")
	private String slogan;
	@Value("${str.author.biography.label}")
	private String labelBiography;
	
	@Value("${str.author.biography.text}")
	private String biography;
	
	@Value("${str.author.name}")
	private String author;
	
	@Value("${str.topic.label}")
	private String topic;
	@Value("${str.topic.label2}")
	private String topicLabel;
	@Value("${str.topic.feedback.label}")
	private String feedback;
	@Value("${str.topic.rating.label}")
	private String rating;
	@Value("${str.topic.score.label}")
	private String scoreLabel;
	@Value("${str.topic.title.input}")
	private String topicTitle;
	@Value("${str.topic.label}")
	private String topicShare;
	@Value("${str.topic.action.label}")
	private String topicAction;
	@Value("${str.topic.feedback.value}")
	private String feedbackValue;
	@Value("${str.topic.score.value}")
	private String scoreValue;
	
	@Value("${str.topic.like}")
	private String topicLike;
	@Value("${str.topic.dislike}")
	private String topicDislike;
	@Value("${str.topic.write}")
	private String writeIdea;
	@Value("${str.topic.commenter}")
	private String commenterName;
	@Value("${str.topic.commenter.text}")
	private String commenterText;
	
	@Value("${str.topic.comment.period}")
	private String commentPeriod;
	
	
	
	@GetMapping("/")
	
	public String profile(Model model) {
		
		model.addAttribute("welcome", welcome);
		model.addAttribute("title", title);
		model.addAttribute("slogan", slogan);
		model.addAttribute("label_biography", labelBiography);
		model.addAttribute("biography", biography);
		model.addAttribute("author_name", author);
		model.addAttribute("topic_topic", topic);
		model.addAttribute("topic_feedback", feedback);
		model.addAttribute("topic_rating", rating);
		model.addAttribute("topic_score", scoreLabel);
		model.addAttribute("topic_share",topicShare);
		model.addAttribute("topics", getTopics());
		model.addAttribute("topic_title", topicTitle);
		model.addAttribute("topic_action", topicAction);
		model.addAttribute("feedback_value", feedbackValue);
		model.addAttribute("score_value", scoreValue);
		model.addAttribute("topic_like", topicLike);
		model.addAttribute("topic_dislike", topicDislike);
		model.addAttribute("write_idea", writeIdea);
		model.addAttribute("topic_label2", topicLabel);
		model.addAttribute("commenter_name", commenterName);
		model.addAttribute("commenter_text", commenterText);
		model.addAttribute("comment_period", commentPeriod);
		return "profile";
	}
	private List<Topic>getTopics(){
		
		List<Topic> topics = new ArrayList<Topic>();
		for(int i = 1; i< 100; i++){
			
			topics.add(new Topic("Drinker", 10,2,12,1));
			topics.add(new Topic("Drimer", 20,4,10,2));
			topics.add(new Topic("Mad day", 15,3,15,3));
			topics.add(new Topic("Vidas", 14,2,30,4));
			topics.add(new Topic("Hidden", 50,5,100,5));
		}
		
		
		return topics;
		
	}
	

}
