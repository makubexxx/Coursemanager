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
   <script src="<%=request.getContextPath()%>/js/jquery-2.1.4.js"></script>
   <script src="<%=request.getContextPath()%>/js/coursework.js"></script>
  <base target="_blank">
</head>
<body>   
 <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
    
    
          <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">未打分列表</strong></div>
      </div>
      
            <div class="am-g">
        <div class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                </th><th class="table-id">学号</th><th class="table-title">姓名</th><th class="table-type">去打分</th>
              </thead>
              <tbody>
               <c:forEach items="${notreadcommituserlist}" var="user" >
              <tr>
 
                <td>${user.userid}</td>
                <td>${user.user_name}</td>
                <td class="am-hide-sm-only"><a href="/CourseManager/scorecourseworkdetail?userid=${user.userid}">打分</a></td>
                   </tr>

     </c:forEach>
              </tbody>
            </table>

            <hr />
          </form>
        </div>

      </div>
    
    
             <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">已打分列表</strong></div>
      </div>
      
            <div class="am-g">
        <div class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                </th><th class="table-id">学号</th><th class="table-title">姓名</th><th class="table-type">得分</th><th class="table-type">修改</th>
              </thead>
              <tbody>
               <c:forEach items="${hasreadcommituserlist}" var="Workuploaduser" >
              <tr>
 
                <td>${Workuploaduser.user.userid}</td>
                <td>${Workuploaduser.user.user_name}</td>
                <td class="am-hide-sm-only">${Workuploaduser.score}</td>
                   <td class="am-hide-sm-only"><a href="/CourseManager/scorecourseworkdetail?userid=${Workuploaduser.user.userid}">修改分数</a></td>
                   </tr>

     </c:forEach>
              </tbody>
            </table>

            <hr />
          </form>
        </div>

      </div>
      
          <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">未提交名单</strong></div>
      </div>
      
            <div class="am-g">
        <div class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                </th><th class="table-id">学号</th><th class="table-title">姓名</th><th class="table-type">状态</th>
              </thead>
              <tbody>
               <c:forEach items="${notcommituserlist}" var="user" >
              <tr>
 
                <td>${user.userid}</td>
                <td>${user.user_name}</td>
                <td class="am-hide-sm-only">未提交</td>
                   </tr>

     </c:forEach>
              </tbody>
            </table>

            <hr />
          </form>
        </div>

      </div>
    </div>


  </div>
</body>
</html>