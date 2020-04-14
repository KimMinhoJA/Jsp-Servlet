package ex0414.jstl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachBean {
	private String[] names = {"¹ÎÈ£", "ÀÀºñ", "Àººñ", "Àººù±¸", "ºù±¸"};
	private List<String> menus = Arrays.asList(new String[] {"Â¥Àå¸é", "Â«»Í", "ÅÁ¼öÀ°", "±ñÇ³±â", "ÆÈº¸Ã¤", "¾çÀåÇÇ"});
	private List<MemberDTO> memberList = new ArrayList<MemberDTO>();
	private Map<String, String> map = new HashMap<String, String>();
	public ForEachBean() {
		memberList.add(new MemberDTO("jang", 20, "ÆÇ±³", "111-1111"));
		memberList.add(new MemberDTO("kim", 25, "¼ö¿ø", "112-1121"));
		memberList.add(new MemberDTO("jung", 27, "¼­¿ï", "113-1411"));
		memberList.add(new MemberDTO("wang", 22, "´ë±¸", "114-1119"));
		memberList.add(new MemberDTO("young", 29, "¿ï»ê", "151-1511"));

		map.put("kr", "´ëÇÑ¹Î±¹");
		map.put("jp", "ÀÏº»");
		map.put("cn", "Áß±¹");
		map.put("us", "¹Ì±¹");
		map.put("fr", "ÇÁ¶û½º");
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
