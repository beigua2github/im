package com.starsea.im.aggregation.service;

import com.starsea.im.aggregation.constant.DataSourceType;
import com.starsea.im.aggregation.dto.LabelDto;
import com.starsea.im.aggregation.dto.SearchDto;
import com.starsea.im.aggregation.dto.UserDto;
import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.entity.LabelEntity;
import com.starsea.im.biz.entity.PageModel;

import java.util.List;

/**
 * Created by beigua on 2015/8/12.
 */
public interface LabelService {

    @DataSource(DataSourceType.WRITE)
    public int addLabel(LabelEntity labelEntity);


    @DataSource(DataSourceType.READ)
    public List<LabelDto> queryLabel();

    @DataSource(DataSourceType.READ)
    public LabelDto queryLabelById(int id);

}