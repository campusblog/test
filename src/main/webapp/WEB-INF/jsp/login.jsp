<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="font-size: 100px;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<meta http-equiv="expires" content="0">
<meta name="renderer" content="webkit">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<link href="crmLogin_files/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="crmLogin_files/Login-interface.css" rel="stylesheet"
	type="text/css">
<script src="crmLogin_files/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="crmLogin_files/auto-size.js" type="text/javascript"
	charset="utf-8"></script>
<script src="crmLogin_files/bootstrap.js" type="text/javascript"></script>
<script src="crmLogin_files/layer.js" type="text/javascript"></script>
<link rel="stylesheet" href="crmLogin_files/layer.css"
	id="layui_layer_skinlayercss">
<script src="crmLogin_files/art_layer.js" type="text/javascript"></script>
<script src="crmLogin_files/jquery.vegas.js" type="text/javascript"
	charset="utf-8"></script>
<title>CRM登录页面</title>
<script type="text/javascript">
	$(function() {
		setFontSize();
	})
	$.vegas('slideshow', {
		delay : 4000,
		cover : true,
		backgrounds : [ {
			src : 'images/login/Signin-bg.jpg',
			fade : 2000
		}, {
			src : 'images/login/Signin-bg2.jpg',
			fade : 2000
		}, {
			src : 'images/login/Signin-bg3.jpg',
			fade : 2000
		} ]
	});
	if (top.location != self.location)
		top.location = self.location;
</script>
</head>
<body>
	<img class="vegas-background" src="crmLogin_files/Signin-bg2.jpg"
		style="position: fixed; left: 0px; top: -84.5px; width: 1600px; height: 900px; bottom: auto; right: auto;">


	<!--登录页 start-->
	<div class="Signin-bg">
		<div class="tile">
			<img class="logo" src="crmLogin_files/logo.png" alt="logo">
			<form class="signin" id="formId" role="form"
				action="Sys_user/check"
				method="post">
				<h3>客户商机管理系统</h3>
				<div class="btn-box">
					<i></i> <input type="text" placeholder="请输入账号" id="loginNameId"
						class="accountNumber" name="username" autofocus="">
				</div>
				<div class="btn-box">
					<i class="icon2"></i> <input type="password" id="passWordId"
						placeholder="请输入密码" class="passWord" name="password"
						required="">
				</div>
				<input type="submit" value="登录"
					class="button-submit btn btn-lg btn-warning btn-block">
			</form>
		</div>
		<h4 class="copyright">Copyright © 2015-2017.Company www.dgg.net
			All rights reserved. Created By: 顶呱呱集团-技术中心</h4>
	</div>
	<!--登录页 end-->
	<script type="text/javascript">
		if ("" != "") {
			msg.error("");
		};

		$(function() {
			$('#found input').keyup(function() {
				var jobNum = $.trim(document.getElementById('jobNum').value);
				var testNum = $.trim(document.getElementById('testNum').value);
				var pwd = $.trim(document.getElementById('newPwd').value);
				var sPwd = $.trim(document.getElementById('newPwd1').value);
				if (jobNum == '' || testNum == '' || pwd == '' || pwd != sPwd) {
					$('#rest-btn').removeAttr("onclick");
					$('#rest-btn').addClass("disabled");
				} else {
					$('#rest-btn').attr("onclick", "testPwd()");
					$('#rest-btn').removeClass("disabled");
				}
			});
			$('#newPwd')
					.keyup(
							function() {
								var reg = new RegExp(
										"^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$");
								var pwdV = $(this).val();
								if (!reg.test(pwdV)) {
									$(this)
											.next('.pwd-tip')
											.html(
													'<span class="red">密码至少为6位，需要数字和字母的组合(不能有符号)</span>');
								} else {
									$(this).next('.pwd-tip').html(
											'<span class="green">输入正确</span>');
								}
							});
			$('#newPwd1').keyup(
					function() {
						var pwdV = $('#newPwd').val();
						var pwdV1 = $(this).val();
						if (pwdV == pwdV1) {
							$(this).next('.pwd-tip').html(
									'<span class="green">密码输入一致</span>');
						} else {
							$(this).next('.pwd-tip').html(
									'<span class="red">两次密码不同</span>');
						}
					})
		});
		function found() {
			layer.open({
				type : 1,
				title : '找回密码',
				area : [ '340px' ],
				content : $('#found'),
				end : function() {
					document.getElementById('jobNum').value = '';
					document.getElementById('testNum').value = '';
					wait = 0;
				}
			});
		}
		//验证密码
		function testPwd() {
			var jobNum = $.trim(document.getElementById('jobNum').value);
			var testNum = $.trim(document.getElementById('testNum').value);
			var pwd = $.trim(document.getElementById('newPwd').value);
			var sPwd = $.trim(document.getElementById('newPwd1').value);
			if (jobNum == '' || testNum == '' || pwd == '') {
				layer.msg('工号/密码/验证码不能为空');
			} else if (pwd != sPwd) {
				layer.msg('两次密码不一致');
			} else {
				$.ajax({
					post : 'POST',
					url : '/user/update_pwd.shtml',
					dataType : 'json',
					data : {
						'jobNumber' : jobNum,
						'pwd' : pwd,
						'sPwd' : sPwd,
						'code' : testNum
					},
					success : function(data) {
						if (data.code == 1) {
							layer.closeAll();
							msg.info(data.msg);
							setTimeout("window.location.reload()", 1000);
						} else {
							msg.info(data.msg);
						}
					}
				})
			}
		}
		var wait = 120;

		//获取验证码
		function getTest() {
			var reg = new RegExp("^[0-9]*$");
			var jobObj = document.getElementById('loginNameId');
			var jobNum = $.trim(jobObj.value);
			if (!reg.test(jobNum) || jobNum == '') {
				$('#getCode').attr("onclick", "getTest(this)");
				layer.msg('请输入正确的工号');
			} else {
				$.ajax({
					post : 'POST',
					url : '/user/confirm_phone.shtml',
					dataType : 'json',
					data : {
						'jobNumber' : jobNum
					},
					async : true,
					success : function(msg) {
						if (msg.code == 1) {
							layer.confirm(
									'发送号码为：<b style="color:#ff2e0a;font-weight: bold;">'
											+ msg.phoneNumber + '</b>', {
										btn : [ '确定', '取消' ]
									//按钮
									}, function(index) {
										getTestMain(jobNum);
										layer.close(index);
									});
						} else {
							layer.msg(msg.msg);
						}
					}
				})
			}

		}
		function getTestMain(jobNum) {
			$.ajax({
				post : 'POST',
				url : '/user/get_forget_pwd_validate_code.shtml',
				dataType : 'json',
				data : {
					'jobNumber' : jobNum
				},
				async : false,
				success : function(num) {
					if (num.code == 1) {
						time();
					} else {
						layer.msg(num.msg);
					}
				}
			})
		}
		//获取验证码倒计时
		function time() {
			if (wait == 0) {
				$('#getCode').attr("onclick", "getTest(this)");
				$('#getCode').removeClass('disabled').text('获取验证码');
				wait = 120;
			} else {
				$('#getCode').removeAttr("onclick");
				$('#getCode').addClass('disabled').text(wait + 's后重新获取');
				wait--;
				setTimeout(function() {
					time();
				}, 1000);
			}
		}

		//回车登陆
		document.onkeydown = function() {
			if (event.keyCode == 13) {
				validate();
			}
		}}
	</script>



</body>
</html>