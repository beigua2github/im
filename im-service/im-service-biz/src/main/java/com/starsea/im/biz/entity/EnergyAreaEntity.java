package com.starsea.im.biz.entity;

import lombok.*;
import lombok.experimental.Builder;
import org.apache.ibatis.type.Alias;

import java.util.Date;


/**
 * Created by beigua on 2015/8/5.
 */

public class EnergyAreaEntity {
    private int id;

    private String Label;

    private String Content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
