package egovframework.beauty.front.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.beauty.front.model.JoinVO;
import egovframework.beauty.front.service.JoinService;
import egovframework.beauty.front.service.mapper.JoinMapper;

@Service("joinService")
public class JoinServiceImpl implements JoinService {

    @Autowired
    private JoinMapper joinMapper;

    // 아이디 중복 체크
    @Override
    public boolean isUserIdExists(String userId) {
        return joinMapper.checkUserIdExistence(userId) > 0;
    }

    // 회원가입 처리
    @Override
    public boolean registerUser(JoinVO joinVO) {
        return joinMapper.insertUser(joinVO) > 0;
    }
}
