package com.shangwu.service.impl;


import com.shangwu.mapper.RegisterMapper;
import com.shangwu.pojo.Doctor;
import com.shangwu.pojo.User;
import com.shangwu.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    RegisterMapper registerMapper;
    @Override
    public Integer registerUser(User user) {
        user.setCreateTime(LocalDate.now());
        user.setUpdateTime(LocalDate.now());
        Integer count = registerMapper.registerUser(user);
        return count;
    }
    @Override
    public Integer registerDoctor(Doctor doctor) {
        doctor.setCreateTime(LocalDate.now());
        doctor.setUpdateTime(LocalDate.now());
        Integer count = registerMapper.registerDoctor(doctor);
        return count;
    }
}
