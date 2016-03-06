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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">课程信息</strong> / <small>Course information</small></div>
    </div>

    <hr/>

    <div class="am-g">

      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">

      </div>

      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <form class="am-form am-form-horizontal">
        
             <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">课程编号</label>
            <div class="am-u-sm-9">
              <input type="text" id="user-name"  readonly="readonly"  value="${coursedetail.courseid}">
            </div>
            
          </div>
        
        
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">课程名称</label>
            <div class="am-u-sm-9">
              <input type="text" id="user-name" readonly="readonly"  value="${coursedetail.coursename}">
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">学分</label>
            <div class="am-u-sm-9">
              <input type="email" id="user-email" readonly="readonly" value="${coursedetail.coursecredit}">
            </div>
          </div>
              <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">学时</label>
            <div class="am-u-sm-9">
              <input type="email" id="user-email"  readonly="readonly" value="${coursedetail.studytimes}">
            </div>
          </div>
                 <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">教师信息</label>
            <div class="am-u-sm-9">
              <input type="email" id="user-email" readonly="readonly"  value="${coursedetail.teachername}">
            </div>
          </div>
                 <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">电子邮箱</label>
            <div class="am-u-sm-9">
              <input type="email" id="user-email" readonly="readonly"  value="${coursedetail.teacheremail}">
            </div>
          </div>

           <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">指定教材</label>
            <div class="am-u-sm-9">
              <input type="email" id="user-email"  readonly="readonly"  value="${coursedetail.targetbook}">
            </div>
          </div>
                     <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">参考书目</label>
            <div class="am-u-sm-9">
              <input type="email" id="user-email" readonly="readonly"   value="${coursedetail.bibliography}">
            </div>
          </div>
                       <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">教学方式</label>
            <div class="am-u-sm-9">
              <input type="email" id="user-email" readonly="readonly"   value="${coursedetail.teachmodel}">
            </div>
          </div>


    <div class="am-form-group">
            <label for="user-intro" class="am-u-sm-3 am-form-label">课程介绍</label>
            <div class="am-u-sm-9">
              <textarea class="" rows="5" id="user-intro"  readonly="readonly"  >${coursedetail.course_description}</textarea>
            </div>
          </div>
          
              <div class="am-form-group">
            <label for="user-intro" class="am-u-sm-3 am-form-label">教学日历</label>
            <div class="am-u-sm-9">
              <textarea class="" rows="5" id="user-intro"  readonly="readonly"  >${coursedetail.coursecanlendar}</textarea>
            </div>
          </div>
        </form>
      </div>
    </div>

</body>
</html>