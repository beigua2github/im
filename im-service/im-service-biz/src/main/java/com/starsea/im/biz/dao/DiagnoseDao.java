package com.starsea.im.biz.dao;

import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.annotation.Single;
import com.starsea.im.biz.entity.StudyForm;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by danny on 16/4/28.
 */
@Repository
@Single
public interface DiagnoseDao {

    @DataSource("write")
    public int addStudyFormByTeacher(StudyForm studyForm);

    @DataSource("read")
    public List<StudyForm> queryStudyFormByTeacher();

    @DataSource("read")
    public StudyForm queryLastStudyFormByName(String name);

    @DataSource("read")
    public StudyForm queryStudyFormByOpenId(String openId);

    @DataSource("read")
    public List<String> queryStudyFormAllOpenId();

}
