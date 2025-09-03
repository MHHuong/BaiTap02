package vn.host.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.host.model.Category;
import vn.host.service.CategoryService;
import vn.host.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = "/admin/category/edit")
public class CategoryEditController extends HttpServlet {
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

		int id = Integer.parseInt(req.getParameter("id"));
		Category c = service.get(id, account.getId());
		if (c == null) {
			resp.sendError(404);
			return;
		}
		req.setAttribute("category", c);
		req.getRequestDispatcher("/views/admin/edit-category.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		vn.host.model.User account = (vn.host.model.User) req.getSession().getAttribute("account");
		if (account == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		req.setCharacterEncoding("UTF-8");
		Category c = new Category();
		c.setCategoryid(Integer.parseInt(req.getParameter("id")));
		c.setCategoryname(req.getParameter("name"));
		c.setImages(req.getParameter("images"));
		c.setStatus(Integer.parseInt(req.getParameter("status")));
		c.setUserid(account.getId());
		service.update(c);
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}
}
