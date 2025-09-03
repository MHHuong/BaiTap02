package vn.host.service;

import java.util.List;
import vn.host.model.Category;

public interface CategoryService {
	void add(Category c);

	void update(Category c);

	boolean delete(int categoryId, int userId);

	Category get(int categoryId, int userId);

	List<Category> listByUser(int userId);

	List<Category> searchByName(int userId, String keyword);
}
