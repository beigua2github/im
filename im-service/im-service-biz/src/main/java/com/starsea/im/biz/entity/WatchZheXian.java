package com.starsea.im.biz.entity;

/**
 * Created by Administrator on 2016/9/18.
 */
public class WatchZheXian {
    private String score[][]=new String[7][5];
    private String date[]=new String[7];
    private String score_m[][]=new String[30][5];
    private String date_m[]=new String[30];
    public String[][] getScore() {
        return score;
    }

    public void setScore(String[][] score) {
        this.score = score;
    }

    public String[] getDate() {
        return date;
    }

    public void setDate(String[] date) {
        this.date = date;
    }

    public String[][] getScore_m() {
        return score_m;
    }

    public void setScore_m(String[][] score_m) {
        this.score_m = score_m;
    }

    public String[] getDate_m() {
        return date_m;
    }

    public void setDate_m(String[] date_m) {
        this.date_m = date_m;
    }
}
