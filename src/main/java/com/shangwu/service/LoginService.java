package com.shangwu.service;

import com.shangwu.pojo.Doctor;
import com.shangwu.pojo.User;

public interface LoginService {

    public Integer loginUser(User user);
    public Integer loginDoctor(Doctor doctor);
}
