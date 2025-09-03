package vn.host.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.host.service.CategoryService;
import vn.host.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = "/admin/category/delete")
public class CategoryDeleteController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final CategoryService service = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		vn.host.model.User account = (vn.host.model.User) req.getSession().getAttribute("account");
		if (account == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		int id = Integer.parseInt(req.getParameter("id"));
		service.delete(id, account.getId());
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}
}
