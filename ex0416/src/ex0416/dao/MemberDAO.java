package ex0416.dao;

import java.sql.SQLException;
import java.util.List;

import ex0416.domain.Member;

/**
 * ȸ�������� �ʿ��� CRUD
 * @author kosta
 *
 */
public interface MemberDAO {
	/**
	 * ȸ�� ���
	 * insert into member(id, pwd, name, age, phone, addr, join_date)
	 * values(?, ?, ?, ?, ?, ?, sysdate)
	 */
	int insert (Member member) throws SQLException;
	
	/**
	 * id �ߺ� üũ
	 * @return : true�̸� �ߺ�, false�̸� �ߺ��ƴ�.
	 */
	boolean idCheck(String id) throws SQLException;
	
	/**
	 * ȸ�� ��ü �˻�
	 *  ��� ���ڵ尡 0�� �̻� ����.
	 */
	List<Member> selectAll() throws SQLException;
	
	/**
	 * id�� �ش��ϴ� ���ڵ� �˻�
	 * 	��� ���ڵ尡 0 or 1�̸� Member
	 */
	Member selectById(String id) throws SQLException;
	
	
	/**
	 * keyField�� �ش��ϴ�(�ʵ��) keyword�� ������ ���ڵ� �˻��ϱ�
	 */
	List<Member> searchByKeyword(String keyField, String keyword) throws SQLException;
	
	/**
	 * ȸ�� ����
	 */
	int delete(String id) throws SQLException;
}
