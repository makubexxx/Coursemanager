<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title> 在线课程管理系统</title>
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/admin.css">
  <base target="_blank">
</head>
<body>

 <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">课程作业</strong> </div>
    </div>

    <div class="am-g">
      <div class="am-u-sm-12">
        <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
   <th class="table-title">作业题目</th><th class="table-title">生效日期</th><th class="table-type">截止日期</th><th class="table-type">提交状态</th>
              </tr>
          </thead>
          <tbody>
          
<c:forEach items="${courseworklist}" var="coursework" varStatus="status"  >

        <tr>
              <td><a href="/CourseManager/courseworkdetail?courseworkid=${coursework.courseworkid}">${coursework.courseworktitle}</a></td>
              <td class="am-hide-sm-only">${coursework.start_date}</td>
              <td class="am-hide-sm-only">${coursework.end_date}</td>
              <td>${coursework.statuedescrpition} </td>
            </tr>  
     </c:forEach>


          </tbody>
        </table>
        </form>
        
        
    
      </div>

    </div>
</body>
</html>