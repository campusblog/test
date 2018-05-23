<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
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
          <li class="active">销售机会管理</li>
        </ol>
    </div>
    <!-- 动态查询条件 -->
    <div style="padding:0px 20px 0px 0px;">
    <form action="tochance" method="post">
    	<table>
            <tr>
                <td>
                    <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon" style="width:100px;">客户名称</span>
                      <input type="text" class="form-control" style="width:180px;" value="${reqestScope.chc_cust_name}" name="chc_cust_name">
                    </div>
                    </div>
                </td>
                <td>
                    <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon" style="width:100px;">概要</span>
                      <input type="text" class="form-control" style="width:180px;" name="chc_title" value="${reqestScope.chc_title}">
                    </div>
                    </div>
                </td>
                <td>
                    <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon" style="width:100px;">联系人</span>
                      <input type="text" class="form-control" style="width:180px;" name="chc_linkman" value="${reqestScope.chc_linkman}">
                    </div>
                    </div>
                </td>
                <td align="left" width="15%">
                    <button type="submit" class="btn btn-info" style="width:80px;">查询</button>
                </td>
                <td>
                    <div class="filter-block pull-right" style="margin-left:10px;">
                        <a href="toChancemanage" class="btn btn-primary pull-right" target="rightContent"> 
                            <i	class="fa fa-plus-circle fa-lg"></i> 添加机会
                        </a>
                    </div>
                </td>
            </tr>
        </table>
    </form>
	</div>
    <!-- 展示表格数据 -->
    <div style="padding:10px 20px;">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th><span>编号</span></th>
                    <th><span>客户名称</span></th>
                    <th><span>概要</span></th>
                    <th class="text-center"><span>联系人</span></th>
                    <th class="text-center"><span>联系人电话</span></th>
                    <th class="text-center"><span>创建时间</span></th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list }" var="c">
            	<tr>
            		<td>${c.chc_id}</td>
            		<td>${c.chc_cust_name }</td>
            		<td>${c.chc_title }</td>
            		<td>${c.chc_linkman }</td>
            		<td>${c.chc_tel }</td>
            		<td>${c.chc_create_date}</td>
            		<td style="width: 15%;">
            		<!-- 显示具体 -->
                        <a href="toChanceassign?chc_id=${c.chc_id}"	class="table-link"> 
                            <span class="fa-stack"> 
                                <i class="fa fa-square fa-stack-2x"></i> 
                                <i class="fa fa-search-plus fa-stack-1x fa-inverse"></i>
                            </span>
                        </a> 
                        <!-- 修改 -->
                        <a href="toUpdateChance?chc_id=${c.chc_id}" class="table-link"> 
                            <span class="fa-stack"> 
                                <i class="fa fa-square fa-stack-2x"></i> 
                                <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                            </span>
                        </a> 
                        <!-- 删除 -->
                        <script type="text/javascript">
								function del() {
									if (!confirm("确认要删除？")) {
										window.event.returnValue = false;
									}
								}
							</script>
                        <a href="#" class="table-link danger" onclick="return del()" title="删除"> 
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
    
      	<ul class="pager">
			<li><a
				href="tochance?pageNow=1&pageSize=3&chc_cust_name=${chc_cust_name }&chc_title=${chc_title}&chc_linkman=${chc_linkman}">首页</a></li>
			<c:if test="${page.pageNow >1}">
				<li><a
					href="tochance?pageNow=${page.pageNow-1}&chc_cust_name=${chc_cust_name }&chc_title=${chc_title}&chc_linkman=${chc_linkman}">上一页</a></li>
			</c:if>
			<li><span>第${page.pageNow }页</span></li>
			<li><span>共${page.pageCount }页</span></li>
			<li><span>共${page.count }条数据</span></li>
			<c:if test="${page.pageNow<page.pageCount}">
				<li><a
					href="tochance?pageNow=${page.pageNow+1}&chc_cust_name=${chc_cust_name }&chc_title=${chc_title}&chc_linkman=${chc_linkman}">下一页</a></li>
			</c:if>
			<li><a
				href="tochance?pageNow=${page.pageCount}&chc_cust_name=${chc_cust_name }&chc_title=${chc_title}&chc_linkman=${chc_linkman}">尾页</a></li>
		</ul>
    </div>
</body>
</html>