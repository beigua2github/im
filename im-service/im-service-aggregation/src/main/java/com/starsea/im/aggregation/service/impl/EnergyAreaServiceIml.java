package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.service.EnergyAreaService;
import com.starsea.im.biz.dao.EnergyAreaDao;
import com.starsea.im.biz.entity.EnergyAreaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by danny on 16/8/23.
 */
@Service("EnergyAreaService")
public class EnergyAreaServiceIml implements EnergyAreaService {

    @Autowired
    private EnergyAreaDao energyAreaDao;

    @Override
    public List<EnergyAreaEntity> queryEnergyArea()
    {
        return energyAreaDao.queryEnergyArea();

    }

   @Override
    public EnergyAreaEntity queryEnergyAreaById(int id){

       return energyAreaDao.queryEnergyAreaById(id);
   }

}
