package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.dto.StudyFormDto;
import com.starsea.im.aggregation.service.DiagnoseService;
import com.starsea.im.aggregation.transfor.Transformer;
import com.starsea.im.biz.dao.DiagnoseDao;
import com.starsea.im.biz.entity.StudyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by danny on 16/4/28.
 */

@Service("diagnoseService")
public class DiagnoseServiceImpl implements DiagnoseService {
    @Autowired
    private DiagnoseDao diagnoseDao;


    @Override
    public int addStudyForm(StudyForm studyForm){
        return diagnoseDao.addStudyFormByTeacher(studyForm);
    }

    @Override
    public List<StudyForm> queryStudyForm(){

        return diagnoseDao.queryStudyFormByTeacher();
    }

    @Override
    public StudyFormDto queryLastStudyFormByName(String name){

        StudyForm studyForm = diagnoseDao.queryLastStudyFormByName(name);
        StudyFormDto studyFormDto = new StudyFormDto();
        if(studyForm != null){
            studyFormDto = Transformer.convertWatchFormDtoFromStudyForm(studyForm);
        }

        return studyFormDto;

    }
}
