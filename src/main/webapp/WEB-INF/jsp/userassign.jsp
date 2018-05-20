<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css"
	href="../../css/bootstrap/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="../../css/libs/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="../../css/mystyle.css" />
<style>
#developinfo td{ font-size:14px;}
#planinfo th{ font-size:14px;}
#planinfo td{ font-size:14px;}
</style>
</head>

<body>
	<!-- 导航 -->
    <div>
    	<ol class="breadcrumb" style="font-size:14px;">
          <li><a href="#">主页</a></li>
          <li><a href="#">用户管理</a></li>
          <li class="active">分配角色</li>
        </ol>
    </div>
    <!-- 数据表格展示 -->
    <div style="padding:0px 20px;">
    	<table width="100%" border="0" class="table table-bordered" id="developinfo">
          <tr>
            <td width="20%" height="40" align="center" class="active">编号</td>
            <td width="30%" height="40">1</td>
            <td width="20%" height="40" align="center" class="active">用户名称</td>
            <td width="30%" height="40">huanggang</td>
          </tr>
          <tr>
            <td height="40" align="center" class="active">角色名称</td>
            <td height="40" colspan="3">系统管理员</td>
          </tr>
          <tr>
            <td height="40" align="center" class="active">角色概要</td>
            <td height="40" colspan="3">管理系统用户、角色与权限、数据字典、保证系统正常运行。</td>
          </tr>
        </table>
        <div style="padding:5px;"></div>
        <form>
        <table width="100%" border="0" align="right" class="table">
          <tr>
          	<td width="50%">
            
            </td>
            <td height="40" align="right">
            	<div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">指派角色</span>
                      <select class="form-control" style="width:430px;">
                      	<!-- 做判断,自己的目前的角色名称不在下拉列表中 -->
                          <option>高管</option>
                          <option>客户经历</option>
                          <option>客户主管</option>
                          <option>系统管理员</option>
                        </select>
                    </div>
                </div>
            </td>
          </tr>
        </table>
        <div style="text-align:right; padding-right:20px;">
            <button type="button" class="btn btn-primary" style="width:80px;">保存</button>
        	<button type="button" class="btn btn-primary" style="width:80px;" onclick="history.back()">返回</button>
        </div>
        </form>
</body>
</html>