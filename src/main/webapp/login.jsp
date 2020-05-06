<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html class="h-100">

<head>

<meta charset="utf-8">
<title>ログイン</title>

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
