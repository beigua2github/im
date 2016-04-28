package com.starsea.im.aggregation.service;

import com.starsea.im.aggregation.constant.DataSourceType;
import com.starsea.im.aggregation.dto.StudyFormDto;
import com.starsea.im.aggregation.dto.WatchFormDto;
import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.entity.StudyForm;

import java.util.List;

/**
 * Created by danny on 16/4/28.
 */
public interface DiagnoseService {

    @DataSource(DataSourceType.WRITE)
    public int addStudyForm(StudyForm studyForm);

    @DataSource(DataSourceType.READ)
    public List<StudyForm> queryStudyForm();

    @DataSource(DataSourceType.READ)
    public StudyFormDto queryLastStudyFormByName(String name);
}
