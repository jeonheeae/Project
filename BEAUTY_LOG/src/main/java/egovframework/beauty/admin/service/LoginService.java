package egovframework.beauty.admin.service;

import org.springframework.stereotype.Service;

import egovframework.beauty.admin.model.LoginVO;

@Service
public interface LoginService {
	
	// 로그인 처리
	LoginVO getLogin(LoginVO loginVO) throws Exception;

}
