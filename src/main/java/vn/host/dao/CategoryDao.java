package vn.host.dao;
import java.util.List;
import vn.host.model.Category;
public interface CategoryDao {
	void insert(Category c);                    
    void update(Category c);                    
    boolean delete(int categoryId, int userId);       

    Category getById(int categoryId, int userId);
    List<Category> getAllByUser(int userId);
    List<Category> searchByName(int userId, String keyword);
}
