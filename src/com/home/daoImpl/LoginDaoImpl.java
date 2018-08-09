package com.home.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.home.dao.LoginDao;
import com.home.domain.User;
import com.home.utils.DBUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public User login(String name,String pass) {
		Connection conn = DBUtil.getConnection();
		String sql ="SELECT * FROM USER WHERE username=? AND PASSWORD=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			if(rs.next()){
				int id= rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				int state = rs.getInt(4);
				user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				user.setState(state);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return user;
	}

	@Override
	public User register(String name, String pass) {
		Connection conn = DBUtil.getConnection();
		String sql ="SELECT * FROM USER WHERE username=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			if(rs.next()){
				int id= rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				int state = rs.getInt(4);
				user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				user.setState(state);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return user;
	}

	@Override
	public int registerss(String name, String pass) {
		Connection conn = DBUtil.getConnection();
		String sql ="INSERT INTO USER(username,PASSWORD,state) VALUES(?,?,0)";
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pass);
			int i = pst.executeUpdate();
			return i;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return 0;
	}
}
