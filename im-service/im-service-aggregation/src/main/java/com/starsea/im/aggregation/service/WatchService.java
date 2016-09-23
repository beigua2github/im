package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.constant.DataSourceType;
import com.starsea.im.aggregation.dto.WatchFormDto;
import com.starsea.im.biz.annotation.DataSource;

import com.starsea.im.biz.entity.WatchAllChildren;
import com.starsea.im.biz.entity.WatchZheXian;
import com.starsea.im.biz.entity.WatchForm;

import java.util.List;

/**
 * Created by danny on 16/4/28.
 */
public interface WatchService {
    @DataSource(DataSourceType.WRITE)
    public  int addWatchForm(WatchForm watchForm);

    @DataSource(DataSourceType.READ)
    public WatchFormDto queryLastWatchFormByName(String name);

    @DataSource(DataSourceType.READ)
    public WatchFormDto queryWatchFormByOpenId(String openId);

    @DataSource(DataSourceType.READ)
    public List<WatchFormDto> queryLastWatchFormByNameWeek(String name);


    @DataSource(DataSourceType.READ)
    public List<WatchFormDto> queryLastWatchFormByNameMonth(String name);

    @DataSource(DataSourceType.READ)
    public Long queryAvgWatchFormByNameDay(String name,int day);

    @DataSource(DataSourceType.READ)
    public WatchZheXian queryLastWatchFormByOpenIdWeek(String openId);

    @DataSource(DataSourceType.READ)
    public WatchZheXian queryLastWatchFormByOpenIdMonth(String openId);

    @DataSource(DataSourceType.READ)
    public Long queryAvgWatchFormByOpenIdDay(String openId,int day);

    @DataSource(DataSourceType.READ)
    public WatchAllChildren queryOneTeacherAllChildrenByOpenIdWeek(String openId);

    @DataSource(DataSourceType.READ)
    public WatchAllChildren queryOneTeacherAllChildrenByOpenIdMonth(String openId);
    @DataSource(DataSourceType.READ)
    public WatchAllChildren queryAllChildrenByOpenIdMonth();
    @DataSource(DataSourceType.READ)
    public WatchAllChildren queryAllChildrenByOpenIdWeek();
}