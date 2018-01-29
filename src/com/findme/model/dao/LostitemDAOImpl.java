package com.findme.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.findme.model.vo.Lostitem;
import com.findme.util.DBUtil;

public class LostitemDAOImpl implements LostitemDAO{

	ArrayList<Lostitem> lostitems = new ArrayList<Lostitem>();
	@Override
	public int writeLostitem(Lostitem lostitem) {
		
		
		
			Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "insert into lostitem values(lid_seq.nextval,?,?,?,?,?,sysdate,0,?)";
			
			try {
				
				conn = DBUtil.getConnection();
				stmt = conn.prepareStatement(sql);
				ResultSet rs = null;
				
				stmt.setString(1, lostitem.getlDate());
				stmt.setString(2, lostitem.getlAddress());
				stmt.setString(3, lostitem.getlContent());
				stmt.setString(4, lostitem.getlPicture());
				stmt.setString(5, lostitem.getlHashtag());
				/*stmt.setInt(6, lostitem.getlDone());*/
				
				stmt.setString(6, lostitem.getWriter());
				/*return stmt.executeUpdate()>0;*/
				rs = stmt.executeQuery();
				
				while(rs.next()){
					lostitems.add(new Lostitem(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtil.close(stmt);
				DBUtil.close(conn);
			}	
			return 0;
			
	}
		
		
		
	

	@Override
	public int lostitemCountAll() {
		//select count(*) from lostitem;
		return 0;
	}

	@Override
	public ArrayList<Lostitem> getLostitemList() {
		for (Lostitem lostitem : lostitems) {
			System.out.println(lostitem);
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
