package com.starsea.im.biz.entity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/20.
 */
public class WatchAllChildren {
    private ArrayList<ArrayList<String>> zizhu=new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> zhuanzhu=new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> yizhi=new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> qingxu=new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> renji=new ArrayList<ArrayList<String>>();
    private ArrayList<String> date=new ArrayList<String>();
    private ArrayList<String> childrenName=new ArrayList<String>();

    public ArrayList<ArrayList<String>> getZizhu() {
        return zizhu;
    }

    public void setZizhu(ArrayList<ArrayList<String>> zizhu) {
        this.zizhu = zizhu;
    }

    public ArrayList<ArrayList<String>> getZhuanzhu() {
        return zhuanzhu;
    }

    public void setZhuanzhu(ArrayList<ArrayList<String>> zhuanzhu) {
        this.zhuanzhu = zhuanzhu;
    }

    public ArrayList<ArrayList<String>> getQingxu() {
        return qingxu;
    }

    public void setQingxu(ArrayList<ArrayList<String>> qingxu) {
        this.qingxu = qingxu;
    }

    public ArrayList<ArrayList<String>> getYizhi() {
        return yizhi;
    }

    public void setYizhi(ArrayList<ArrayList<String>> yizhi) {
        this.yizhi = yizhi;
    }

    public ArrayList<ArrayList<String>> getRenji() {
        return renji;
    }

    public void setRenji(ArrayList<ArrayList<String>> renji) {
        this.renji = renji;
    }

    public ArrayList<String> getDate() {
        return date;
    }

    public void setDate(ArrayList<String> date) {
        this.date = date;
    }

    public ArrayList<String> getChildrenName() {
        return childrenName;
    }

    public void setChildrenName(ArrayList<String> childrenName) {
        this.childrenName = childrenName;
    }
}
