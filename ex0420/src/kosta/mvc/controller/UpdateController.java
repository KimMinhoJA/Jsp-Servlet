package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.model.domain.Electronics;
import kosta.mvc.model.service.ElectronicsService;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(true, request.getContextPath() + "/index.html");
		Electronics electronics = new Electronics();
		String modelNum = request.getParameter("modelNum");
		String modelName = request.getParameter("model_name");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		
		electronics.setModelNum(modelNum);
		electronics.setModelName(modelName);
		electronics.setPrice(price);
		electronics.setDescription(description);

		System.out.println(modelNum);
		System.out.println(modelName);
		System.out.println(price);
		System.out.println(description);
		ElectronicsService.update(electronics);
		
		return mv;
	}

}
