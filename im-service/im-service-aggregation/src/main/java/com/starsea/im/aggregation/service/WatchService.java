package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.constant.DataSourceType;
import com.starsea.im.aggregation.dto.WatchFormDto;
import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.entity.WatchForm;

import java.util.Date;
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
    public List<WatchFormDto> queryLastWatchFormByNameWeek(String name);


    @DataSource(DataSourceType.READ)
    public List<WatchFormDto> queryLastWatchFormByNameMonth(String name);

    @DataSource(DataSourceType.READ)
    public Long queryAvgWatchFormByNameDay(String name,int day);




    }
