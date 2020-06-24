<!DOCTYPE html>
<html class="h-100">

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<meta charset="utf-8">
<title>ユーザー管理</title>

<link rel="stylesheet" href="<s:url value="/bootstrap/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<s:url value="/css/users.css"/>">

<script src="<s:url value="/bootstrap/js/bootstrap.min.js"/>"></script>

</head>

<body class="h-100">

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">ユーザー管理</a>
			<!--  -->
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!--  -->
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav mr-auto mb-2 mb-lg-0">
					<li class="nav-item"><s:a action="index" cssClass="nav-link">ホーム</s:a></li>
					<li class="nav-item active"><s:a action="users" cssClass="nav-link">ユーザー管理</s:a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>アカウント</th>
					<th>アクション</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="users" var="user">
					<tr>
						<td><s:property value="%{id}" /></td>
						<td><s:property value="%{username}" /></td>
						<td><s:form action="users">
								<s:hidden name="id" />
								<s:submit method="edit" value="変更" theme="simple" cssClass="btn btn-primary mx-1" />
								<s:submit method="delete" value="変更" theme="simple" cssClass="btn btn-danger mx-1" />
							</s:form></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>

</body>

</html>
