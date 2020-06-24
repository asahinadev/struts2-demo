<!DOCTYPE html>
<html class="h-100">

<%@ page contentType="text/html; charset=UTF-8"%>
<%!String url(HttpServletRequest req, HttpServletResponse res, String url) {
		return req.getContextPath() + res.encodeURL(url);
	}%>

<head>

<meta charset="utf-8">
<title>ログイン</title>

<link rel="stylesheet" href="<%=url(request, response, "/bootstrap/css/bootstrap.min.css")%>">
<link rel="stylesheet" href="<%=url(request, response, "/css/form.css")%>">

<script src="<%=url(request, response, "/bootstrap/js/bootstrap.min.js")%>"></script>

</head>

<body class="h-100">
	
	<nav class="navbar navbar-dark bg-primary fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">ログイン</a>
		</div>
	</nav>
	
	<div class="container mt-5 ">

		<form method="post" action='j_security_check' class="card mx-auto" id="form-card">
			<fieldset class="card-body">

				<div class="mb-3">
					<label class="form-label" for="j_username">アカウント</label>
					<input type="text"  name="j_username" class="form-control" id="j_username">
				</div>

				<div class="mb-3">
					<label class="form-label"for="j_password">パスワード</label>
					<div class="col">
						<input type="password" name="j_password" class="form-control" id="j_password">
					</div>
				</div>

				<div class="mb-3">
					<input type="submit" value="Login" name="submit" class="btn btn-block btn-primary">
				</div>

			</fieldset>
		</form>
	</div>

</body>

</html>
