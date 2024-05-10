package com.shangwu.controller;

import com.shangwu.pojo.Doctor;
import com.shangwu.pojo.Result;
import com.shangwu.pojo.User;
import com.shangwu.service.impl.LoginServiceImpl;
import com.shangwu.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/user")
    public Result login(@RequestBody User user) {
        Integer count = loginService.loginUser(user);
            Map<String, Object> claims = new HashMap<>();
        if (count >= 1) {
            claims.put(user.getAccount(),user.getPhoneNumber());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        } else {
            return Result.error("登录失败");
        }
    }

    @PostMapping("/doctor")
    public Result login(@RequestBody Doctor doctor) {
        Integer count = loginService.loginDoctor(doctor);
        Map<String, Object> claims = new HashMap<>();
        if (count >= 1) {
            claims.put(doctor.getAccount(),doctor.getCertificateNumber());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        } else {
            return Result.error("登录失败");
        }
    }
}
