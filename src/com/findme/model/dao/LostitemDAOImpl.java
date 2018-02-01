package com.findme.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.findme.model.vo.Lostitem;
import com.findme.util.DBUtil;

public class LostitemDAOImpl implements LostitemDAO {

	@Override
	public int writeLostitem(Lostitem lostitem) {
		ArrayList<Lostitem> lostitems = new ArrayList<Lostitem>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into lostitem values(lid_seq.nextval,?,?,?,?,?,sysdate,0,?)";

		try {

			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, lostitem.getlDate());
			pstmt.setString(2, lostitem.getlAddress());
			pstmt.setString(3, lostitem.getlContent());
			pstmt.setString(4, lostitem.getlPicture());
			pstmt.setString(5, lostitem.getlHashtag());
			/* stmt.setInt(6, lostitem.getlDone()); */

			pstmt.setString(6, lostitem.getWriter());

			return pstmt.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return 0;

	}

	@Override
	public int lostitemCountAll() {
		// select count(*) from lostitem;
		return 0;
	}

	@Override
	public ArrayList<Lostitem> getLostitemList() {
		ArrayList<Lostitem> lostitems = new ArrayList<Lostitem>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Lostitem WHERE lDone = 0";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				lostitems.add(new Lostitem(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
			}

			return lostitems;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

		return null;

	}

	@Override
	public ArrayList<Lostitem> getDoneLostitem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Lostitem> getLostitemByAddress(String Address) {
		// TODO Auto-generated method stub
		return null;
	}

}
