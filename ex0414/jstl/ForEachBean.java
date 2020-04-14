package ex0414.jstl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachBean {
	private String[] names = {"��ȣ", "����", "����", "������", "����"};
	private List<String> menus = Arrays.asList(new String[] {"¥���", "«��", "������", "��ǳ��", "�Ⱥ�ä", "������"});
	private List<MemberDTO> memberList = new ArrayList<MemberDTO>();
	private Map<String, String> map = new HashMap<String, String>();
	public ForEachBean() {
		memberList.add(new MemberDTO("jang", 20, "�Ǳ�", "111-1111"));
		memberList.add(new MemberDTO("kim", 25, "����", "112-1121"));
		memberList.add(new MemberDTO("jung", 27, "����", "113-1411"));
		memberList.add(new MemberDTO("wang", 22, "�뱸", "114-1119"));
		memberList.add(new MemberDTO("young", 29, "���", "151-1511"));

		map.put("kr", "���ѹα�");
		map.put("jp", "�Ϻ�");
		map.put("cn", "�߱�");
		map.put("us", "�̱�");
		map.put("fr", "������");
	}
	public String[] getNames() {
		return names;
	}
	public List<String> getMenus() {
		return menus;
	}
	public List<MemberDTO> getMemberList() {
		return memberList;
	}
	public Map<String, String> getMap() {
		return map;
	}
	
}
