<!DOCTYPE html>
<html class="h-100">

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<meta charset="utf-8">
<title>ホーム</title>

<link rel="stylesheet" href="<s:url value="/bootstrap/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<s:url value="/css/index.css"/>">

<script src="<s:url value="/bootstrap/js/bootstrap.min.js"/>"></script>

</head>

<body class="h-100">

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">ホーム</a>
			<!--  -->
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!--  -->
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav mr-auto mb-2 mb-lg-0">
					<li class="nav-item active"><s:a action="index" cssClass="nav-link">ホーム</s:a></li>
					<li class="nav-item"><s:a action="users" cssClass="nav-link">ユーザー管理</s:a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<!--  -->
	</div>

</body>

</html>
