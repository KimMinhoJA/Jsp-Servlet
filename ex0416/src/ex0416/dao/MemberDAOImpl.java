package ex0416.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex0416.domain.Member;
import ex0416.util.DbUtil;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int insert(Member member) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,SYSDATE)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPwd());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getAddr());
			result = pstmt.executeUpdate();
		}finally {
			DbUtil.dbClose(con, pstmt);
		}
		return result;
	}

	@Override
	public boolean idCheck(String id) throws SQLException {
		if(selectById(id) == null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public List<Member> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		
		try {
			con = DbUtil.getConnection();
			String sql = "SELECT ID, NAME, PWD, AGE, PHONE, ADDR, JOIN_DATE FROM MEMBER";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member(rs.getString("ID"), rs.getString("NAME"), rs.getString("PWD"), rs.getInt("AGE"), rs.getString("PHONE"), rs.getString("ADDR"),
						rs.getString("JOIN_DATE"));
				list.add(member);
			}
			
		}finally {
			DbUtil.dbClose(con, pstmt, rs);
		}
		return list;
	}

	@Override
	public Member selectById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			con = DbUtil.getConnection();
			String sql = "SELECT ID, NAME, PWD, AGE, PHONE, ADDR, JOIN_DATE FROM MEMBER WHERE ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member(rs.getString("ID"), rs.getString("NAME"), rs.getString("PWD"), rs.getInt("AGE"), rs.getString("PHONE"), rs.getString("ADDR"),
						rs.getString("JOIN_DATE"));
			}
		}finally {
			DbUtil.dbClose(con, pstmt, rs);
		}
		return member;
	}

	@Override
	public List<Member> searchByKeyword(String keyField, String keyword) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try {
			con = DbUtil.getConnection();
			String sql = "SELECT ID, NAME, PWD, AGE, PHONE, ADDR, JOIN_DATE FROM MEMBER WHERE " + keyField + " LIKE ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ("%" + keyword + "%"));
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Member member = new Member(rs.getString("ID"), rs.getString("NAME"), rs.getString("PWD"), rs.getInt("AGE"), rs.getString("PHONE"), rs.getString("ADDR"),
						rs.getString("JOIN_DATE"));
				list.add(member);
			}
		}finally {
			DbUtil.dbClose(con, pstmt, rs);
		}
		return list;
	}

	@Override
	public int delete(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			String sql = "DELETE MEMBER WHERE ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		}finally {
			DbUtil.dbClose(con, pstmt);
		}
		return result;
	}

}
