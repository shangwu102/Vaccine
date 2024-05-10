package com.shangwu.mapper;

import com.shangwu.pojo.Doctor;
import com.shangwu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface RegisterMapper {
    @Insert("insert into vaccine.user(account, password,phone_number, create_time, update_time) VALUES (#{account},#{password},#{phoneNumber},#{createTime},#{updateTime})")
    public Integer registerUser(User user);
    @Insert("insert into vaccine.doctor(account, password, certificate_number, create_time, update_time) VALUES (#{account},#{password},#{certificateNumber},#{createTime},#{updateTime})")
    public Integer registerDoctor(Doctor doctor);
}
