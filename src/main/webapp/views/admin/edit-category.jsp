<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<form action="${pageContext.request.contextPath}/admin/category/edit"
	method="post">
	<input type="hidden" name="id" value="${category.categoryid}" /> <label>Tên:</label><input
		name="name" value="${category.categoryname}" required /> <label>Ảnh:</label>
	<c:if test="${not empty category.images}">
		<img
			src="${pageContext.request.contextPath}/image?fname=${category.images}"
			width="120" />
	</c:if>
	<input name="images" value="${category.images}" /> <label>Trạng
		thái:</label> <select name="status">
		<option value="1" ${category.status==1?'selected':''}>Hoạt
			động</option>
		<option value="0" ${category.status==0?'selected':''}>Khóa</option>
	</select>
	<button type="submit">Lưu</button>
</form>
