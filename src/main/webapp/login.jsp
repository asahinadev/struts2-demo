<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>

<meta charset="utf-8">

</head>

<body>
	<form method="post" action='<%=response.encodeURL("j_security_check")%>'>
		<table>
			<tr>
				<td>アカウント</td>
				<td>
					<input type="text" name="j_username">
				</td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td>
					<input type="password" name="j_password">
				</td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Login" name="submit">
		<input type="reset" value="Reset" name="reset">
	</form>
</body>

</html>
