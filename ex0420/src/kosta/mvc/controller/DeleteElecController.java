package kosta.mvc.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.model.service.ElectronicsService;

public class DeleteElecController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String modelNum = request.getParameter("modelNum");
		String password = request.getParameter("password");
		String fName = request.getParameter("file");
		ElectronicsService.delete(modelNum, password);
		
		if(fName != null && fName !="") {
			String saveDir=request.getServletContext().getRealPath("/save");
			File file = new File(saveDir + "/" + fName);
			file.delete();
		}
		System.out.println("DeleteController»£√‚");
		ModelAndView mv = new ModelAndView(true, "index.html");
		return mv;
	}

}
