package vn.host.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.host.model.Category;
import vn.host.service.CategoryService;
import vn.host.service.impl.CategoryServiceImpl;
@WebServlet(urlPatterns = "/admin/category/list")

public class CategoryListController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final CategoryService service = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		vn.host.model.User account = (vn.host.model.User) req.getSession().getAttribute("account");
		if (account == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		List<Category> list = service.listByUser(account.getId());
		req.setAttribute("cateList", list);
		req.getRequestDispatcher("/views/admin/list-category.jsp").forward(req, resp);
	}
}
