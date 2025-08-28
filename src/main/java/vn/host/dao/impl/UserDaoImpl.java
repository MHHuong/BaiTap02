package vn.host.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.host.connection.DBConnect;
import vn.host.dao.UserDao;
import vn.host.model.User;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public User get(String username) {
		String sql = "SELECT * FROM [User] WHERE username = ? ";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
			    User user = new User();
			    user.setId(rs.getInt("id"));
			    user.setEmail(rs.getString("email"));
			    user.setUsername(rs.getString("username"));  
			    user.setFullName(rs.getString("fullname"));   
			    user.setPassword(rs.getString("password"));  
			    user.setAvatar(rs.getString("avatar"));
			    user.setRoleid(rs.getInt("roleid"));
			    user.setPhone(rs.getString("phone"));
			    user.setCreatedDate(rs.getDate("createdDate"));
			   
			    return user;
			}		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
