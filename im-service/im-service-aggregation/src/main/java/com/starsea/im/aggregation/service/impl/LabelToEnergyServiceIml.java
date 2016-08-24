package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.service.EnergyAreaService;
import com.starsea.im.aggregation.service.LabelToEnergyService;
import com.starsea.im.biz.dao.EnergyAreaDao;
import com.starsea.im.biz.dao.LabelToEnergyDao;
import com.starsea.im.biz.entity.EnergyAreaEntity;
import com.starsea.im.biz.entity.LabelToEnergyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by danny on 16/8/23.
 */
@Service("LabelToEnergyService")
public class LabelToEnergyServiceIml implements LabelToEnergyService {

    @Autowired
    private LabelToEnergyDao labelToEnergyDao;

    @Override
    public List<Integer> queryEnergyIdByLabelId(int labelId)
    {
        return labelToEnergyDao.queryEnergyIdByLabelId(labelId);

    }


}
