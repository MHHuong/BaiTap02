<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>My Account</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="account-container">
    <h2>Thông tin tài khoản</h2>

    <!-- Nếu user đã đăng nhập -->
    <c:if test="${not empty sessionScope.account}">
        <div class="profile">
            <img src="${pageContext.request.contextPath}/assets/images/${sessionScope.account.avatar}" alt="Avatar">
            <div>
                <h3>${sessionScope.account.fullName}</h3>
                <p>@${sessionScope.account.username}</p>
            </div>
        </div>

        <table class="account-table">
            <tr>
                <td class="label">Email:</td>
                <td>${sessionScope.account.email}</td>
            </tr>
            <tr>
                <td class="label">Số điện thoại:</td>
                <td>${sessionScope.account.phone}</td>
            </tr>
            <tr>
                <td class="label">Quyền:</td>
                <td>
                    <c:choose>
                        <c:when test="${sessionScope.account.roleid == 1}">Quản trị viên</c:when>
                        <c:when test="${sessionScope.account.roleid == 2}">Quản lý</c:when>
                        <c:otherwise>Người dùng</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td class="label">Ngày tạo:</td>
                <td>${sessionScope.account.createdDate}</td>
            </tr>
        </table>
    </c:if>

    <!-- Nếu chưa đăng nhập -->
    <c:if test="${empty sessionScope.account}">
        <p>Bạn chưa đăng nhập. 
            <a href="${pageContext.request.contextPath}/login">Đăng nhập ngay</a>
        </p>
    </c:if>
</div>
</body>
</html>
