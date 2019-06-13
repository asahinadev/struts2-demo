<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title><s:text name="hello.message" /></title>
</head>

<body>

	<s:iterator value="%{users}">
		<div>
			<s:property value="%{username}" />
		</div>
	</s:iterator>

</body>
</html>
