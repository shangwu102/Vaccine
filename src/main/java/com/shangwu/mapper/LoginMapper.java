package com.shangwu.mapper;


import com.shangwu.pojo.Doctor;
import com.shangwu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("select count(*) from vaccine.user where account=#{account} and password=#{password}")
    public Integer loginUser(User user);
    @Select("select count(*) from vaccine.doctor where account=#{account} and password=#{password} and certificate_number=#{certificateNumber}")
    public Integer loginDoctor(Doctor docker);
}
