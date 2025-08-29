package vn.host.controller;

import vn.host.connection.DBConnect;
import vn.host.constant.Constant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/forgetpassword")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Chỉ hiển thị trang nhập email
		request.getRequestDispatcher(Constant.FORGET_PASSWORD).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String message = null;

		try (Connection conn = new DBConnect().getConnection()) {
			String sql = "SELECT fullname FROM [User] WHERE email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String fullname = rs.getString("fullname");

				// OTP
				String otp = String.format("%06d", new Random().nextInt(999999));

				HttpSession session = request.getSession();
				session.setAttribute(Constant.SESSION_OTP, otp);
				session.setAttribute(Constant.SESSION_EMAIL_RESET, email);
				session.setAttribute(Constant.SESSION_OTP_TIME, System.currentTimeMillis());

				// Gửi email
				String subject = "OTP Khôi phục mật khẩu";
				String content = "Chào " + fullname + ",\nMã OTP của bạn là: " + otp;
				EmailUtilityController.sendEmail(email, subject, content);

				response.sendRedirect(request.getContextPath() + Constant.VERIFY_OTP);
				return;
			} else {
				message = "Email không tồn tại!";
			}

			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			message = "Lỗi gửi OTP hoặc kết nối DB!";
		}

		request.setAttribute("message", message);
		request.getRequestDispatcher(Constant.FORGET_PASSWORD).forward(request, response);
	}
}
