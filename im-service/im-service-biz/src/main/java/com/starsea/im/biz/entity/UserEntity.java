package com.starsea.im.biz.entity;

import lombok.*;
import lombok.experimental.Builder;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.Date;


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

    private String openId;

    private String name;

    private int age;

    private String sex;

    private String myClass;

    private String school;

    private String organization;

    private String evaluationPerson;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMyClass() {
        return myClass;
    }

    public void setMyClass(String myClass) {
        this.myClass = myClass;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getEvaluationPerson() {
        return evaluationPerson;
    }

    public void setEvaluationPerson(String evaluationPerson) {
        this.evaluationPerson = evaluationPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
