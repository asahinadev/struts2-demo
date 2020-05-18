<!DOCTYPE html>
<html class="h-100">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>

<meta charset="utf-8">
<title>ログイン</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" ></script>

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
  <a class="navbar-brand" href="#">ログイン</a>
</nav>

<div class="container mt-5 ">

	<form method="post" action='<%=response.encodeURL("j_security_check")%>' class="card mx-auto" id="form-card">
		<fieldset class="card-body py-3 px-5">
		
		<div class="form-group form-row">
			<label class="col-3" for="j_username">アカウント</label>
			<div class="col">
				<input type="text" name="j_username" class="form-control" id="j_username">
			</div>
		</div>
		
		<div class="form-group form-row">
			<label class="col-3" for="j_password">パスワード</label>
			<div class="col">
				<input type="password" name="j_password" class="form-control" id="j_password">
			</div>
		</div>
		
		<div class="form-group">
		<input type="submit" value="Login" name="submit" class="btn btn-block btn-primary">
		</div>
		
		</fieldset>
	</form>
</div>

</body>

</html>
