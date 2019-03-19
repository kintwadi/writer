

const toggleTopic = (e) =>{
	
	
	var n = e.currentTarget.className.localeCompare("topic");
	if( n == 0){
		
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




