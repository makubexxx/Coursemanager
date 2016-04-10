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
  <script src="<%=request.getContextPath()%>/assets/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/assets/js/amazeui.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery-2.1.4.js"></script>
  <script src="<%=request.getContextPath()%>/js/score.js"></script>
</head>
<body>
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">作业详情 打分</strong> / <small>Course information</small></div>
    </div>

    <hr/>

          <div class="am-g">
        <div class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                </th><th class="table-id">学号</th><th class="table-title">姓名</th><th class="table-title">得分</th>
              </thead>
              <tbody>
              <tr>
 
                <td>${workuploaduser.user.userid}</td>
                <td>${workuploaduser.user.user_name}</td>
                <td>${workuploaduser.score}</td>
                   </tr>

              </tbody>
            </table>

            <hr />
          </form>
        </div>

      </div>
    <div class="am-g">

      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">

      </div>

      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <form class="am-form am-form-horizontal" action="/CourseManager/coursework/upload" method="post" enctype="multipart/form-data">
        
             <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">作业题目</label>
            <div class="am-u-sm-9">
              <input type="text" id="user-name"  readonly="readonly"  value="${Coursework.courseworktitle}">
            </div>
            
          </div>
        
        


    <div class="am-form-group">
            <label for="user-intro" class="am-u-sm-3 am-form-label">作业说明</label>
            <div class="am-u-sm-9">
              <textarea class="" rows="5" id="user-intro"  readonly="readonly"  >${Coursework.coursework_content}</textarea>
            </div>
          </div>
          

  <fieldset>
    <legend>上交作业内容</legend>
        <div class="am-form-group">
      <label for="doc-ta-1"></label>
      <input name="coursediscussid" value="${coursediscuss.coursediscussid}" type="hidden">
      <textarea class="" rows="5" id="doc-ta-1" name="content" readonly="readonly" >${courseworkupload.content}</textarea>
    </div>
    
    <a class="am-btn am-btn-primary" href="${courseworkupload.attachment}">
  <i class="am-icon-cloud-download"></i>
  附件下载
</a>

    </fieldset>
    </form>
    
      </div>
    </div>
    <form class="am-form">
  <fieldset>
    <legend>添加教学资源</legend>

    <div class="am-form-group">
      <label for="doc-ipt-email-1">打分</label>
      <input type="text" class=""  id="score" placeholder="请输入分数">


    <p><input type="button" class="am-btn am-btn-default" id="submit" value="打分"/></p>
  </fieldset>
</form>
</body>
</html>