package egovframework.beauty.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.beauty.front.model.JoinVO;
import egovframework.beauty.front.service.JoinService;

@Controller("frontJoinController")
@RequestMapping(value = "front")
public class JoinController {

    @Autowired
    private JoinService joinService;

    // 사용자 회원가입 화면
    @RequestMapping(value = "/join.do", method = {RequestMethod.GET})
    public String join() {
        return "front/join";
    }

    // 회원가입 처리
    @RequestMapping(value = "/join.do", method = {RequestMethod.POST})
    public String postJoin(HttpServletRequest request,
                           HttpServletResponse response,
                           HttpSession session,
                           @ModelAttribute("JoinVO") JoinVO joinVO) {
        try {
            // 전화번호 합치기
            String phonePrefix = request.getParameter("phonePrefix");
            String phoneMiddle = request.getParameter("phoneMiddle");
            String phoneEnd = request.getParameter("phoneEnd");
            String userPhone = phonePrefix + "-" + phoneMiddle + "-" + phoneEnd;
            joinVO.setUserPhone(userPhone);

            // 이메일 합치기
            String emailId = request.getParameter("emailId");
            String emailDomain = request.getParameter("emailDomain");
            String userEmail = emailId + "@" + emailDomain;
            joinVO.setUserEmail(userEmail);

            // 비밀번호 확인
            if (!joinVO.getUserPwd().equals(joinVO.getConfirmPwd())) {
                request.setAttribute("errorMessage", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
                return "front/join";  // 회원가입 페이지로 다시 리턴
            }

            // 아이디 중복 체크
            if (joinService.isUserIdExists(joinVO.getUserId())) {
                request.setAttribute("errorMessage", "이미 존재하는 아이디입니다.");
                return "front/join";  // 회원가입 페이지로 다시 리턴
            }

            // 회원가입 처리
            boolean isSuccess = joinService.registerUser(joinVO);
            if (isSuccess) {
                return "redirect:/front/login.do";  // 성공 시 로그인 페이지로 이동
            } else {
                request.setAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도해주세요.");
                return "front/join";  // 실패 시 회원가입 페이지로 다시 리턴
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "서버 오류가 발생했습니다. 다시 시도해주세요.");
            return "front/join";  // 오류 발생 시 회원가입 페이지로 돌아가기
        }
    }
}


