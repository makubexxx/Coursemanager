<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>在线课程管理系统</title>
  <meta name="description" content="这是一个 user 页面">
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
  <script src="<%=request.getContextPath()%>/assets/js/amazeui.min.js"></script>
</head>
<body>

<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong>选中课程</strong> <small>${choiceCourse.coursename}</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span> 用户：${userid} <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="/CourseManager/coursenoticelist" target="content_frame" ><span class="am-icon-table"></span> 课程公告</a></li>
        <li><a href="/CourseManager/coursedetail?courseid=${choiceCourse.courseid}" target="content_frame" ><span class="am-icon-table"></span>课程信息</a></li>
        <li><a href="/CourseManager/coursedocumentlist?courseid=${choiceCourse.courseid}" target="content_frame" ><span class="am-icon-table"></span>课程文件</a></li>
        <li><a href="/CourseManager/teachresourcelist?courseid=${choiceCourse.courseid}" target="content_frame" ><span class="am-icon-table"></span>教学资源</a></li>
        <li><a href="/CourseManager/courseworklist?courseid=${choiceCourse.courseid}" target="content_frame" ><span class="am-icon-table"></span>课程作业</a></li>
        <li><a href="/CourseManager/coursediscusslist?courseid=${choiceCourse.courseid}" target="content_frame" ><span class="am-icon-table"></span>课程讨论</a></li>
      </ul>
           <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-bookmark"></span> 友情链接</p>
                <ul>
              
                  <li><a href = "http://cduestc.benke.chaoxing.com" target = "_blank" ><span>网络公选课</span></a ></li>                   
                
                  <li><a href = "http://192.168.100.165/" target = "_blank" ><span>等级考试报名</span></a ></li>                    
                
                  <li><a href = "http://www.chsi.com.cn/" target = "_blank" ><span>学信网</span></a ></li>                   
                
                  <li><a href = "http://www.cduestc.cn/newgt/index.asp" target = "_blank" ><span>学院主页</span></a ></li>                    
                
                  <li><a href = "http://newjw.cduestc.cn/" target = "_blank" ><span>URP综合教务系统</span></a ></li>                    
                
                  <li><a href = "http://news.cduestc.cn/news/" target = "_blank" ><span>新闻中心</span></a ></li>                   
                
                </ul>

        </div>
      </div>
      
      

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-tag"></span> wiki</p>
          <p>Welcome to the Amaze UI wiki!</p>
        </div>
      </div>
    </div>
  </div>
  <!-- sidebar end -->
    <!-- content start -->
  <div class="admin-content">
      <!--iFrame自适应宽度和高度！ -->
      <iframe id="content_frame" name="content_frame" width=100% onload="this.height=content_frame.document.body.scrollHeight;this.width=content_frame.document.body.scrollWidth" marginwidth=0 marginheight=0 scrolling="no" src="/CourseManager/coursenoticelist"frameborder=0 ></iframe>

</div>
</div>
<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>
</body>
</html>
    