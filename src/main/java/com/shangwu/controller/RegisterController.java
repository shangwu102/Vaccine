package com.shangwu.controller;


import com.shangwu.pojo.Doctor;
import com.shangwu.pojo.Result;
import com.shangwu.pojo.User;
import com.shangwu.service.RegisterService;
import com.shangwu.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @PostMapping("/user")
    public Result register(@RequestBody User user) {
        Integer count = registerService.registerUser(user);
        Map<String,Object> map = new HashMap<>();
        if(count >= 1) {
            map.put(user.getAccount(),user.getPhoneNumber());
            String jwt = JwtUtils.generateJwt(map);
            return Result.success(jwt);
        } else {
            return Result.error("注册失败");
        }
    }
    @PostMapping("/doctor")
    public Result register(@RequestBody Doctor doctor) {
        Integer count = registerService.registerDoctor(doctor);
        Map<String,Object> map = new HashMap<>();
        if(count >= 0) {
            map.put(doctor.getAccount(),doctor.getCertificateNumber());
            String jwt = JwtUtils.generateJwt(map);
            return Result.success(jwt);
        } else {
            return Result.error("注册失败");
        }
    }
}
