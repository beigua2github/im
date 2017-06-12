package com.starsea.im.aggregation.dto;

/**
 * Created by danny on 16/5/8.
 */

import lombok.*;
import lombok.experimental.Builder;

/**
 * Created by danny on 16/4/24.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AdvantageFormDto {
    private String name;
    private Integer age;
    private String sex;
    private String banji;
    private String school;
    private int now_score[];
    private int scoreTotal;

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

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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
