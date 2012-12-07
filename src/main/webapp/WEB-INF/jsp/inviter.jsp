<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>邀请</title>
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
					<form class="form-horizontal" id="inviteForm" action='<c:url value="/invite.json" />' method="post">
						<div class="control-group">
							<div class="controls">
								<div class="input-append">
								  <input class="span4" id="appendedInputButton" type="text" name="email">
								  <button class="btn btn-primary" type="submit">邀请!</button>
								</div>
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
	<script type="text/javascript" src='<c:url value="/javascript/jquery/validation/messages_zh.js" />'></script>
	<script type="text/javascript" src='<c:url value="/javascript/jquery/form/jquery.form.js" />'></script>
	<script type="text/javascript">
	$(function() {
		$("#inviteForm").validate({
			"rules":{
				email:{
					required:true,
					email:true
				}
			},
			errorElement:"span",
			errorClass:"help-block",
			errorPlacement:function(error, element) {
				error.appendTo(element.parent().parent());
			},
			highlight:function(element, errorClass) {
				$(element).parent().parent().parent().removeClass("success").addClass("error");
			},
			success:function(label, element) {
				label.text("");
			},
			unhighlight:function(element, errorClass) {
				$(element).parent().parent().parent().removeClass("error").addClass("success");
			},
			submitHandler:function(form) {
				$("#inviteForm").ajaxSubmit({
					dataType:"json",
					beforeSerialize:function($form, options) {
						
					},
					beforeSubmit:function(formData, jqForm, options) {
					},
					success:function(data) {
						if (data.result) {
							alert("邀请成功");
						} else {
							alert(data.msg);
						}
					},
					error:function(jqXHR, textStatus, errorThrown) {
						
					}
				});
			}
		});
	});
	</script>
</body>
</html>