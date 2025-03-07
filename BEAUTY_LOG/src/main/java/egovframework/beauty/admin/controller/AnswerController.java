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
public class AnswerController {
	
	// 답변 관리
	@RequestMapping(value="/answer/getAnswer.do", method = {RequestMethod.GET})
	public String getAnswer(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session
			)throws Exception {
		
		return null;
	}
	
	
}
