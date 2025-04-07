package egovframework.beauty.front.service.mapper;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.beauty.front.model.LoginVO;

@Mapper("frontLoginMapper")
public interface LoginMapper {

	// 로그인 처리
	LoginVO getLogin(LoginVO loginVO)throws Exception;

}
