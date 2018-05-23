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
          <li><a href="#">客户服务管理</a></li>
          <li class="active">服务管理</li>
        </ol>
    </div>
    <!-- 动态查询条件 -->
    <div style="padding:0px 20px 0px 0px;">
    	<table>
            <tr>
                <td height="60">
                    <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon" style="width:100px;">客户名称</span>
                      <input type="text" class="form-control" style="width:180px;" name="svr_cust_name">
                    </div>
                    </div>
                </td>
                <td>
                    <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon" style="width:100px;">概要</span>
                      <input type="text" class="form-control" style="width:180px;" name="svr_title">
                    </div>
                    </div>
                </td>
                <td>
                    <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon" style="width:100px;">服务类型</span>
                      <select class="form-control" style="width:180px;" name="svr_type">
                          <option value="资讯">资讯</option>
                          <option value="投诉">投诉</option>
                          <option value="建议">建议</option>
                      </select>
                    </div>
                    </div>
                </td>
                <td align="left" width="15%">&nbsp;
                    
                </td>
            </tr>
            <tr>
            	<td colspan="2">
                    <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon" style="width:100px;">创建日期</span>
                      <input type="date" class="form-control" style="width:180px;" id="startTime" name="svr_create_date">
                      <span class="input-group-addon">到</span>
                      <input type="date" class="form-control" style="width:180px;" id="endTime" name="svr_create_date1">
                    </div>
                    </div>
                </td>
                <td>
                    <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon" style="width:100px;">状态</span>
                      <select class="form-control" style="width:180px;" name="svr_result">
                        <option value="">全部</option>
                        <option value="新创建">新创建</option>
                        <option value="已分配">已分配</option>
                        <option value="已处理">已处理</option>
                        <option value="已反馈">已反馈</option>
                        <option value="已归档">已归档</option>
                      </select>
                    </div>
                    </div>
                </td>
                <td align="left" width="15%">
                    <button type="submit" class="btn btn-info" style="width:80px;">查询</button>
                </td>

            </tr>
        </table>
	</div>
    <!-- 展示表格数据 -->
    <div style="padding:10px 20px;">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th><span>编号</span></th>
                    <th><span>客户名称</span></th>
                    <th><span>概要</span></th>
                    <th class="text-center"><span>服务类型</span></th>
                    <th class="text-center"><span>创建人</span></th>
                    <th class="text-center"><span>创建日期</span></th>
                    <th class="text-center"><span>分配给</span></th>
                    <th class="text-center"><span>操作</span></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list }" var="c">
            	<tr>
            		<td>#${c.svr_id }</td>
            		<td>${c.svr_cust_name }</td>
            		<td>${c.svr_title }</td>
            		<td>${c.svr_type }</td>
            		<td>${c.svr_create_by }</td>
            		<td>${c.svr_create_date }</td>
            		<td>${c.svr_due_to }</td>
            		<td class="text-center">
                        <a href="#" class="table-link" title="查看"> 
                            <span class="fa-stack"> 
                                <i class="fa fa-square fa-stack-2x"></i> 
                                <i class="fa fa-search-plus fa-stack-1x fa-inverse"></i>
                            </span>
                        </a>
                    </td>
            	</tr>
            </c:forEach>
            </tbody>
        </table>
    
       <ul class="pager">
			<li><a
				href="toShowService?pageNow=1&pageSize=3&svr_cust_name=${svr_cust_name }&svr_title=${svr_title}&svr_type=${svr_type}&svr_create_date=${svr_create_date}
				&svr_create_date1=${svr_create_date1}&svr_result=${svr_result}">首页</a></li>
			<c:if test="${page.pageNow >1}">
				<li><a
					href="toShowService?pageNow=${page.pageNow-1}&svr_cust_name=${svr_cust_name }&svr_title=${svr_title}&svr_type=${svr_type}&svr_create_date=${svr_create_date}
				&svr_create_date1=${svr_create_date1}&svr_result=${svr_result}">上一页</a></li>
			</c:if>
			<li><span>第${page.pageNow }页</span></li>
			<li><span>共${page.pageCount }页</span></li>
			<li><span>共${page.count }条数据</span></li>
			<c:if test="${page.pageNow<page.pageCount}">
				<li><a
					href="toShowService?pageNow=${page.pageNow+1}&svr_cust_name=${svr_cust_name }&svr_title=${svr_title}&svr_type=${svr_type}&svr_create_date=${svr_create_date}
				&svr_create_date1=${svr_create_date1}&svr_result=${svr_result}">下一页</a></li>
			</c:if>
			<li><a
				href="toShowService?pageNow=${page.pageCount}&svr_cust_name=${svr_cust_name }&svr_title=${svr_title}&svr_type=${svr_type}&svr_create_date=${svr_create_date}
				&svr_create_date1=${svr_create_date1}&svr_result=${svr_result}">尾页</a></li>
		</ul>
</body>
<script src="js/laydate.dev.js"></script>
<script>
	laydate({
		elem: '#startTime'
	});
	laydate({
		elem: '#endTime'
	});
</script>
</html>