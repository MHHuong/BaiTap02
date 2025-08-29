package vn.host.controller;

import vn.host.constant.Constant;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/verifyotp")
public class VerifyOTPController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String otpInput = request.getParameter("otp");
        HttpSession session = request.getSession();

        String otp = (String) session.getAttribute(Constant.SESSION_OTP);
        Long otpTime = (Long) session.getAttribute(Constant.SESSION_OTP_TIME);

        if (otp != null && otpInput.equals(otp)) {
            long now = System.currentTimeMillis();
            if (otpTime != null && (now - otpTime) <= 2 * 60 * 1000) {
                response.sendRedirect(request.getContextPath() + Constant.RESET_PASSWORD);
                return;
            } else {
                request.setAttribute("message", "OTP đã hết hạn!");
            }
        } else {
            request.setAttribute("message", "OTP không hợp lệ!");
        }

        request.getRequestDispatcher(Constant.VERIFY_OTP).forward(request, response);
    }
}

