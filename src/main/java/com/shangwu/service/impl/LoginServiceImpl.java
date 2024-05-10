package com.shangwu.service.impl;

import com.shangwu.mapper.LoginMapper;
import com.shangwu.pojo.Doctor;
import com.shangwu.pojo.User;
import com.shangwu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;
    @Override
    public Integer loginUser(User user) {
        Integer count = loginMapper.loginUser(user);
        return count;
    }

    @Override
    public Integer loginDoctor(Doctor doctor) {
        Integer count = loginMapper.loginDoctor(doctor);
        return count;
    }
}
