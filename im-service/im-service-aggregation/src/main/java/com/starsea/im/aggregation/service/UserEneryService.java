package com.starsea.im.aggregation.service;

import com.starsea.im.aggregation.constant.DataSourceType;
import com.starsea.im.aggregation.dto.LabelDto;
import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.entity.UserEneryEntity;


import java.util.List;

/**
 * Created by Administrator on 2016/8/24.
 */
public interface UserEneryService{
    @DataSource(DataSourceType.WRITE)
    public int addUserEnery(UserEneryEntity userEneryEntity);


    @DataSource(DataSourceType.READ)
    public UserEneryEntity queryEneryByOpenId(String openId);

    @DataSource(DataSourceType.WRITE)
    public int addScore(UserEneryEntity userEneryEntity);


}
