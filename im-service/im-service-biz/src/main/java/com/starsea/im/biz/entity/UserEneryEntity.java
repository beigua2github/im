package com.starsea.im.biz.entity;

/**
 * Created by Administrator on 2016/8/24.
 */
public class UserEneryEntity {
    private Integer id;
    private String openId;
    private String enerySelect;
    private String evaluationTime;
    private String title;
    private String customResult;
    private String score;
    private String commont;

    public String getCommont() {
        return commont;
    }

    public void setCommont(String commont) {
        this.commont = commont;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(String evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getEnerySelect() {
        return enerySelect;
    }

    public void setEnerySelect(String enerySelect) {
        this.enerySelect = enerySelect;
    }

    public String getCustomResult() {
        return customResult;
    }

    public void setCustomResult(String customResult) {
        this.customResult = customResult;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
