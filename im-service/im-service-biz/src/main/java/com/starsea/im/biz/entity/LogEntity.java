package com.starsea.im.biz.entity;

/**
 * Created by Administrator on 2016/9/16.
 */
public class LogEntity {
    private String openId;
    private String childOpenId;
    private String log;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getChildOpenId() {
        return childOpenId;
    }

    public void setChildOpenId(String childOpenId) {
        this.childOpenId = childOpenId;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
