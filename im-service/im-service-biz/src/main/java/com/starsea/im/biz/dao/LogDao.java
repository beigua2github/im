package com.starsea.im.biz.dao;

import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.annotation.Single;
import com.starsea.im.biz.entity.LogEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Administrator on 2016/9/16.
 */
@Repository
@Single
public interface LogDao {

    @DataSource("red")
    LogEntity queryLog(Map<String, String> params);
    @DataSource("write")
    int insertLog(LogEntity logEntity);
    @DataSource("write")
    int updateLog(LogEntity logEntity);
    @DataSource("write")
    int deleteLog(LogEntity logEntity);
}
