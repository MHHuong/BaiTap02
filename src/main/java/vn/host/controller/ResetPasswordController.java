package vn.host.controller;

import vn.host.connection.DBConnect;
import vn.host.constant.Constant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ResetPasswordController")
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newPassword = request.getParameter("newpassword");
		String confirmPassword = request.getParameter("confirmpassword");

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute(Constant.SESSION_EMAIL_RESET);

		if (newPassword == null || confirmPassword == null || !newPassword.equals(confirmPassword)) {
			request.setAttribute("message", "Mật khẩu không khớp!");
			request.getRequestDispatcher(Constant.RESET_PASSWORD).forward(request, response);
			return;
		}

		try (Connection conn = new DBConnect().getConnection()) {
			String sql = "UPDATE [User] SET password=? WHERE email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword); // thực tế nên mã hoá mật khẩu (BCrypt, SHA-256, ...)
			ps.setString(2, email);

			int rows = ps.executeUpdate();

			if (rows > 0) {
			    session.removeAttribute(Constant.SESSION_EMAIL_RESET);
			    session.removeAttribute(Constant.SESSION_OTP);
			    session.removeAttribute(Constant.SESSION_OTP_TIME);

			    session.setAttribute("message", "Đổi mật khẩu thành công! Vui lòng đăng nhập.");
			    response.sendRedirect(request.getContextPath() + Constant.LOGIN);
			    return;
			} else {
				request.setAttribute("message", "Có lỗi xảy ra, vui lòng thử lại!");
				request.getRequestDispatcher(Constant.RESET_PASSWORD).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Lỗi hệ thống!");
			request.getRequestDispatcher(Constant.RESET_PASSWORD).forward(request, response);
		}
	}
}
