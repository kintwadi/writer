package com.writer.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import com.google.gson.JsonObject;
import com.writer.model.Comment;
import com.writer.model.Profile;
import com.writer.model.Topic;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

@org.springframework.stereotype.Service

public class Service {

	private RestTemplate restTemplate = null;
	private HttpHeaders headers = null;
	private String serverUrl ="https://192.168.178.53:8181";
	//private String serverUrl ="https://192.168.178.59:8181";
	private HttpEntity< String> httpEntity = null;
	private ResponseEntity<String> responseEntity = null;
	@Autowired
	private Profile profile;
	@Autowired
	private Topic topic;
	@Autowired
	private Comment comment;
	



	private JsonObject  getAsJsonObject(String str,String entity) {

		Gson gson = new Gson();
		JSONObject fromJson = gson.fromJson(str, JSONObject.class);
		JsonElement jsonTree = gson.toJsonTree(fromJson.get(entity));
		JsonObject asJsonObject = jsonTree.getAsJsonObject();
		return asJsonObject;
	}

	private JsonArray  asJsonArray(String str,String entity) {

		Gson gson = new Gson();
		JSONObject fromJson = gson.fromJson(str, JSONObject.class);
		JsonElement jsonTree = gson.toJsonTree(fromJson.get(entity));
		return jsonTree.getAsJsonArray();
	}
	private Profile createProfile(JsonObject jsonAuthor, JsonArray jsonTopics, JsonArray JsonComments) {

		Profile profile = new Profile();
		profile.setUserId(jsonAuthor.get("authorId").getAsLong());
		profile.setName(jsonAuthor.get("name").getAsString());
		profile.setEmail(jsonAuthor.get("email").getAsString());
		profile.setBiography(jsonAuthor.get("biography").getAsString());
		
		
		List<Topic> topics = new ArrayList<Topic>();
		List<Comment>comments = new ArrayList<Comment>();
		
	
		
		for(int i = 0 ; i < jsonTopics.size(); i++) {

			long topicId = jsonTopics.get(i).getAsJsonObject().get("topicId").getAsLong();
			String title = jsonTopics.get(i).getAsJsonObject().get("title").getAsString(); 
			String text = jsonTopics.get(i).getAsJsonObject().get("text").getAsString();
			int commentCount = jsonTopics.get(i).getAsJsonObject().get("commentCount").getAsInt();
			int likeCount = jsonTopics.get(i).getAsJsonObject().get("likeCount").getAsInt();
			int dislikeCount = jsonTopics.get(i).getAsJsonObject().get("dislikeCount").getAsInt();
			int ratingCount = jsonTopics.get(i).getAsJsonObject().get("ratingCount").getAsInt();
			int scoreCount = jsonTopics.get(i).getAsJsonObject().get("scoreCount").getAsInt();
			
			Topic topic = new Topic();
			topic.setTopicId(topicId);
			topic.setTitle(title);
			topic.setTopic(text);
			topic.setCommentCount(commentCount);
			topic.setRating(ratingCount);
			topic.setScore(scoreCount);
			topic.setLikeCount(likeCount);
			topic.setDislikeCount(dislikeCount);
			topics.add(topic);
		}
	
		for(int j = 0 ; j < JsonComments.size(); j++) {

			long feedbackId = JsonComments.get(j).getAsJsonObject().get("feedbackId").getAsLong();
			String text = JsonComments.get(j).getAsJsonObject().get("comment").getAsString();
			long commentedById = JsonComments.get(j).getAsJsonObject().get("commentedById").getAsLong();
			//String since = JsonComments.get(j).getAsJsonObject().get("since").getAsString();
			//JsonComments.get(j).getAsJsonObject().get("topic").getAsJsonObject();
			//System.out.println(feedbackId);
	       
			Comment comment = new Comment();
			
			comment.setId(feedbackId);
			comment.setCommentedById(commentedById);
			comment.setComment(text);
			//comment.setSince(since);
			comments.add(comment);
			
		}
		
		
		
		
		profile.setTopics(topics);
		profile.setComments(comments);
	
		return profile;
		
		

	}


	public Profile getProfile(@PathVariable long id){

		ArrayList<Object> aut = null;


		try {

			sslDisabled(); 

			restTemplate = new RestTemplate();

			headers = new HttpHeaders();
			//headers.set("APIKey","1458966666");
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			String url = serverUrl+"/getAuthor/1";
			httpEntity = new HttpEntity<String>(headers);

			responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
			//author = extractedAsArrayList(responseEntity);
			JsonObject jsonAuthor = getAsJsonObject(responseEntity.getBody(),"author");
			//topics.get(0).getAsJsonObject().get("topicId")
			JsonArray jsonTopics = asJsonArray(responseEntity.getBody(),"topics");
			JsonArray JsonComments = asJsonArray(responseEntity.getBody(),"comments");


			System.out.println("topics: "+jsonTopics);
			System.out.println("comments: "+JsonComments);


			profile = createProfile(jsonAuthor,jsonTopics,JsonComments);
			


		}catch (Exception e) {

			System.out.println(e.getLocalizedMessage()); 

		}


		return profile;

	}
	
	public void sslDisabled() throws NoSuchAlgorithmException, KeyManagementException, IOException {
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}
			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		}
		};

		// Install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};

		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

		URL url = new URL(serverUrl);
		URLConnection con = url.openConnection();
		Reader reader = new InputStreamReader(con.getInputStream());
		while (true) {
			int ch = reader.read();
			if (ch==-1) {
				break;
			}
			//System.out.print((char)ch);
		}

	}
	@SuppressWarnings("unchecked")
	private ArrayList<Object> extractedAsArrayList(ResponseEntity<String> response) {
		Gson gson = new Gson();
		return  gson.fromJson(response.getBody(), ArrayList.class);
	}
	private ArrayList<Object> asArrayList(JsonObject object) {
		Gson gson = new Gson();
		return  gson.fromJson(object, ArrayList.class);
	}


}
