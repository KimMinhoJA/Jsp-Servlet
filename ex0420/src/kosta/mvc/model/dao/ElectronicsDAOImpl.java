package kosta.mvc.model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.domain.Electronics;
import kosta.mvc.util.DbUtil;

public class ElectronicsDAOImpl implements ElectronicsDAO {
	Properties pro = new Properties();
	public ElectronicsDAOImpl() {
		//sqlQuery.properties파일 로딩하기
		InputStream input = getClass().getClassLoader().getResourceAsStream("kosta/mvc/model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Electronics> selectAll() throws SQLException {
		List<Electronics> list = new ArrayList<Electronics>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DbUtil.getConnection();
			String sql = pro.getProperty("list");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
			}
		}finally {
			DbUtil.dbClose(con, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public Electronics selectByModelNum(String modelNum) throws SQLException {
		Electronics electronics = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DbUtil.getConnection();
			String sql = "SELECT * FROM Electronics WHERE model_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modelNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				electronics = new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
			}
		}finally {
			DbUtil.dbClose(con, pstmt, rs);
		}
		return electronics;
	}

	@Override
	public int increamentByReadnum(String modelNum) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DbUtil.getConnection();
			String sql = "update Electronics set readnum = readnum + 1 where model_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modelNum);
			result = pstmt.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, pstmt);
		}
		return result;
	}

	@Override
	public int insert(Electronics electronics) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DbUtil.getConnection();
			String sql = "INSERT INTO electronics VALUES(?,?,?,?,?,SYSDATE,0,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, electronics.getModelNum());
			pstmt.setString(2, electronics.getModelName());	
			pstmt.setInt(3, electronics.getPrice());
			pstmt.setString(4, electronics.getDescription());
			pstmt.setString(5, electronics.getPassword());
			pstmt.setString(6, electronics.getFname());
			pstmt.setInt(7, electronics.getFsize());
			result = pstmt.executeUpdate();
		}finally {
			DbUtil.dbClose(con, pstmt);
		}
		return result;
	}

	@Override
	public int delete(String modelNum, String password) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DbUtil.getConnection();
			String sql = "DELETE electronics where model_num=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modelNum);
			pstmt.setString(2, password);
			result = pstmt.executeUpdate();
		}finally {
			DbUtil.dbClose(con, pstmt);
		}
		return result;
	}

	@Override
	public int update(Electronics electronics) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DbUtil.getConnection();
			String sql = "UPDATE electronics SET model_name = ?, price = ?, description = ? WHERE model_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, electronics.getModelName());
			pstmt.setInt(2, electronics.getPrice());
			pstmt.setString(3, electronics.getDescription());
			pstmt.setString(4, electronics.getModelNum());
			result = pstmt.executeUpdate();
		}finally {
			DbUtil.dbClose(con, pstmt);
		}
		return result;
	}

}
