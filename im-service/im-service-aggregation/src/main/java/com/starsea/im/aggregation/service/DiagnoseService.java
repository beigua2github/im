package com.starsea.im.aggregation.service;

import com.starsea.im.aggregation.constant.DataSourceType;
import com.starsea.im.aggregation.dto.StudyFormDto;
import com.starsea.im.aggregation.dto.StudyResultDto;
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

    @DataSource(DataSourceType.READ)
    public StudyFormDto queryStudyFormByOpenId(String openId);


    //均分  分别传入4个纬度需要计算的分数 单个学生的分数,方便返回结果
    public List<Long> getAvgWithStudent(String openId);

    //均分  分别传入4个纬度需要计算的分数 studyForms.size()we为学生人数
    public List<Long> getAvgWithStudents();

    //标准差  分别传入4个纬度需要计算的分数 studyForms.size()we为学生人数
    public List<Long> getStdWithStudents();

    public List<List<Long>> getStdScore();

    public  List<List<Long>> getRegularScore();

    public  List<List<Long>> getFinalRegularScore();

    public  List<Long> getFinalStdScore();

   public List<StudyResultDto> getFinalCommentByOpenId(String openId);

    }