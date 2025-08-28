<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Trang Người Dùng</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div class="account-container">
		<h2>Chào mừng ${sessionScope.account.fullName}!</h2>
		<p>Bạn đã đăng nhập thành công vào hệ thống.</p>
		<table class="account-table">
			<tr>
				<td class="label">Tên đăng nhập:</td>
				<td>${sessionScope.account.username}</td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td>${sessionScope.account.email}</td>
			</tr>
			<tr>
				<td class="label">Số điện thoại:</td>
				<td>${sessionScope.account.phone}</td>
			</tr>
		</table>
	</div>
</body>
</html>
