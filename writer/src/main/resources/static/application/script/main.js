

const toggleTopic = (e) =>{
	
	
	const n = e.currentTarget.className.localeCompare("topic");

	if( n == 0){
		
		const toggle_title = document.querySelector("#toggle_title");
		const toggle_topic_text = document.querySelector("#toggle_title");
		const title = document.getElementById(e.currentTarget.id);
		
	
		toggle_title.textContent = title.textContent;
		
		 $.get("topicid/"+e.currentTarget.id, function(data, status){
			 
			 
			    console.log("Data: " + JSON.stringify(data)); 
			    data = data["topic"];
			    document.querySelector("#toggle_topic_text").innerHTML = data["topic"];
			    document.querySelector("#toggle_topic_comment_count").innerHTML= data["commentCount"];
			    document.querySelector("#toggle_topic_like_count").innerHTML= data["likeCount"];
			    document.querySelector("#toggle_topic_dislike_count").innerHTML= data["dislikeCount"];
			    document.querySelector("#toggle_topic_score_count").innerHTML= data["score"];
			    
			    var rating = document.querySelector("#toggle_topic_rating_count");
			    
			    var rating_star = document.querySelector("#toggle_rating_star");
			    var ratingCount = data["rating"];
			   
			    rating_star. innerHTML ="";
			    if(ratingCount == 1){
			    	
			    	rating_star.setAttribute('class',"fa fa-star");
			    }
			    if(ratingCount == 2){
			    	
			    	var i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    	 i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    }
			    if(ratingCount == 3){
			    	 
			    	 var i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    	 i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    	 i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    }
			    if(ratingCount == 4){
			    	
			    	var i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    	 i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    	 i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    	 i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    }
			    if(ratingCount == 5){
			    	
			    	var i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    	 i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    	 i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    	 i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    	 i = document.createElement("span");
			    	 i.setAttribute('class',"fa fa-star");
			    	 rating_star.appendChild(i);
			    }
			    
			   
		  });
		
		
		$(".topic_toggle").slideDown();
		
		
	}else{
		alert("delete topic: "+e.currentTarget.id);
	}

}
let topics = document.querySelectorAll(".topic");
for(let i = 0 ; i< topics.length; i++){
	
	topics[i].addEventListener('click',toggleTopic);
}
var topic_toggle_close = document.querySelector("#topic_toggle_close");
var topicToggleClose = (e)=>{
	
	if(e.currentTarget.id.localeCompare("topic_comment_toggle_close") == 0){
		
		$("#toggle_feedback_content").slideUp();
		
	}else if(e.currentTarget.id.localeCompare("topic_toggle_close") == 0){
		
		$(".topic_toggle").slideUp();
	}
}
topic_toggle_close.addEventListener('click',topicToggleClose);
const topic_container_link = document.querySelector(".topic_container_link");
const topic_comment_toggle_close = document.querySelector("#topic_comment_toggle_close");
topic_comment_toggle_close.addEventListener('click',topicToggleClose);

const toggleTopicContainer = ()=>{
	
	$(".topic_container").slideToggle()();
}
topic_container_link.addEventListener('click',toggleTopicContainer)

const feedbackToggle = (e)=>{
	
	$("#toggle_feedback_content").slideDown();
	
}
const feedback_toggler =  document.querySelector("#feedback_toggler");
feedback_toggler.addEventListener('click',feedbackToggle);


const replayToggle = (e) =>{
	$("#reply_content").slideToggle();
}
const replay_link = document.querySelector("#reply_link");
replay_link.addEventListener('click',replayToggle);

document.querySelector('#reply_content').addEventListener('keypress', function (e) {
    var key = e.which || e.keyCode;
    if (key === 13) { // 13 is enter
    	let instant_reply = document.querySelector("#instant_reply");
    	let replay_content = document.querySelector("#reply_content");
    	instant_reply.innerHTML = replay_content.value;
    	
        $("#instant_reply").show();
        
    }
});


const toggleTopicEdit = (e)=>{
	
	
	document.querySelector("#toggle_topic_text").removeAttribute("readonly");
	document.querySelector("#toggle_topic_text").disabled = false;
	
	
}


function postData (url,param){
	$.post(url,{param},
	function(data, status){
		alert("Data: " + data + "\nStatus: " + status);
	});
}

const toggleTopicSave = (e)=>{
	
	var topic_text = document.querySelector("#toggle_topic_text");
	topic_text.disabled = true;
	let url = "updateTopic/"+topic_text.textContent;
	postData (url,topic_text.textContent);
	
}

const toggle_topic_save = document.querySelector("#toggle_topic_save");
toggle_topic_save.addEventListener('click',toggleTopicSave);
const toggle_topic_edit = document.querySelector("#toggle_topic_edit");
toggle_topic_edit.addEventListener('click',toggleTopicEdit);




