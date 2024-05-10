package com.shangwu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private Integer id;
    private String account;
    private String password;
    private String certificateNumber;// 证书编号
    private LocalDate createTime;
    private LocalDate updateTime;
}
