<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<c:forEach var="c" items="${cateList}" varStatus="st">
	<tr>
		<td>${st.index + 1}</td>
		<td><c:if test="${not empty c.images}">
				<img
					src="${pageContext.request.contextPath}/image?fname=${c.images}"
					width="120" />
			</c:if></td>
		<td>${c.categoryname}</td>
		<td>${c.status}</td>
		<td><a
			href="${pageContext.request.contextPath}/admin/category/edit?id=${c.categoryid}">Sửa</a>
			| <a
			href="${pageContext.request.contextPath}/admin/category/delete?id=${c.categoryid}"
			onclick="return confirm('Xóa?')">Xóa</a></td>
	</tr>
</c:forEach>
