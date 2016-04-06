$(document).ready(function(){
	
	  $("#changebutton").click(function(){
		  var name=$("#username").val();
		  var email=$("#email").val();
		  var phone=$("#phone").val();
		  if(name!=null&&email!=null&&phone!=null){
			  $.getJSON("/CourseManager/changeuserinfo?name="+name+"&email="+email+"&telephone="+phone, function(data){
			         if(data.statue==0)
	            	   {
	            	   alert("修改个人信息成功");
	            	   window.location.href=window.location.href;
	            	   }
	               else{
	            	   alert("修改个人信息失败");
	               }
			  
			  });
		  }
	
		  else{
			  alert("请输入合法参数");
		  }
		 
	  });
});