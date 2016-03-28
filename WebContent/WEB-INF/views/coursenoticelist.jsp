<%@page import="com.coursemanager.model.User"%>
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
</head>
<body>

 <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">课程公告</strong> </div>
    </div>

    <div class="am-g">
      <div class="am-u-sm-12">
        <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
   <th class="table-id">序号</th><th class="table-title">公告提示</th><th class="table-type">发表者</th><th class="table-date am-hide-sm-only">发布日期</th>
              </tr>
          </thead>
          <tbody>
          
<c:forEach items="${coursenoticelist}" var="coursenotice" varStatus="status" >

        <tr>
              <td>${ status.index + 1}</td> 
              <td><a href="/CourseManager/coursenotice?noticeid=${coursenotice.noticeid}">${coursenotice.noticetitle}</a></td>
              <td class="am-hide-sm-only">${coursenotice.byuser}</td>
              <td class="am-hide-sm-only">${coursenotice.pushda_date}</td>
              <td>
              </td>
            </tr>
     </c:forEach>


          </tbody>
        </table>
        </form>
      </div>

    <% User user =(User) request.getAttribute("user");
    if(user.getUser_type()==10)
    {
    	out.print("<div class=\"am-cf am-padding\"><div class=\"am-fl am-cf\"><strong class=\"am-text-primary am-text-lg\">发布公告</strong></div></div>");
    	out.print("<form class=\"am-form am-form-horizontal\">");
    	out.print("<div class=\"am-form-group\"><div class=\"am-u-sm-9\"><textarea class=\"\" rows=\"5\" id=\"noticecontent\"></textarea></div></div>");
    	out.print("<div class=\"am-form-group\"><div class=\"am-u-sm-9 am-u-sm-push-3\"><button type=\"submit\" class=\"am-btn am-btn-primary\">提交</button></div></div>");
        out.print("</form>");
    }
    %>
    </div>
</body>
</html>