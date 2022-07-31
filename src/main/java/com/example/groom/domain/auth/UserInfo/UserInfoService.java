package com.example.groom.domain.auth.UserInfo;


import com.example.groom.common.exception.CustomException;
import com.example.groom.common.exception.ErrorCode;
import com.example.groom.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    public UserInfo getUserInfo(Long id){
        Optional<UserInfo> userInfo = this.userInfoRepository.findById(id);
        if(userInfo.isEmpty())throw new CustomException(ErrorCode.USER_NOT_FOUND);
        return userInfo.get();
    }
}
