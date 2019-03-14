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
	@Value("${str.topic.feedback.label}")
	private String feedback;
	@Value("${str.topic.rating.label}")
	private String rating;
	@Value("${str.topic.score.label}")
	private String score;
	@Value("${str.topic.title.input}")
	private String topicTitle;
	@Value("${str.topic.share}")
	private String topicShare;
	@GetMapping("/writer")
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
		model.addAttribute("topic_score", score);
		model.addAttribute("topic_share",topicShare);
		model.addAttribute("topics", getTopics());
		model.addAttribute("topic_title", topicTitle);
		return "profile";
	}
	private List<Topic>getTopics(){
		
		List<Topic> topics = new ArrayList<Topic>();
		
		topics.add(new Topic("Drinker", 10,2,12));
		topics.add(new Topic("Drimer", 20,4,10));
		topics.add(new Topic("Mad day", 15,3,15));
		topics.add(new Topic("Vidas", 14,2,30));
		topics.add(new Topic("Hidden", 50,5,100));
		return topics;
		
	}
	

}
