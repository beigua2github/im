package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.dto.AdvantageFormDto;
import com.starsea.im.aggregation.dto.WatchFormDto;
import com.starsea.im.aggregation.service.AdvantageService;
import com.starsea.im.aggregation.transfor.Transformer;
import com.starsea.im.biz.dao.AdvantageDao;
import com.starsea.im.biz.entity.AdvantageForm;
import com.starsea.im.biz.entity.WatchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danny on 16/5/8.
 */
@Service("advantageService")
public class AdvantageServiceIml implements AdvantageService {
    @Autowired
    private AdvantageDao advantageDao;


    @Override
    public int addAdvantageForm(AdvantageForm advantageForm){
        return advantageDao.addAdvantageForm(advantageForm);
    }

    @Override
    public List<AdvantageFormDto> queryAdvantageForm() {

        List<AdvantageForm> advantageForms = advantageDao.queryAdvantageForm();
        List<AdvantageFormDto> advantageFormDtos = new ArrayList<AdvantageFormDto>();
        if(advantageForms.size()!= 0){

            for (AdvantageForm advantageForm:advantageForms){
                AdvantageFormDto advantageFormDto = Transformer.converAdvantageFormDtoFromAdvantageForm(advantageForm);
                advantageFormDtos.add(advantageFormDto);
            }

        }
        return advantageFormDtos;

    }

    @Override
    public AdvantageFormDto queryAdvantageFormByName(String name) {

        AdvantageForm advantageForm = advantageDao.queryAdvantageFormByName(name);
        AdvantageFormDto advantageFormDto = new AdvantageFormDto();
        if (advantageForm != null) {
             advantageFormDto = Transformer.converAdvantageFormDtoFromAdvantageForm(advantageForm);
        }
        return advantageFormDto;
    }

    @Override
    public AdvantageFormDto queryAdvantageFormByOpenId(String openId) {

        AdvantageForm advantageForm = advantageDao.queryAdvantageFormByOpenId(openId);
        AdvantageFormDto advantageFormDto = new AdvantageFormDto();
        if (advantageForm != null) {
            advantageFormDto = Transformer.converAdvantageFormDtoFromAdvantageForm(advantageForm);
        }
        return advantageFormDto;
    }


}
