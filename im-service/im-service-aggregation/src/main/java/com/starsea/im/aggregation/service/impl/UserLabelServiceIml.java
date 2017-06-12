package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.dto.LabelDto;
import com.starsea.im.aggregation.service.LabelService;
import com.starsea.im.aggregation.service.LabelToEnergyService;
import com.starsea.im.aggregation.service.UserLabelService;
import com.starsea.im.biz.dao.UserLabelDao;
import com.starsea.im.biz.entity.UserLabelEntity;
//import com.sun.tools.classfile.Opcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by danny on 16/8/20.
 */
@Service("UserLabelService")
public class UserLabelServiceIml  implements UserLabelService{
    
    @Autowired
    private UserLabelDao userLabelDao;

    @Autowired
    private LabelService labelService;

    @Autowired
    private LabelToEnergyService labelToEnergyService;

    public int addUserLabel(UserLabelEntity userLabelEntity) {

        return userLabelDao.addUserLabel(userLabelEntity);
    }


    public List<LabelDto> queryLabelByOpenId(String openId) {

        List<Integer> labelIds =  userLabelDao.queryLabelByOpenId(openId);

        List<LabelDto> labelDtos = new ArrayList<LabelDto>();
        for (Integer labelId:labelIds){
            LabelDto labelDto =   labelService.queryLabelById(labelId);
            labelDtos.add(labelDto);

        }

        return labelDtos;
    }

    public List<Integer> queryEnergyByOpenId(String openId){
        List<Integer> labelIds =  userLabelDao.queryLabelByOpenId(openId);
        Set<Integer>  energySet = new HashSet<Integer>();

        for(Integer labelId:labelIds){
            List<Integer> energyIds = labelToEnergyService.queryEnergyIdByLabelId(labelId);
            energySet.addAll(energyIds);
        }

        Iterator it=energySet.iterator();
        List<Integer> finalEneryIds = new ArrayList<Integer>();
        while(it.hasNext())
        {
            Integer o=(Integer)it.next();
            System.out.println(o);
            finalEneryIds.add(o);
        }

        return finalEneryIds;

    }

}
