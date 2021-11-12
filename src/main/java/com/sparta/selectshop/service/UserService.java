package com.sparta.selectshop.service;

import com.sparta.selectshop.dto.SignupRequestDto;
import com.sparta.selectshop.model.User;

public interface UserService {

    User registerUser(SignupRequestDto requestDto);

    void kakaoLogin(String authorizedCode);
}
