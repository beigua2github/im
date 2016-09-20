package com.starsea.im.aggregation.service;

import com.starsea.im.aggregation.constant.DataSourceType;
import com.starsea.im.aggregation.dto.LogDto;
import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.entity.LogEntity;

/**
 * Created by Administrator on 2016/9/15.
 */
public interface LogService {
    @DataSource(DataSourceType.READ)
    public LogEntity queryUserLog(String openId,String childOpenId);
    @DataSource(DataSourceType.WRITE)
    public int addUserLog(LogDto logDto);
    @DataSource(DataSourceType.WRITE)
    public int deleteUserLog(LogDto logDto);
}
