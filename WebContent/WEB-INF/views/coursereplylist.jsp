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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">讨论主题</strong> </div>
    </div>

    <div class="am-g">
      <div class="am-u-sm-12">
      
      
      
              <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
   <th class="table-title">讨论主题</th><th class="table-title">发表人</th><th class="table-type">正文</th><th class="table-date am-hide-sm-only">发布日期</th>
              </tr>
          </thead>
          <tbody>


        <tr>
              <td>${ coursediscuss.coursediscusstitile}</td> 
              <td>${coursediscuss.bycreate}</td>
              <td class="am-hide-sm-only">${coursediscuss.coursediscusscontent}</td>
              <td class="am-hide-sm-only">${coursediscuss.pushtime}</td>
            </tr>

          </tbody>
        </table>
        
        
         <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">评论</strong> </div>
    </div>
        
        <c:forEach items="${coursereplylist}" var="coursereply" varStatus="status"  >


              <article class="am-comment"> <!-- 评论容器 -->

  <div class="am-comment-main"> <!-- 评论内容容器 -->
    <header class="am-comment-hd">
      <!--<h3 class="am-comment-title">评论标题</h3>-->
      <div class="am-comment-meta"> <!-- 评论元数据 -->
        <a href="#link-to-user" class="am-comment-author">${coursereply.replyuser}</a> <!-- 评论者 -->
        评论于 <time datetime="">${coursereply.reply_date}</time>
      </div>
    </header>

    <div class="am-comment-bd">${coursereply.reply_content}</div> <!-- 评论内容 -->
  </div>
</article>
<br>
     </c:forEach>
        
        

        </form>

      </div>
      
      

    </div>
    
    <form class="am-form" action="/CourseManager/addcoursereplydetail" method="get">
  <fieldset>
    <legend>添加评论</legend>
        <div class="am-form-group">
      <label for="doc-ta-1"></label>
      <input name="coursediscussid" value="${coursediscuss.coursediscussid}" type="hidden">
      <textarea class="" rows="5" id="doc-ta-1" name="content"></textarea>
    </div>

    <p><button type="submit" class="am-btn am-btn-default">提交</button></p>
    </fieldset>
    </form>
    
    
    
    
</body>
</html>