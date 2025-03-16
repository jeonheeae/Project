package egovframework.beauty.admin.service.mapper;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.beauty.admin.model.LoginVO;

@Mapper("LoginMapper")
public interface LoginMapper {

	// 로그인 처리
	LoginVO getLogin(LoginVO loginVO)throws Exception;

}
