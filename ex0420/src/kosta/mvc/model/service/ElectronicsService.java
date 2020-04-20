package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ElectronicsDAO;
import kosta.mvc.model.dao.ElectronicsDAOImpl;
import kosta.mvc.model.domain.Electronics;

public class ElectronicsService {

	private static ElectronicsDAO elecDAO  = new ElectronicsDAOImpl();
	/**
	* ElectronicsDAOImpl의 모든레코드 검색하는 메소드 호출
	 * @throws SQLException 
	* */
	public static List<Electronics> selecAll() throws SQLException{
		return elecDAO.selectAll();
	}
	
	/**
	* ElectronicsDAOImpl의 레코드 삽입하는 메소드 호출
	* */
	public static void insert(Electronics electronics)throws SQLException{
		int result = elecDAO.insert(electronics);
		if(result == 0) throw new SQLException("등록되지 않았습니다.");
	}
			
	/**
	* ElectronicsDAOImpl의 모델번호에 해당하는 레코드 검색하는 메소드 호출
	* @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	* */
	public static Electronics selectByModelNum(String modelNum) throws SQLException{
		Electronics electronics = null;
		if(elecDAO.increamentByReadnum(modelNum) != 0) {
			electronics = elecDAO.selectByModelNum(modelNum);
		}
		return electronics;
	}
	//글번호에 해당하는 게시물 검색
	
	
	/**
	* ElectronicsDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
	* */
	public static void delete(String modelNum, String password) throws SQLException{
		int result = elecDAO.delete(modelNum, password);
		if(result == 0) throw new SQLException("삭제되지 않았습니다.");
	}
	/**
	* ElectronicsDAOImpl의 모델번호에 해당하는 레코드 수정  메소드 호출
	* */
	public static void update(Electronics electronics) throws SQLException{
		int result = elecDAO.update(electronics);
		if(result == 0) throw new SQLException("수정되지 않았습니다.");
	}
}



