package com.example.groom.domain.auth.userInfo;


import com.example.groom.common.exception.CustomException;
import com.example.groom.common.exception.ErrorCode;
import com.example.groom.domain.auth.user.UserRepository;
import com.example.groom.entity.domain.auth.kakao.KakaoInfo;
import com.example.groom.entity.domain.auth.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;
    private final KakaoInfoRepository kakaoInfoRepository;

    private final UserRepository userRepository;
    public User getUserInfo(Long id){
        Optional<User> userInfo = this.userInfoRepository.findById(id);
        if(userInfo.isEmpty())throw new CustomException(ErrorCode.USER_NOT_FOUND);
        return userInfo.get();
    }

    public User getUserInfoByKakaoId(Long kakaoId) throws CustomException{
        return this.userInfoRepository.findByKakaoId(kakaoId)
                .orElseThrow(()->new CustomException(ErrorCode.JOIN_REQUIRED));
    }

    public User joinUserWithKakaoInfo(KakaoInfo kakaoInfo){
        System.out.println(kakaoInfo);
        kakaoInfo = kakaoInfoRepository.save(kakaoInfo);
        User user = userRepository.save(new User());
        User userInfo = User.builder().user(user).kakao(kakaoInfo).build();
        return userInfoRepository.save(userInfo);
    }

}
