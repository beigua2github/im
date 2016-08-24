package com.starsea.im.aggregation.service;

import com.starsea.im.aggregation.constant.DataSourceType;
import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.entity.EnergyAreaEntity;

import java.util.List;

/**
 * Created by danny on 16/8/23.
 */
public interface LabelToEnergyService {
    @DataSource(DataSourceType.READ)
    public List<Integer> queryEnergyIdByLabelId(int labelId);


}
