package com.starsea.im.aggregation.dto;

import lombok.*;
import lombok.experimental.Builder;


/**
 * Created by danny on 16/4/27.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StudyFormDto {
    private String name;
    private Integer age;
    private String sex;
    private String banji;
    private String school;
    private String organization;
    private String evaluationPerson;
    private String evaluationTime;
    private int now_score[];
    private int scoreTotal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
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

    public String getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(String evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public int[] getNow_score() {
        return now_score;
    }

    public void setNow_score(int[] now_score) {
        this.now_score = now_score;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }
}
