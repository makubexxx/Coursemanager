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
    <script src="<%=request.getContextPath()%>/js/userinfo.js"></script>
</head>
<body>
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人资料</strong> / <small>Personal information</small></div>
    </div>

    <hr/>

    <div class="am-g">

      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
 
      </div>

      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <form class="am-form am-form-horizontal" action="/CourseManager/changeuserinfo" method="post">
        
             <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">学号/ StudenNo</label>
            <div class="am-u-sm-9">
              <input type="text" id="user-name" placeholder="学号/ StudenNo" value="${user.userid}"  readonly="readonly" >
            </div>
          </div>
        
        
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">姓名 / Name</label>
            <div class="am-u-sm-9">
              <input type="text" id="username" placeholder="姓名 / Name" value="${user.user_name}">
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label" id>电子邮件 / Email</label>
            <div class="am-u-sm-9">
              <input type="email" id="email" placeholder="输入你的电子邮件 / Email" value="${user.email}">
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-phone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
            <div class="am-u-sm-9">
              <input type="text" id="phone" placeholder="输入你的电话号码 / Telephone" value="${user.user_phone}">
            </div>
          </div>

          <div class="am-form-group">
            <div class="am-u-sm-9 am-u-sm-push-3">
              <button type="button" class="am-btn am-btn-primary" id="changebutton">保存修改</button>
            </div>
          </div>
        </form>
      </div>
    </div>

</body>
</html>