package egovframework.beauty.front.service.mapper;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.beauty.front.model.JoinVO;

@Mapper
public interface JoinMapper {

    // 아이디 중복 체크
    int checkUserIdExistence(String userId);
    
    // 회원가입 처리
    int insertUser(JoinVO joinVO);
}
