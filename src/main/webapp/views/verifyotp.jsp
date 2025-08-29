<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Verify OTP</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
	<div class="container">
		<h2>Nhập OTP</h2>
		<form action="${pageContext.request.contextPath}/verifyotp"
			method="post">
			<label>OTP:</label> <input type="text" name="otp" required />
			<button type="submit">Xác nhận</button>
		</form>
		<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
		%>
		<p style="color: red;"><%=message%></p>
		<%
		}
		%>

	</div>
</body>
</html>