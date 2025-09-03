package vn.host.dao.impl;

import vn.host.dao.CategoryDao;
import vn.host.model.Category;
import vn.host.connection.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

	private final DBConnect db;

	public CategoryDaoImpl() {
		this.db = new DBConnect();
	}

	@Override
	public void insert(Category c) {
		String sql = "INSERT INTO dbo.Category(categoryname, images, status, userid) VALUES(?,?,?,?)";
		try (Connection con = db.getConnection();
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, c.getCategoryname());
			ps.setString(2, c.getImages());
			ps.setInt(3, c.getStatus());
			ps.setInt(4, c.getUserid());
			ps.executeUpdate();

			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next())
					c.setCategoryid(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Category c) {
		String sql = "UPDATE dbo.Category SET categoryname=?, images=?, status=? WHERE categoryid=? AND userid=?";
		try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, c.getCategoryname());
			ps.setString(2, c.getImages());
			ps.setInt(3, c.getStatus());
			ps.setInt(4, c.getCategoryid());
			ps.setInt(5, c.getUserid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean delete(int categoryId, int userId) {
		String sql = "DELETE FROM dbo.Category WHERE categoryid=? AND userid=?";
		try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, categoryId);
			ps.setInt(2, userId);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Category getById(int categoryId, int userId) {
		String sql = "SELECT categoryid, categoryname, images, status, userid "
				+ "FROM dbo.Category WHERE categoryid=? AND userid=?";
		try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, categoryId);
			ps.setInt(2, userId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Category c = new Category();
					c.setCategoryid(rs.getInt("categoryid"));
					c.setCategoryname(rs.getString("categoryname"));
					c.setImages(rs.getString("images"));
					c.setStatus(rs.getInt("status"));
					c.setUserid(rs.getInt("userid"));
					return c;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> getAllByUser(int userId) {
		List<Category> list = new ArrayList<>();
		String sql = "SELECT categoryid, categoryname, images, status, userid "
				+ "FROM dbo.Category WHERE userid=? ORDER BY categoryid DESC";
		try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, userId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Category c = new Category();
					c.setCategoryid(rs.getInt("categoryid"));
					c.setCategoryname(rs.getString("categoryname"));
					c.setImages(rs.getString("images"));
					c.setStatus(rs.getInt("status"));
					c.setUserid(rs.getInt("userid"));
					list.add(c);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Category> searchByName(int userId, String keyword) {
		List<Category> list = new ArrayList<>();
		String sql = "SELECT categoryid, categoryname, images, status, userid "
				+ "FROM dbo.Category WHERE userid=? AND categoryname LIKE ?";
		try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ps.setString(2, "%" + keyword + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Category c = new Category();
					c.setCategoryid(rs.getInt("categoryid"));
					c.setCategoryname(rs.getString("categoryname"));
					c.setImages(rs.getString("images"));
					c.setStatus(rs.getInt("status"));
					c.setUserid(rs.getInt("userid"));
					list.add(c);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
