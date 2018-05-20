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

<title>CRM</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="css/bootstrap/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="css/libs/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />

</head>

<body>
	<!-- 导航 -->
    <div>
    	<ol class="breadcrumb" style="font-size:14px;">
          <li><a href="#">主页</a></li>
          <li class="active">角色管理</li>
        </ol>
    </div>
    <!-- 展示表格数据 -->
    <div style="padding:10px 20px;">
        <table class="table table-hover ">
            <thead>
                <tr>
                    <th><span>编号</span></th>
                    <th><span>角色名称</span></th>
                    <th class="text-center" width="50%"><span>角色描述</span></th>
                    <th class="text-center"><span>角色拥有者数量</span></th>
                    <th class="text-center"><span>操作</span></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${list }" var="l">
            	<tr>
            		<td>#${l.role_id }</td>
            		<td>${l.role_name }</td>
            		<td class="text-center">${l.role_desc }</td>
            		<td class="text-center">100</td>
            		<td style="width: 15%;" align="center">
                    	<!--系统管理员不需要下面的按钮 -->
                        <a href="roleassign.html" class="table-link" title="操作角色"> 
                            <span class="fa-stack"> 
                                <i class="fa fa-square fa-stack-2x"></i> 
                                <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                            </span>
                        </a> 
                        <!-- 禁用和启用按钮判断出现,跟user列表一样, -->
                        <a href="#" class="table-link danger" title="禁用"> 
                            <span class="fa-stack"> 
                                <i class="fa fa-square fa-stack-2x"></i> 
                                <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
                            </span>
                        </a>
                    </td>
            	</tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>