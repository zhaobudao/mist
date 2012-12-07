<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>注册</title>
<!-- 	<link type="image/x-icon" rel="shortcut icon" href="favicon.ico"/> -->
	<meta name="description" content="Bamboo" />
   <meta name="keywords" content="Bamboo" />
	<!-- Bootstrap -->
	<link href='<c:url value="/bootstrap/css/bootstrap.min.css" />' rel="stylesheet"/>
	<link href='<c:url value="/css/style.css" />' rel="stylesheet"/>
	<link href='<c:url value="/bootstrap/css/bootstrap-responsive.css" />' rel="stylesheet"/>
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">Bamboo</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
					</ul>
					
					<form class="navbar-form pull-right" action="signin" method="post">
		              <input class="span2" type="text" name="email" placeholder="Email" />
		              <input class="span2" type="password" name="password" placeholder="Password" />
		              <input type="submit" class="btn" value="登录" />
		            </form>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="span12">
				<div class="well well-small">
					<form class="form-horizontal" id="registForm" action='<c:url value="/u/invite" />' method="post">
					  <div class="control-group">
					    <label class="control-label" for="inputEmail">邮箱:</label>
					    <div class="controls">
<%-- 					      <input type="text" placeholder="输入你的邮箱" value="${email }" class="uneditable-input" readonly="readonly"> --%>
								<span class="input uneditable-input">${email }</span>
					    </div>
					  </div>
					  <div class="control-group">
					    <label class="control-label" for="inputPassword">密码:</label>
					    <div class="controls">
					      <input name="password" type="password" id="inputPassword" placeholder="输入你的密码">
					    </div>
					  </div>
					  <div class="control-group">
					    <label class="control-label" for="inputPassword">确认密码:</label>
					    <div class="controls">
					      <input name="repassword" type="password" placeholder="再次输入密码">
					    </div>
					  </div>
					  <div class="control-group">
					  	<label class="control-label" for="inputPassword">验证码:</label>
					    <div class="controls">
					      <input name="captcha" class="input-small" type="text" id="inputCaptcha">
					      <img alt="" src='<c:url value="/captcha" />' style="width: 90px;height: 30px;padding-left: 15px;">
					    </div>
					  </div>
					  <div class="control-group">
					    <div class="controls">
					      <input class="btn btn-primary" type="submit">
					      <input class="btn" type="reset">
					    </div>
					  </div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->

	<script type="text/javascript" src='<c:url value="/javascript/jquery/jquery-1.8.2.min.js" />'></script>
	<script type="text/javascript" src='<c:url value="/bootstrap/js/bootstrap.min.js" />'></script>
	<script type="text/javascript" src='<c:url value="/javascript/jquery/validation/jquery.validate.js" />'></script>
<!-- 	<script type="text/javascript" src='<c:url value="/javascript/jquery/validation/additional-methods.js" />'></script> -->
	<script type="text/javascript" src='<c:url value="/javascript/jquery/validation/messages_zh.js" />'></script>
	<script type="text/javascript" src='<c:url value="/javascript/jquery/form/jquery.form.js" />'></script>
	<script type="text/javascript" src='<c:url value="/javascript/prettify/prettify.js" />'></script>
	<script type="text/javascript" src='<c:url value="/javascript/regist.js" />'></script>
</body>
</html>