<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%><!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>欢迎使用学生日常行为评分系统</title>
<link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
</head>
<body class=" theme-blue">
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="content">
		<div class="header">
			<h1 class="page-title">学生加分信息列表</h1>
		</div>
		<div class="main-content">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">教师</th>
						<th class="text-center">学生</th>
						<th class="text-center">考核项目</th>
						<th class="text-center">原因</th>
						<th class="text-center">分数</th>
						<th class="text-center">日期</th>
						<th class="text-center">备注</th>
					</tr>
				</thead>
				<c:forEach items="${bonusList}" var="bonus">
					<tr align="center">
						<td class="center">${bonus.realname}</td>
						<td class="center">${bonus.srealname}</td>
						<td class="center">${bonus.title}</td>
						<td class="center">${bonus.reason}</td>
						<td class="center">${bonus.num}</td>
						<td class="center">${bonus.addtime}</td>
						<td class="center">${bonus.memo}</td>
					</tr>
				</c:forEach>
			</table>
			<ul class="pagination">
				<li>
					<form action="bonus/queryBonusByCond.action" name="myform" method="post">
						<label>查询条件: <select name="cond" style="width: 100px">
								<option value="teacherid">按教师查询</option>
								<option value="studentid">按学生查询</option>
								<option value="programsid">按考核项目查询</option>
								<option value="reason">按原因查询</option>
								<option value="num">按分数查询</option>
								<option value="addtime">按日期查询</option>
								<option value="memo">按备注查询</option>
						</select>
						</label>&nbsp;&nbsp;&nbsp; <label>关键字: <input type="text" name="name" required style="width: 100px" /></label>&nbsp;&nbsp;&nbsp;
						<label><input type="submit" value="查询" class="mws-button green" /> </label>${html }
					</form>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>