package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ElectronicsDAO;
import kosta.mvc.model.dao.ElectronicsDAOImpl;
import kosta.mvc.model.domain.Electronics;

public class ElectronicsService {

	private static ElectronicsDAO elecDAO  = new ElectronicsDAOImpl();
	/**
	* ElectronicsDAOImpl�� ��緹�ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 * @throws SQLException 
	* */
	public static List<Electronics> selecAll() throws SQLException{
		return elecDAO.selectAll();
	}
	
	/**
	* ElectronicsDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
	* */
	public static void insert(Electronics electronics)throws SQLException{
		int result = elecDAO.insert(electronics);
		if(result == 0) throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
	}
			
	/**
	* ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻��ϴ� �޼ҵ� ȣ��
	* @param : boolean flag - ��ȸ�� ���� ���θ� �Ǻ��ϴ� �Ű�������(true�̸� ��ȸ������ / false�̸� ��ȸ�� ���� ����)
	* */
	public static Electronics selectByModelNum(String modelNum) throws SQLException{
		Electronics electronics = null;
		if(elecDAO.increamentByReadnum(modelNum) != 0) {
			electronics = elecDAO.selectByModelNum(modelNum);
		}
		return electronics;
	}
	//�۹�ȣ�� �ش��ϴ� �Խù� �˻�
	
	
	/**
	* ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	* */
	public static void delete(String modelNum, String password) throws SQLException{
		int result = elecDAO.delete(modelNum, password);
		if(result == 0) throw new SQLException("�������� �ʾҽ��ϴ�.");
	}
	/**
	* ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����  �޼ҵ� ȣ��
	* */
	public static void update(Electronics electronics) throws SQLException{
		int result = elecDAO.update(electronics);
		if(result == 0) throw new SQLException("�������� �ʾҽ��ϴ�.");
	}
}



