package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.model.domain.Electronics;
import kosta.mvc.model.service.ElectronicsService;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("InsertController»£√‚");
		Electronics electronics = new Electronics();
		
		String saveDir = request.getServletContext().getRealPath("/save");
		int maxSize = 1024 * 1024 * 100;//100MB
		String encoding = "UTF-8";
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

		String modelNum = m.getParameter("model_num");
		String modelName = m.getParameter("model_name");
		int price = Integer.parseInt(m.getParameter("price"));
		String description = m.getParameter("description");
		String password = m.getParameter("password");

		electronics.setModelNum(modelNum);
		electronics.setModelName(modelName);
		electronics.setPrice(price);
		electronics.setDescription(description);
		electronics.setPassword(password);
		
		if(m.getFile("file") != null) {
			String fname = m.getOriginalFileName("file");
			int fsize = (int) m.getFile("file").length();
			electronics.setFname(fname);
			electronics.setFsize(fsize);
		}
		
		ElectronicsService.insert(electronics);
		
		ModelAndView mv = new ModelAndView(true, "index.html");
		return mv;
	}

}
