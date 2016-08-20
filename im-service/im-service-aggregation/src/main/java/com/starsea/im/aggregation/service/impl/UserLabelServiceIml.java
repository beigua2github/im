package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.dto.LabelDto;
import com.starsea.im.aggregation.service.LabelService;
import com.starsea.im.aggregation.service.UserLabelService;
import com.starsea.im.biz.dao.UserLabelDao;
import com.starsea.im.biz.entity.UserLabelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danny on 16/8/20.
 */
@Service("UserLabelService")
public class UserLabelServiceIml  implements UserLabelService{
    
    @Autowired
    private UserLabelDao userLabelDao;

    @Autowired
    private LabelService labelService;

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
}
