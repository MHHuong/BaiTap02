<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/views/style.css">
</head>
<body>

    <jsp:include page="/views/topbar.jsp" />

    <h1>Chào mừng đến với Trang chủ!</h1>

    <c:choose>
        <c:when test="${sessionScope.account != null}">
            <p>Xin chào, <b>${sessionScope.account.fullName}</b> 🎉</p>
        </c:when>
        <c:otherwise>
            <p>Bạn chưa đăng nhập. Vui lòng 
               <a href="${pageContext.request.contextPath }/login">Đăng nhập</a>.
            </p>
        </c:otherwise>
    </c:choose>

</body>
</html>
