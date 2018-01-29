/*package com.java.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.model.vo.User;

public class UserDAO {

	private static String url = "jdbc:oracle:thin:@70.12.110.62:1521:XE";
	private static String userName = "twotwo";
	private static String password = "twotwo";

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


		public ArrayList<User> selectall() {
		ArrayList<User> list = new ArrayList<User>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select* from finditem ";

		try {
			conn = DriverManager.getConnection(url, userName, password);
			stmt = conn.prepareStatement(sql);
			//stmt.setString(1, memid);
			rs = stmt.executeQuery();
			while (rs.next()) { // 다음 레코드로 넘어가는 반복문, 레코드가 더이상 없을떄까지 반복
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}


}*/