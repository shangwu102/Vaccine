package com.shangwu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String account;
    private String password;
    private String phoneNumber;
    private LocalDate createTime;
    private LocalDate updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(account, user.account) && Objects.equals(password, user.password) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(createTime, user.createTime) && Objects.equals(updateTime, user.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, password, phoneNumber, createTime, updateTime);
    }
}
