<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div class="topbar">
    <div class="container">
        <c:choose>
            <c:when test="${sessionScope.account == null}">
                <ul class="right-topbar">
                    <li><a href="${pageContext.request.contextPath }/login">Đăng nhập</a></li>
                    <li><a href="${pageContext.request.contextPath }/register">Đăng ký</a></li>
                    <li><i class="fa fa-search search-button"></i></li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="right-topbar">
                    <li><a href="${pageContext.request.contextPath }/member/myaccount">
                        ${sessionScope.account.fullName}</a></li>
                    <li><a href="${pageContext.request.contextPath }/logout">Đăng Xuất</a></li>
                    <li><i class="fa fa-search search-button"></i></li>
                </ul>
            </c:otherwise>
        </c:choose>
    </div>
</div>
