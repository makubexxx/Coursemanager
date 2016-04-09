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
      <textarea class="" rows="5" id="doc-ta-1" name="content"></textarea>
    </div>
    
<div class="am-form-group am-form-file">
  <button type="button" class="am-btn am-btn-danger am-btn-sm">
    <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
  <input id="doc-form-file" type="file" name="file">
  <input  name="courseworkid" value="${Coursework.courseworkid}" type="hidden">
</div>
<div id="file-list"></div>
<script>
  $(function() {
    $('#doc-form-file').on('change', function() {
      var fileNames = '';
      $.each(this.files, function() {
        fileNames += '<span class="am-badge">' + this.name + '</span> ';
      });
      $('#file-list').html(fileNames);
    });
  });
</script>

    <p><button type="submit" class="am-btn am-btn-default">提交</button></p>
    </fieldset>
    </form>
    
      </div>
    </div>

</body>
</html>