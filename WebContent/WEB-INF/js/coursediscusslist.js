$(document).ready(function(){
	
	  $("#submit").click(function(){
		  var title=$("#title").val();
		  var content=$("#content").val();
		  if(title!=null&&content!=null){
			  $.getJSON("/CourseManager/addcoursediscuss?title="+title+"&content="+content, function(data){
			         if(data.statue==0)
	            	   {
	            	   alert("添加公告成功");
	            	   window.location.href=window.location.href;
	            	   }
	               else{
	            	   alert("添加公告失败");
	               }
			  
			  });
		  }
	
		  else{
			  alert("请输入合法参数");
		  }
		 
	  });
});