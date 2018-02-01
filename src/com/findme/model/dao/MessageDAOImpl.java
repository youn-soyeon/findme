package com.findme.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.findme.model.vo.Message;
import com.findme.util.DBUtil;

public class MessageDAOImpl implements MessageDAO {

	@Override
	public int sendMessmage(Message message) {

		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "insert into message values(fid_seq.nextval,?,?,sysdate,0,0,?,?)";

		try {

			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, message.getReceiver());
			stmt.setString(2, message.getMsgContent());
			stmt.setString(3, message.getSender());
			stmt.setString(4, message.getMsgTitle());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}

		return 0;
	}

	@Override
	public ArrayList<Message> getMsgListBySender(String sender) {

		ArrayList<Message> messageList = new ArrayList<Message>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM Message WHERE memid = ? ";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, sender);
			rs = stmt.executeQuery();
			while (rs.next()) { // 다음 레코드로 넘어가는 반복문, 레코드가 더이상 없을떄까지 반복
				messageList.add(new Message(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8)));

			}
			return messageList;

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

		return null;

	}

	@Override
	public ArrayList<Message> getMsgListByReceiver(String receiver) {

		ArrayList<Message> messageList = new ArrayList<Message>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM Message WHERE receiver = ? ";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, receiver);
			rs = stmt.executeQuery();
			while (rs.next()) { // 다음 레코드로 넘어가는 반복문, 레코드가 더이상 없을떄까지 반복
				messageList.add(new Message(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8)));
			}
			return messageList;

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

		return null;
	}

	@Override
	public int delete(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

}