package com.starsea.im.aggregation.service;

import com.starsea.im.aggregation.constant.DataSourceType;
import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.entity.EnergyAreaEntity;

import java.util.List;

/**
 * Created by danny on 16/8/23.
 */
public interface EnergyAreaService {
    @DataSource(DataSourceType.READ)
    public List<EnergyAreaEntity> queryEnergyArea();

    @DataSource(DataSourceType.READ)
    public EnergyAreaEntity queryEnergyAreaById(int id);




}
