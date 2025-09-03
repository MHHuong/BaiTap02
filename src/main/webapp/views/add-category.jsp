<form action="${pageContext.request.contextPath}/admin/category/add"
	method="post">
	<label>Tên:</label><input name="name" required /> <label>Ảnh
		(filename hoặc upload):</label><input name="images" /> <label>Trạng
		thái:</label> <select name="status"><option value="1">Hoạt
			động</option>
		<option value="0">Khóa</option></select>
	<button type="submit">Thêm</button>
</form>
