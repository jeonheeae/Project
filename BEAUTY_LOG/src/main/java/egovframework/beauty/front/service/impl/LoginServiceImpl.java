package egovframework.beauty.front.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.beauty.front.model.LoginVO;
import egovframework.beauty.front.service.LoginService;
import egovframework.beauty.front.service.mapper.LoginMapper;

@Service("frontLoginServiceImpl")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public LoginVO getLogin(LoginVO loginVO) throws Exception {
        return loginMapper.getLogin(loginVO);  // MyBatis 매퍼에서 로그인 정보를 조회
    }
}
