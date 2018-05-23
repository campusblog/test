<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<!--<base href="<%=basePath%>">-->
<title>CRM</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/libs/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />
</head>

<body>
	<!-- 导航 -->
    <div>
    	<ol class="breadcrumb" style="font-size:14px;">
          <li><a href="#">主页</a></li>
          <li><a href="#">销售机会管理</a></li>
          <li class="active">添加用户</li>
        </ol>
    </div>
    <!-- 添加数据的表格 -->
    <div stlye="padding:20px;">
      <form role="form" method="post" action="">
<table width="100%" border="0" align="center">
          <tr>
            <td width="50%" height="50" align="center">
             <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">客户名称</span>
                  <input type="text" class="form-control"  style="width:430px;">
                </div>
             </div>
            </td>
            <td width="50%" height="50" align="center">
                 <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">地区</span>
                      <input type="text" class="form-control" style="width:430px;">
                    </div>
                </div>
            </td>
          </tr>
          <tr>
            <td height="50" align="center">
                <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">客户等级</span>
                      <select name="" style="width:430px;" class="form-control">
                      	<option value="I">普通用户</option>
                      	<option value="II">长期用户</option>
                      	<option value="III">VIP用户</option>
                      	<option value="VI">高级VIP</option>
                      	<option value="V">超级VIP</option>
                      </select>
                    </div>
                </div>
            </td>
            <td height="50" align="center">
           	   <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">成功几率</span>
                      <select class="form-control" style="width:430px;">
                          <option value="10">10%</option>
                          <option value="20">20%</option>
                          <option value="30">30%</option>
                          <option value="40">40%</option>
                          <option value="50">50%</option>
                          <option value="60">60%</option>
                          <option value="70">70%</option>
                          <option value="80">80%</option>
                          <option value="90">90%</option>
                          <option value="100" selected>100%</option>
                        </select>
                    </div>
                </div>
            </td>
          </tr>
          <tr>
            <td height="50" align="left" colspan="2">
            	<div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">机会概要</span>
                      <input type="text" class="form-control" placeholder="必填项" required style="width:900px;">
                    </div>
                </div>
            </td>
          </tr>
          <tr>
            <td height="50" align="center">
            	<div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">联系人&nbsp;</span>
                      <input type="text" class="form-control" style="width:430px;">
                    </div>
                </div>
            </td>
            <td height="50" align="center">
            	<div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">联系电话</span>
                      <input type="text" class="form-control" style="width:430px;">
                    </div>
                </div>
            </td>
          </tr>
          <tr>
            <td height="110" align="left" colspan="2">
            	<div class="col-lg-3">
                    <div class="input-group" style="height:100px;">
                      <span class="input-group-addon">机会描述</span>
                      <textarea class="form-control" placeholder="必填项" required style="width:900px;height:100px;"></textarea>
                    </div>
                </div>
            </td>
          </tr>
          <tr>
            <td height="50" align="center">
            	<div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">创建人&nbsp;</span>
                      <input type="text" class="form-control" placeholder="必填项" required style="width:430px;">
                    </div>
                </div>
            </td>
            <td height="50" align="center">
            	<div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">创建时间</span>
                      <input type="text" class="form-control" required style="width:430px;" id="createTime" />
                    </div>
                </div>
            </td>
          </tr>
          <tr style="border-top: #EEE solid 2px;">
            <td height="80" align="center">
            	<div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">指派给&nbsp;</span>
                      <select class="form-control" style="width:430px;">
                          <option>朱凯</option>
                          <option>朱凯</option>
                          <option>朱凯</option>
                          <option>朱凯</option>
                          <option>朱凯</option>
                        </select>
                    </div>
                </div>
            </td>
            <td height="80" align="center">
            	<div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">指派时间</span>
                      <input type="text" class="form-control" style="width:430px;" id="toTime">
                    </div>
                </div>
            </td>
          </tr>
          <tr>
          	<td height="60" align="right" colspan="2" style="padding-right:20px;">
            	<button type="button" class="btn btn-primary" style="width:80px;">返回</button>&nbsp;
                <button type="submit" class="btn btn-primary" style="width:80px;">保存</button>
            </td>
          </tr>
        </table>	
    </div>
      <form>
</body>
<script src="js/laydate.dev.js"></script>
<script>
	laydate({
		elem: '#createTime'
	});
	laydate({
		elem: '#toTime'
	});
</script>
</html>