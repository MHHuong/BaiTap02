<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Quên Mật Khẩu</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h2>Quên Mật Khẩu</h2>
        <form action="${pageContext.request.contextPath}/forgetpassword" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="Nhập email của bạn" required />
            </div>
            <button type="submit">Gửi</button>
        </form>

        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
            <p class="message"><%=message%></p>
        <%
            }
        %>
    </div>
</body>
</html>
