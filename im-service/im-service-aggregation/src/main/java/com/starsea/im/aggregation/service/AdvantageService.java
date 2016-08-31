package com.starsea.im.aggregation.service;

import com.starsea.im.aggregation.constant.DataSourceType;
import com.starsea.im.aggregation.dto.AdvantageFormDto;
import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.entity.AdvantageForm;

import java.util.List;

/**
 * Created by danny on 16/5/8.
 */
public interface AdvantageService {

    @DataSource(DataSourceType.WRITE)
    public int addAdvantageForm(AdvantageForm advantageForm);

    @DataSource(DataSourceType.READ)
    public List<AdvantageFormDto> queryAdvantageForm();


    @DataSource(DataSourceType.READ)
    public AdvantageFormDto queryAdvantageFormByName(String name);

    @DataSource(DataSourceType.READ)
    public AdvantageFormDto queryAdvantageFormByOpenId(String openId);



}
