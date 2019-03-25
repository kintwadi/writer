package com.writer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.writer.model.Comment;
import com.writer.model.Profile;
import com.writer.model.Topic;
import com.writer.service.Service;

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
	
	@Autowired
	private Service service;
	static Map<Long,Profile> map = null;
	
	
	@GetMapping("/")
	public String init(Model model) {
		
		return "home";
	}
	
	@GetMapping("/profile")
	
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
		//model.addAttribute("topics", getTopics());
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
		
		Profile profile = service.getProfile(1);
		//System.out.println("profile aqui : "+profile);
		model.addAttribute("profile", profile);
		map = new HashedMap();
		profile.getTopics().forEach( topic ->{
			
			Profile p = new Profile(topic, null);
			map.put(topic.getTopicId(),p);
		});
	
		model.addAttribute("topic_map", map);
		
		//System.out.println(author.toString());
		
		return "profile";
	}
	
	@PostMapping("updateTopic/{content}")
	@ResponseBody
	public String  editTopic(@PathVariable String content,Model model) {
		
		System.out.println("content: "+content);
		
		return content;
	}
	
	@GetMapping("/topicid/{key}")
	@ResponseBody
	public Object getTopicMap(@PathVariable long key,Model model) {
		
		return map.get(key);
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
