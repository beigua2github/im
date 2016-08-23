package com.starsea.im.aggregation.service;

import com.starsea.im.aggregation.constant.DataSourceType;
import com.starsea.im.aggregation.dto.LabelDto;
import com.starsea.im.aggregation.dto.UserDto;
import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.entity.LabelEntity;
import com.starsea.im.biz.entity.UserLabelEntity;

import java.util.List;

/**
 * Created by danny on 16/8/20.
 */
public interface UserLabelService {
    @DataSource(DataSourceType.WRITE)
    public int addUserLabel(UserLabelEntity userLabelEntity);


    @DataSource(DataSourceType.READ)
    public List<LabelDto> queryLabelByOpenId(String openId);

    @DataSource(DataSourceType.READ)
    public List<Integer> queryEnergyByOpenId(String openId);


}
