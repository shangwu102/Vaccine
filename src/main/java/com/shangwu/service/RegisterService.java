package com.shangwu.service;

import com.shangwu.pojo.Doctor;
import com.shangwu.pojo.User;

public interface RegisterService {
    public Integer registerUser(User user);
    public Integer registerDoctor(Doctor doctor);
}

