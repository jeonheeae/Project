package egovframework.beauty.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value="admin")
@Controller
public class EventController {
	
	// 이벤트 관리
	@RequestMapping(value="/event/list.do", method = {RequestMethod.GET})
	public ModelAndView list(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session
			)throws Exception {
		ModelAndView mav = new ModelAndView("admin/event/list");
		
		return mav;
	}
	
	
}
