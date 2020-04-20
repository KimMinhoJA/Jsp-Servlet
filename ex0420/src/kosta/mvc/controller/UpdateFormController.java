package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.model.domain.Electronics;

public class UpdateFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elecView/update.jsp");
		
		Electronics elec = new Electronics();
		elec.setModelNum(request.getParameter("modelNum"));
		request.setAttribute("elec", elec);
		System.out.println("UpdateFormController»£√‚...");
		return mv;
	}

}
