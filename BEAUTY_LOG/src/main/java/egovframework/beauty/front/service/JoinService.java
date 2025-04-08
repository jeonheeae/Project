package egovframework.beauty.front.service;

import egovframework.beauty.front.model.JoinVO;

public interface JoinService {
    // 아이디 중복 체크
    boolean isUserIdExists(String userId);
    
    // 회원가입 처리
    boolean registerUser(JoinVO joinVO);
}
