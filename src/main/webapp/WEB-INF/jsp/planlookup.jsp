<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--<base href="<%=basePath%>">-->

<title>查看计划详情</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="css/bootstrap/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="css/libs/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />
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
            <td height="40">${sal_chance.chc_title }</td>
            <td height="40" align="center" class="active">状态</td>
            <td height="40">${sal_chance.chc_status==0?"未分配":(sal_chance.chc_status==1?"开发中":(sal_chance.chc_status==2?"开发成功":"开发失败")) } </td>
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
            <td height="40">${sal_chance.chc_source }</td>
            <td height="40" align="center" class="active">创建时间</td>
            <td height="40">${sal_chance.chc_source }</td>
          </tr>
          <tr>
            <td height="40" align="center" class="active">指派给</td>
            <td height="40">${sal_chance.chc_create_by }</td>
            <td height="40" align="center" class="active">指派时间</td>
            <td height="40">${sal_chance.chc_create_date }</td>
          </tr>
        </table>
        <div style="padding:5px;"></div>
        <!-- 计划执行效果展示 -->
        <table class="table table-hover" id="planinfo">
          <thead>
          	<tr>
            	<th width="20%" class="text-center">日期</th>
                <th width="40%" class="text-center">计划</th>
                <th width="40%" class="text-center">执行效果</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items="${sal_plan }" var="l">
          	<tr>
          		<td align="center">${l.pla_date }</td>
                <td align="center">${l.pla_todo }</td>
                <td align="center">${l.pla_result } </td>
          	</tr>
          </c:forEach>
          </tbody>
        </table>
        <div style="text-align:right; padding-right:20px;">
        	<button type="button" class="btn btn-primary" style="width:80px;" onclick="history.back()">返回</button>
        </div>
    </div>
</body>
</html>