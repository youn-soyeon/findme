package com.findme.model.dao;

import java.sql.*;

import org.apache.catalina.Session;

import com.findme.model.vo.Member;
import com.findme.util.DBUtil;

public class MemberDAOImpl implements MemberDAO {

   private static Connection conn = null;
   private static ResultSet rs = null;
   private static PreparedStatement pstmt = null;

   @Override
   public boolean join(Member member) {
      String sql = "insert into member values (?, ?, 0)";

      try {
         conn = DBUtil.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, member.getMemId());
         pstmt.setString(2, member.getPassword());

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
   public Member searchMember(String memId) {
	   System.out.println("== MemberDAOImpl == login() 진입");
	      System.out.println("===== loginId : " + memId);

	      String sql = "select * from Member where memid=?";

	      try {
	         conn = DBUtil.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, memId);
	         rs = pstmt.executeQuery(); // 가로안에 sql 넣지 않는다!

	         if (rs.next()) {
	            return new Member(rs.getString(1), rs.getString(2), rs.getInt(3));
	         }

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         DBUtil.close(rs);
	         DBUtil.close(pstmt);
	         DBUtil.close(conn);
	      }
	      return null;
   }

   @Override
   public Member login(String memId, String password) {
      System.out.println("== MemberDAOImpl == login() 진입");
      System.out.println("===== loginId : " + memId);
      System.out.println("===== password : " + password);

      String sql = "select * from Member where memid=? and password=?";

      try {
         conn = DBUtil.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, memId);
         pstmt.setString(2, password);
         rs = pstmt.executeQuery(); // 가로안에 sql 넣지 않는다!

         if (rs.next()) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@");
            return new Member(rs.getString(1), rs.getString(2), rs.getInt(3));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBUtil.close(rs);
         DBUtil.close(pstmt);
         DBUtil.close(conn);
      }
      return null;
   }

   @Override
   public boolean update(Member member) {
      
      String sql = "update Member SET password = ? where memId = ?";
      try {
         
         
         conn = DBUtil.getConnection();
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, member.getPassword());
         pstmt.setString(2, member.getMemId());
         
         
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
   public int delete(String memId) {
      // TODO Auto-generated method stub
      return 0;
   }


}