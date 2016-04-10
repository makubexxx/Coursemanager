$(document).ready(function(){
	
	  $("#submit").click(function(){
	
			 var score=$("#score").val();
			 var userid=getQueryString("userid");
			  $.getJSON("/CourseManager/updatescore?userid="+userid+"&score="+score, function(data){
			         if(data.statue==0)
	            	   {
	            	   alert("打分成功");
	            	   window.location.href=window.location.href;
	            	   }
	               else{
	            	   alert("打分失败");
	               }
			  
			  });
		 
	  });
});


function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
	} 