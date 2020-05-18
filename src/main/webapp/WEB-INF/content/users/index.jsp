<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html class="h-100">

<head>

<meta charset="utf-8">
<title>ユーザー管理</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<style type="text/css">
body {
	padding-top: 80px;
}

#form-card {
	width: 600px;
}
</style>

</head>

<body class="h-100">

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <a class="navbar-brand" href="#">ユーザー管理</a>
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
		<s:iterator value="%{users}" var="user">
			<tr>
				<td><s:property value="%{id}" /></td>
				<td><s:property value="%{username}" /></td>
				<td>
					<s:form action="users">
						<s:hidden name="id"  />
						<s:submit method="edit" value="変更" theme="simple" cssClass="btn btn-primary mx-1"/>
						<s:submit method="delete" value="変更" theme="simple" cssClass="btn btn-danger mx-1"/>
					</s:form>
				</td>
			</tr>
		</s:iterator>
		</tbody>
	</table>
</div>

</body>

</html>