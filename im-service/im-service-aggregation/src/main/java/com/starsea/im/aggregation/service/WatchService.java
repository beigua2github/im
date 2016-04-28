package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.constant.DataSourceType;
import com.starsea.im.aggregation.dto.WatchFormDto;
import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.entity.WatchForm;

/**
 * Created by danny on 16/4/28.
 */
public interface WatchService {
    @DataSource(DataSourceType.WRITE)
    public  int addWatchForm(WatchForm watchForm);

    @DataSource(DataSourceType.READ)
    public WatchFormDto queryLastWatchFormByName(String name);

}
