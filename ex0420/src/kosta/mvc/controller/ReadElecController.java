package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.model.domain.Electronics;
import kosta.mvc.model.service.ElectronicsService;

public class ReadElecController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elecView/read.jsp");
		String modelNum = request.getParameter("modelNum");
		
		Electronics electronics = ElectronicsService.selectByModelNum(modelNum);
		if(electronics ==null) {
			throw new Exception("�Խù� �б� ����");
		}
		request.setAttribute("elec", electronics);
		
		System.out.println("ReadElecControllerȣ��...");
		return mv;
	}

}
