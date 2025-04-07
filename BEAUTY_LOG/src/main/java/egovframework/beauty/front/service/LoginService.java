package egovframework.beauty.front.service;

import org.springframework.stereotype.Service;

import egovframework.beauty.front.model.LoginVO;  // front.model.LoginVO 사용

@Service("frontLoginService")
public interface LoginService {

    // 로그인 처리
    LoginVO getLogin(LoginVO loginVO) throws Exception;

}
