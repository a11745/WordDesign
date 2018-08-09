package com.home.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.home.dao.WordDao;
import com.home.domain.User;
import com.home.domain.Words;
import com.home.utils.DBUtil;

public class WordDaoImpl implements WordDao {

	@Override
	public int addWord(String wordName, String quality,Integer userid,String chinese) {
		Connection conn = DBUtil.getConnection();
		String sql ="INSERT INTO words(wordname,quality,state,userid,chinese) VALUES(?,?,?,?,?)";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Words words = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, wordName);
			pst.setString(2, quality);
			pst.setInt(3, 0);
			pst.setInt(4, userid);
			pst.setString(5, chinese);
			//rs = pst.executeQuery();
			int i = pst.executeUpdate();
			return i;
			/*if(rs.next()){
				int id= rs.getInt(1);
				String newwordName = rs.getString(2);
				String newquality = rs.getString(3);
				int newstate = rs.getInt(4);
				int newuserid = rs.getInt(5);
				words = new Words();
				words.setId(id);
				words.setWordname(newwordName);
				words.setQuality(newquality);
				words.setState(newstate);
				words.setUserid(newuserid);
			}*/
			
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

	@Override
	public List<Words> achieve(Integer userid,Integer state) {
		Connection conn = DBUtil.getConnection();
		String sql ="SELECT * FROM words WHERE userid=? AND state = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Words words = null;
		List<Words> wordsList = new ArrayList<>();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userid);
			pst.setInt(2, state);
			rs = pst.executeQuery();
			while(rs.next()){
				int id= rs.getInt(1);
				String newwordName = rs.getString(2);
				String newquality = rs.getString(3);
				int newstate = rs.getInt(4);
				int newuserid = rs.getInt(5);
				String newchinese = rs.getString(6);
				words = new Words();
				words.setId(id);
				words.setWordname(newwordName);
				words.setQuality(newquality);
				words.setState(newstate);
				words.setUserid(newuserid);
				words.setChinese(newchinese);
				wordsList.add(words);
				System.out.println(newwordName);
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
		
		return wordsList;
	}

	@Override
	public int editWord(Integer id,String wordName, String quality, Integer userid, String chinese) {
		Connection conn = DBUtil.getConnection();
		String sql ="UPDATE words SET wordname=?,quality=?,chinese=? WHERE id=? AND userid = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Words words = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, wordName);
			pst.setString(2, quality);
			pst.setString(3, chinese);
			pst.setInt(4, id);
			pst.setInt(5, userid);
			//rs = pst.executeQuery();
			int i = pst.executeUpdate();
			return i;
			/*if(rs.next()){
				int id= rs.getInt(1);
				String newwordName = rs.getString(2);
				String newquality = rs.getString(3);
				int newstate = rs.getInt(4);
				int newuserid = rs.getInt(5);
				words = new Words();
				words.setId(id);
				words.setWordname(newwordName);
				words.setQuality(newquality);
				words.setState(newstate);
				words.setUserid(newuserid);
			}*/
			
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

	@Override
	public int delWord(Integer id, Integer userid) {
		Connection conn = DBUtil.getConnection();
		String sql ="DELETE FROM words WHERE id = ? AND userid = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Words words = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setInt(2, userid);
			//rs = pst.executeQuery();
			int i = pst.executeUpdate();
			return i;
			/*if(rs.next()){
				int id= rs.getInt(1);
				String newwordName = rs.getString(2);
				String newquality = rs.getString(3);
				int newstate = rs.getInt(4);
				int newuserid = rs.getInt(5);
				words = new Words();
				words.setId(id);
				words.setWordname(newwordName);
				words.setQuality(newquality);
				words.setState(newstate);
				words.setUserid(newuserid);
			}*/
			
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

	@Override
	public List<Words> studyWord(Integer id, String wordName, String quality, Integer userid, String chinese) {
		Connection conn = DBUtil.getConnection();
		String sql ="SELECT * FROM words WHERE wordname=? AND id=? AND userid = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Words words = null;
		List<Words> wordsList = new ArrayList<>();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, wordName);
			pst.setInt(2, id);
			pst.setInt(3, userid);
			rs = pst.executeQuery();
			//int i = pst.executeUpdate();
			//return i;
			while(rs.next()){
				int newid= rs.getInt(1);
				String newwordName = rs.getString(2);
				String newquality = rs.getString(3);
				int newstate = rs.getInt(4);
				int newuserid = rs.getInt(5);
				String newchinese = rs.getString(6);
				words = new Words();
				words.setId(newid);
				words.setWordname(newwordName);
				words.setQuality(newquality);
				words.setState(newstate);
				words.setUserid(newuserid);
				words.setChinese(newchinese);
				wordsList.add(words);
				System.out.println(newwordName);
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
		
		return wordsList;
	}

	@Override
	public int okWord(Integer id, Integer userid) {
		Connection conn = DBUtil.getConnection();
		String sql ="UPDATE words SET state=1 WHERE id = ? AND userid = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Words words = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setInt(2, userid);
			//rs = pst.executeQuery();
			int i = pst.executeUpdate();
			return i;
			/*if(rs.next()){
				int id= rs.getInt(1);
				String newwordName = rs.getString(2);
				String newquality = rs.getString(3);
				int newstate = rs.getInt(4);
				int newuserid = rs.getInt(5);
				words = new Words();
				words.setId(id);
				words.setWordname(newwordName);
				words.setQuality(newquality);
				words.setState(newstate);
				words.setUserid(newuserid);
			}*/
			
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
