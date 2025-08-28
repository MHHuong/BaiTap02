<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Đăng Nhập Vào Hệ Thống</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div class="login-box">
		<h2>Đăng Nhập Vào Hệ Thống</h2>
		<c:if test="${not empty alert}">
			<div style="color: red; margin-bottom: 10px;">${alert}</div>
		</c:if>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<div class="input-group">
				<span>👤</span> <input type="text" name="username"
					placeholder="Tên đăng nhập" required>
			</div>
			<div class="input-group">
				<span>🔒</span> <input type="password" name="password"
					placeholder="Mật khẩu" required>
			</div>
			<div class="options">
				<label><input type="checkbox" name="remember"> Nhớ
					tôi</label> <a href="#">Quên mật khẩu?</a>
			</div>
			<button type="submit" class="btn">Đăng nhập</button>
		</form>
		<div class="register">
			Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <a
				href="${pageContext.request.contextPath}/register">Đăng ký</a>
		</div>
	</div>
</body>
</html>
