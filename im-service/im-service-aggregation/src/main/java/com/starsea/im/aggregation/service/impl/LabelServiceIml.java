package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.dto.LabelDto;
import com.starsea.im.aggregation.service.LabelService;
import com.starsea.im.aggregation.transfor.Transformer;
import com.starsea.im.biz.dao.LabelDao;
import com.starsea.im.biz.entity.LabelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danny on 16/8/19.
 */
@Service("LabelService")
public class LabelServiceIml implements LabelService{

    @Autowired
    LabelDao labelDao;

    @Override
    public int addLabel(LabelEntity labelEntity) {
        return labelDao.addLabel(labelEntity);
    }

    @Override
    public List<LabelDto> queryLabel(){

        List<LabelEntity> labelEntitys = labelDao.queryLabel();
        List<LabelDto> labelDtos = new ArrayList<LabelDto>();
        if(labelEntitys.size() != 0 ){
            for(LabelEntity labelEntity:labelEntitys){
                  LabelDto labelDto = Transformer.convertLabelDtoFromLabelEntity(labelEntity);
                labelDtos.add(labelDto);
            }

        }

        return labelDtos;
    }

    @Override
    public LabelDto queryLabelById(int id){

        LabelEntity labelEntity = labelDao.queryLabelById(id);
        LabelDto labelDto = new LabelDto();
        if(labelEntity != null ){
            labelDto = Transformer.convertLabelDtoFromLabelEntity(labelEntity);

        }

        return labelDto;
    }

}
