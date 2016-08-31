package com.starsea.im.aggregation.dto;

import java.awt.*;

/**
 * Created by danny on 16/8/19.
 */

public class StudyResultDto {
    private String openId;
    private Long score;
    private String content;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
