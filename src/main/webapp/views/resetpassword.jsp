<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <title>Đặt lại mật khẩu mới</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h2>Đặt lại mật khẩu mới</h2>
        <form action="${pageContext.request.contextPath}/ResetPasswordController" method="post">
            <label>Mật khẩu mới:</label>
            <input type="password" name="newpassword" placeholder="Nhập mật khẩu mới" required />

            <label>Xác nhận mật khẩu mới:</label>
            <input type="password" name="confirmpassword" placeholder="Nhập lại mật khẩu mới" required />

            <button type="submit">Cập nhật mật khẩu</button>
        </form>

        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
            <div class="message"><%=message%></div>
        <%
            }
        %>
    </div>
</body>
</html>
