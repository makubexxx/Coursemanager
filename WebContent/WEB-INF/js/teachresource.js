$(document).ready(function(){
	
	  $("#submit").click(function(){
	
			 var title=$("#title").val();
			 var link=$("#link").val();
			 var description=$("#description").val();
			 var data = {
					 title:encodeURI(title),
					 link:encodeURI(link),
					 description:encodeURI(description)
		         };
		     var postdata =encodeURI(JSON.stringify(data)); 
	     $.ajax({ 
			    		type: "post", 
			    		url :"/CourseManager/addteachresource", 
			    		dataType:"json",
			    		data: "postdata=" + postdata, 
			    		success: function(json){
			    			if(json.statue==0)
			    			{
			    				alert("添加成功");
			    				window.location.href=window.location.href;
			    			}
			    			else{
			    				alert("添加失败");
			    				//刷新
			    			}
			    		} 	
			    });	
		 
	  });
});