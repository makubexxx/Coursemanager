$(document).ready(function(){
	
	  $("#submit").click(function(){	
			 var title=$("#title").val();
			 var content=$("#content").val();
			 var startdate=$("#startdate").val();
			 var enddate=$("#enddate").val();
			 
			    var date1 = new Date(Date.parse(startdate));  
	            var date2 = new Date(Date.parse(enddate));  
	            if (date1.getTime() > date2.getTime()) {  
	                alert("结束时间不得小于开始时间。");  
	                return false;  
	            }  
			 console.log("title:"+title);
			 console.log("content:"+content);
			 console.log("startdate:"+startdate);
			 console.log("enddate:"+enddate);
			 var data = {
					 title:encodeURI(title),
					 content:encodeURI(content),
					 startdate:encodeURI(startdate),
					 enddate:encodeURI(enddate)
		         };
		     var postdata =encodeURI(JSON.stringify(data)); 
	     $.ajax({ 
			    		type: "post", 
			    		url :"/CourseManager/addcoursework", 
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

function deletecoursework()
{
		 var deletebutton=$(".am-btn am-btn-danger")attr("courseworkid");
		 alert(deletebutton);
	  
}