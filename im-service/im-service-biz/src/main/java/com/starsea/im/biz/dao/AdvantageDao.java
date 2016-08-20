package com.starsea.im.biz.dao;

import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.annotation.Single;
import com.starsea.im.biz.entity.AdvantageForm;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by danny on 16/5/8.
 */

@Repository
@Single
public interface AdvantageDao {

    @DataSource("write")
    public int addAdvantageForm(AdvantageForm advantageForm);

    @DataSource("read")
    public List<AdvantageForm> queryAdvantageForm();

    @DataSource("read")
    public AdvantageForm queryAdvantageFormByName(String name);

    @DataSource("read")
    public AdvantageForm queryAdvantageFormByOpenId(String openId);


}
