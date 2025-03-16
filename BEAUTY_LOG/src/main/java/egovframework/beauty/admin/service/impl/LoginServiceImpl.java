package egovframework.beauty.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.beauty.admin.model.LoginVO;
import egovframework.beauty.admin.service.LoginService;
import egovframework.beauty.admin.service.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper loginMapper;

	// 로그인 처리
	@Override
	public LoginVO getLogin(LoginVO loginVO) throws Exception {
		return loginMapper.getLogin(loginVO);
	}
}
