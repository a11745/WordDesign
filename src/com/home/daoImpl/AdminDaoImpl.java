package com.home.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.home.domain.Admin;
import com.home.domain.ReUserlog;
import com.home.domain.User;
import com.home.domain.Words;
import com.home.utils.DBUtil;

public class AdminDaoImpl {
	public Admin login(String name,String pass) {
		Connection conn = DBUtil.getConnection();
		String sql ="SELECT * FROM ADMIN WHERE name=? AND pwd=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Admin admin = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			if(rs.next()){
				int id= rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				int role = rs.getInt(4);
				admin = new Admin();
				admin.setId(id);
				admin.setName(username);
				admin.setPwd(password);
				admin.setRole(role);
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
		
		return admin;
	}
	public List<ReUserlog> reUserlogList() {
		Connection conn = DBUtil.getConnection();
		String sql ="SELECT l.id,l.ip,u.`username`,l.addtime FROM userlog l,USER u WHERE l.`userId`=u.`id`";
		PreparedStatement pst = null;
		ResultSet rs = null;
		ReUserlog reUserlog= null;
		List<ReUserlog> logList = new ArrayList<>();
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id= rs.getInt(1);
				String ip = rs.getString(2);
				String username = rs.getString(3);
				Date addtime = rs.getDate(4);
				
				reUserlog = new ReUserlog();
				reUserlog.setId(id);
				reUserlog.setIp(ip);
				reUserlog.setUsername(username);
				reUserlog.setAddtime(addtime);
				logList.add(reUserlog);
				System.out.println(username);
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
		
		return logList;
	}
	public int userlogLogin(Integer userId,String ip,Date addtime) {
		Connection conn = DBUtil.getConnection();
		String sql ="INSERT INTO userlog(ip,userId,addtime) VALUES(?,?,?)";
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, ip);
			pst.setInt(2, userId);
			pst.setDate(3, addtime);
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
