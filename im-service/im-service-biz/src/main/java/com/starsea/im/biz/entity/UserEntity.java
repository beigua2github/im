package com.starsea.im.biz.entity;

import lombok.*;
import lombok.experimental.Builder;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;


/**
 * Created by beigua on 2015/8/5.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Alias("userEntity")
public class UserEntity {
    private int id;

    private String name;

    private int age;

    private String account;

    private String password;

    private String email;

    private Timestamp createTime;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
