package vn.host.service.impl;

import java.util.List;
import vn.host.dao.CategoryDao;
import vn.host.dao.impl.CategoryDaoImpl;
import vn.host.model.Category;
import vn.host.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
 private final CategoryDao dao = new CategoryDaoImpl();

 @Override public void add(Category c) { dao.insert(c); }
 @Override public void update(Category c) { dao.update(c); }
 @Override public boolean delete(int categoryId, int userId) { return dao.delete(categoryId, userId); }

 @Override public Category get(int categoryId, int userId) { return dao.getById(categoryId, userId); }
 @Override public List<Category> listByUser(int userId) { return dao.getAllByUser(userId); }
 @Override public List<Category> searchByName(int userId, String keyword) { return dao.searchByName(userId, keyword); }
}
