package com.findme.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.findme.model.vo.Finditem;
import com.findme.model.vo.Lostitem;
import com.findme.model.vo.Member;
import com.findme.util.DBUtil;

public class FinditemDAOImpl implements FinditemDAO {

	ArrayList<Finditem> finditems = new ArrayList<Finditem>();
	
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static PreparedStatement pstmt = null;

	@Override
	public boolean writeFinditem(Finditem finditem) {
		String sql = "insert into finditem values(fid_seq.nextval,?,?,?,?,?,sysdate,0,?)";

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, finditem.getfDate());
			pstmt.setString(2, finditem.getfAddress());
			pstmt.setString(3, finditem.getfContent());
			pstmt.setString(4, finditem.getfPicture());
			pstmt.setString(5, finditem.getfHashtag());
			pstmt.setString(6, finditem.getWriter());
			
			return pstmt.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

		return false;
	}

	@Override
	public int finditemCountAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Finditem> getFinditemList() {
		return null;
	}

	@Override
	public ArrayList<Finditem> getDoneFinditem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Finditem> getFinditemByAddress(String address) {
		String sql = "SELECT * FROM Finditem WHERE fAddress like '%'||?||'%'";

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, address);
			
			rs = pstmt.executeQuery();  //가로안에 sql 넣지 않는다!
			
			while(rs.next()){
				finditems.add(new Finditem(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8), rs.getString(9)));
			}
			
			return finditems;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

		return finditems;
	}

}
