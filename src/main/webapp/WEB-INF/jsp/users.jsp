<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--<base href="<%=basePath%>">-->

<title>显示所有用户页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="css/bootstrap/bootstrap.min.css" />
<script src="js/jquery-1.8.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/libs/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />
</head>
<body>
	<!-- 导航 -->
	<div>
		<ol class="breadcrumb" style="font-size: 14px;">
			<li><a href="#">主页</a></li>
			<li class="active">用户管理</li>
		</ol>
	</div>
	<!-- 动态查询条件 -->
	<div style="padding: 0px 20px 0px 0px;">
		<form action="index" method="post">
			<table>
				<tr>
					<td>
						<div class="col-lg-3">
							<div class="input-group">
								<span class="input-group-addon" style="width: 100px;">用户名称</span>
								<input type="text" class="form-control" style="width: 200px;"
									name="usr_name" value="${requestScope.usr_name }">
							</div>
						</div>
					</td>
					<td>
						<div class="col-lg-3">
							<div class="input-group">
								<span class="input-group-addon" style="width: 100px;">角色</span>
								<select class="form-control" style="width: 200px;"
									name="usr_role_id">
									<option value="">全部</option>
									<!-- 使用ajax读取 -->
									<option value="1" ${usr_role_id == 1?"selected":""}>系统管理员</option>
									<option value="2" ${usr_role_id == 2?"selected":""}>高管</option>
									<option value="3" ${usr_role_id == 3?"selected":""}>主管</option>
									<option value="4" ${usr_role_id == 4?"selected":""}>客户经理</option>
								</select>
							</div>
						</div>
					</td>
					<td align="left" width="15%">
						<button type="submit" class="btn btn-info" style="width: 80px;">查询</button>
					</td>
					<td>
						<div class="filter-block pull-right" style="margin-left: 10px;">
							<a href="toUserinsert" class="btn btn-primary pull-right"
								target="rightContent"> <i class="fa fa-plus-circle fa-lg"></i>
								添加用户
							</a>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 展示表格数据 -->
	<div style="padding: 10px 20px;">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><span>编号</span></th>
					<th><span>用户名称</span></th>
					<th class="text-center"><span>角色名称</span></th>
					<th class="text-center"><span>操作</span></th>
				</tr>
			</thead>
			<tbody>
				<!-- 开始循环人员 -->
				<c:forEach items="${page.list}" var="c">
					<tr>
						<td>#${c.usr_id}</td>
						<td>${c.usr_name}</td>
						<!-- <td><span class="STYLE1">${u.userRole == 1?"系统管理员":(u.userRole==2?"经理":"员工") }</span></td> -->
						<td class="text-center">${c.usr_role_id==1?"系统管理员":(c.usr_role_id==2?"高管":(c.usr_role_id==3?"主管":"客户经理"))}</td>
						<!-- 如果为自己,则不显示下面的操作按钮 
                    	显示&nbsp;
                    -->
						<c:if test="${c.usr_name!=sessionScope.username}">
							<td style="width: 15%;" align="center"><a
								href="Sys_user/userassign" class="table-link" title="分配角色">
									<span class="fa-stack"> <i
										class="fa fa-square fa-stack-2x"></i> <i
										class="fa fa-pencil fa-stack-1x fa-inverse"></i>
								</span>
							</a> <script type="text/javascript">
								function del() {
									if (!confirm("确认要删除？")) {
										window.event.returnValue = false;
									}
								}
							</script> <a href="#" class="table-link danger" title="删除"  onclick="return del()"> <span
									class="fa-stack"> <i class="fa fa-square fa-stack-2x"></i>
										<i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
								</span>
							</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<ul class="pager">
			<li><a
				href="index?pageNow=1&pageSize=3&usr_name=${usr_name }&usr_role_id=${usr_role_id}">首页</a></li>
			<c:if test="${page.pageNow >1}">
				<li><a
					href="index?pageNow=${page.pageNow-1}&usr_name=${usr_name }&usr_role_id=${usr_role_id}">上一页</a></li>
			</c:if>
			<li><span>第${page.pageNow }页</span></li>
			<li><span>共${page.pageCount }页</span></li>
			<li><span>共${page.count }条数据</span></li>
			<c:if test="${page.pageNow<page.pageCount}">
				<li><a
					href="index?pageNow=${page.pageNow+1}&usr_name=${usr_name }&usr_role_id=${usr_role_id}">下一页</a></li>
			</c:if>
			<li><a
				href="index?pageNow=${page.pageCount}&usr_name=${usr_name }&usr_role_id=${usr_role_id}">尾页</a></li>
		</ul>


	</div>
</body>
</html>