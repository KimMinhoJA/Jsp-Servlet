package kosta.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.model.dao.ElectronicsDAO;
import kosta.mvc.model.domain.Electronics;
import kosta.mvc.model.service.ElectronicsService;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Electronics> list = ElectronicsService.selecAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elecView/list.jsp");
		request.setAttribute("list", list);
		System.out.println("SelectController »£√‚....");
		return mv;
	}

}
