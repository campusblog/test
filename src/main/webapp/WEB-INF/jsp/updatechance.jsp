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
<title>修改销售机会</title>
<link rel="stylesheet" type="text/css"
	href="css/bootstrap/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="css/libs/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />
<script src="js/jquery-1.8.3.min.js"></script>
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
          <li><a href="#">客户开发计划</a></li>
          <li class="active">查看</li>
        </ol>
    </div>
    <!-- 数据表格展示 -->
    <div style="padding:0px 20px;">
    	<table width="100%" border="0" class="table table-bordered" id="developinfo">
          <tr>
            <td width="20%" height="40" align="center" class="active">编号</td>
            <td width="30%" height="40">#${sal_chance.chc_id }</td>
            <td width="20%" height="40" align="center" class="active">机会来源</td>
            <td width="30%" height="40">${sal_chance.chc_source }</td>
          </tr>
          <tr>
            <td height="40" align="center" class="active">客户名称</td>
            <td height="40">${sal_chance.chc_cust_name }</td>
            <td height="40" align="center" class="active">成功几率</td>
            <td height="40">${sal_chance.chc_rate }</td>
          </tr>
          <tr>
            <td height="40" align="center" class="active">概要</td>
            <td height="40" colspan="3">${sal_chance.chc_title }</td>
          </tr>
          <tr>
            <td height="40" align="center" class="active">联系人</td>
            <td height="40">${sal_chance.chc_linkman }</td>
            <td height="40" align="center" class="active">联系人电话</td>
            <td height="40">${sal_chance.chc_tel }</td>
          </tr>
          <tr>
            <td height="40" align="center" class="active">机会描述</td>
            <td height="40" colspan="3">${sal_chance.chc_desc }</td>
          </tr>
          <tr>
            <td height="40" align="center" class="active">创建人</td>
            <td height="40">${sal_chance.chc_create_by }</td>
            <td height="40" align="center" class="active">创建时间</td>
            <td height="40">${sal_chance.chc_create_date }</td>
          </tr>
        </table>
        <div style="padding:5px;"></div>
        <form action="doUpdateChance" method="post">
        <table width="100%" border="0" align="center">
          <tr>
            <td height="80" align="center">
            	<div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">指派给&nbsp;</span>
                      <!-- 下拉需要ajax -->
                      <script type="text/javascript">
                      $(document).ready(function () {
                    	    $.ajax({
                    	        type: "POST",
                    	        url: "getSys_user",
                    	        dataType: "json",
                    	        success: function (data) {
                    	            for (var i = 0; i < data.length; i++) {
                    	                $("#chc_due_to").append("<option value="+data[i].usr_id+">" + data[i].usr_name + "</option>");
                    	            }
                    	        }
                    	    });
                    	});
                      </script>
                      
                      <select class="form-control" style="width:430px;" name="chc_due_to" id="chc_due_to">
                        </select>
                    </div>
                </div>
            </td>
            <td height="80" align="center">
            	<div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">指派时间</span>
                      <b>旧：</b><input value="${sal_chance.chc_due_date }" class="form-control" style="width:430px;" readonly="readonly">
                      <b>新：</b><input type="date" class="form-control" style="width:430px;" name="chc_due_date">
                    </div>
                </div>
            </td>
          </tr>
        </table>
        <div style="text-align:right; padding-right:20px;">
            <button type="submit" class="btn btn-primary" style="width:80px;">保存</button>
        	<button type="button" class="btn btn-primary" style="width:80px;" onclick="history.back()">返回</button>
        </div>
        </form>
</body>
</html>