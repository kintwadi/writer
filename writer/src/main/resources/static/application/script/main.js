

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
	
	$(".topic_toggle").slideUp();
}
topic_toggle_close.addEventListener('click',topicToggleClose);


