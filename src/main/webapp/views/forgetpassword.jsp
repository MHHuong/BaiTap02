<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Quên Mật Khẩu</title>
</head>
<body>
	<h2>Quên Mật Khẩu</h2>
	<form action="${pageContext.request.contextPath}/forgetpassword"
		method="post">
		<label>Email:</label> <input type="email" name="email" required />
		<button type="submit">Gửi</button>
	</form>

	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<p style="color: red;"><%=message%></p>
	<%
	}
	%>
</body>
</html>
