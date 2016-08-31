package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.dto.StudyFormDto;
import com.starsea.im.aggregation.dto.StudyResultDto;
import com.starsea.im.aggregation.service.DiagnoseService;
import com.starsea.im.aggregation.transfor.Transformer;
import com.starsea.im.aggregation.util.MathToolsUtil;
import com.starsea.im.aggregation.util.StudyResultUtil;
import com.starsea.im.biz.dao.DiagnoseDao;
import com.starsea.im.biz.entity.StudyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danny on 16/4/28.
 */

@Service("diagnoseService")
public class DiagnoseServiceImpl implements DiagnoseService {
    @Autowired
    private DiagnoseDao diagnoseDao;


    @Override
    public int addStudyForm(StudyForm studyForm) {
        return diagnoseDao.addStudyFormByTeacher(studyForm);
    }

    @Override
    public List<StudyForm> queryStudyForm() {

        return diagnoseDao.queryStudyFormByTeacher();
    }

    @Override
      public StudyFormDto queryLastStudyFormByName(String name) {

        StudyForm studyForm = diagnoseDao.queryLastStudyFormByName(name);
        StudyFormDto studyFormDto = new StudyFormDto();
        if (studyForm != null) {
            studyFormDto = Transformer.convertStudyFormDtoFromStudyForm(studyForm);
        }

        return studyFormDto;

    }


    @Override
    public StudyFormDto queryStudyFormByOpenId(String openId) {

        StudyForm studyForm = diagnoseDao.queryStudyFormByOpenId(openId);
        StudyFormDto studyFormDto = new StudyFormDto();
        if (studyForm != null) {
            studyFormDto = Transformer.convertStudyFormDtoFromStudyForm(studyForm);
        }

        return studyFormDto;

    }

    @Override
    public List<Long> getAvgWithStudent(String openId) {

        StudyForm studyForm = diagnoseDao.queryStudyFormByOpenId(openId);
        List<Long> Avg = new ArrayList<Long>();
        Long fenxinAvg = MathToolsUtil.getSum(Transformer.convertListFromStudyFormsOfFenxin(studyForm));
        Long yaodianAvg = MathToolsUtil.getSum(Transformer.convertListFromStudyFormsOfYaodian(studyForm));
        Long xinxiAvg = MathToolsUtil.getSum(Transformer.convertListFromStudyFormsOfXinxi(studyForm));
        Long jiaolvAvg = MathToolsUtil.getSum(Transformer.convertListFromStudyFormsOfJiaolv(studyForm));
        Avg.add(fenxinAvg);
        Avg.add(yaodianAvg);
        Avg.add(xinxiAvg);
        Avg.add(jiaolvAvg);
        return Avg;
    }

    //均分  分别传入4个纬度需要计算的分数
    @Override
    public List<Long> getAvgWithStudents() {

        List<StudyForm> allStudyForm = diagnoseDao.queryStudyFormByTeacher();
        List<Long> Avg = new ArrayList<Long>();
        Long fenxinAvg = MathToolsUtil.getAvgWithStudents(Transformer.convertListFromStudyFormsOfFenxin(allStudyForm));
        Long yaodianAvg = MathToolsUtil.getAvgWithStudents(Transformer.convertListFromStudyFormsOfYaodian(allStudyForm));
        Long xinxiAvg = MathToolsUtil.getAvgWithStudents(Transformer.convertListFromStudyFormsOfXinxi(allStudyForm));
        Long jiaolvAvg = MathToolsUtil.getAvgWithStudents(Transformer.convertListFromStudyFormsOfJiaolv(allStudyForm));

        Avg.add(fenxinAvg);
        Avg.add(yaodianAvg);
        Avg.add(xinxiAvg);
        Avg.add(jiaolvAvg);
        return Avg;
    }


    //标准差   分别传入4个纬度需要计算的分数
    @Override
    public List<Long> getStdWithStudents() {

        List<StudyForm> allStudyForm = diagnoseDao.queryStudyFormByTeacher();
        List<Long> Std = new ArrayList<Long>();
        Long fenxinStd = MathToolsUtil.getStdWithStudents(Transformer.convertListFromStudyFormsOfFenxin(allStudyForm));
        Long yaodianStd = MathToolsUtil.getStdWithStudents(Transformer.convertListFromStudyFormsOfYaodian(allStudyForm));
        Long xinxiStd = MathToolsUtil.getStdWithStudents(Transformer.convertListFromStudyFormsOfXinxi(allStudyForm));
        Long jiaolvStd = MathToolsUtil.getStdWithStudents(Transformer.convertListFromStudyFormsOfJiaolv(allStudyForm));

        Std.add(fenxinStd);
        Std.add(yaodianStd);
        Std.add(xinxiStd);
        Std.add(jiaolvStd);
        return Std;
    }

    //标准分   对应每个人 分别传入4个纬度需要计算的分数
    @Override
    public List<List<Long>> getStdScore() {

        List<StudyForm> allStudyForm = diagnoseDao.queryStudyFormByTeacher();
        List<List<Long>> stdScore = new ArrayList<List<Long>>();
        List<Long> fenxinStd = MathToolsUtil.getStdScore(Transformer.convertListFromStudyFormsOfFenxin(allStudyForm));
        List<Long> yaodianStd = MathToolsUtil.getStdScore(Transformer.convertListFromStudyFormsOfYaodian(allStudyForm));
        List<Long> xinxiStd = MathToolsUtil.getStdScore(Transformer.convertListFromStudyFormsOfXinxi(allStudyForm));
        List<Long> jiaolvStd = MathToolsUtil.getStdScore(Transformer.convertListFromStudyFormsOfJiaolv(allStudyForm));

        stdScore.add(fenxinStd);
        stdScore.add(yaodianStd);
        stdScore.add(xinxiStd);
        stdScore.add(jiaolvStd);
        return stdScore;
    }

    //转化为常模分数 c
    @Override
    public List<List<Long>> getRegularScore() {

        List<List<Long>> stdScores = getStdScore();
        List<List<Long>> stdScoresRegular = new ArrayList<List<Long>>();
        for (List<Long> stdScore : stdScores) {
            List<Long> stdScoreTemp = MathToolsUtil.getRegularScore(stdScore);
            stdScoresRegular.add(stdScoreTemp);
        }

        return stdScoresRegular;

    }


    //个体最终得分
    @Override
    public List<List<Long>> getFinalRegularScore() {

        List<List<Long>> stdScores = getRegularScore();
        List<List<Long>> stdScoresFinal = new ArrayList<List<Long>>();
        for (List<Long> stdScore : stdScores) {
            List<Long> stdTemp = MathToolsUtil.getFinalRegularScore(stdScore);
            stdScoresFinal.add(stdTemp);
        }
        return stdScoresFinal;

    }

    //个体最终得分_不分四个纬度
    @Override
    public List<Long> getFinalStdScore() {

        List<List<Long>> stdScores = getRegularScore();
        List<List<Long>> stdScoresFinal = new ArrayList<List<Long>>();
        for (List<Long> stdScore : stdScores) {
            List<Long> stdTemp = MathToolsUtil.getFinalRegularScore(stdScore);
            stdScoresFinal.add(stdTemp);
        }
        int length = stdScoresFinal.get(0).size();
        int weiDu = stdScoresFinal.size();
        List<Long> totalRegularScore = new ArrayList<Long>();

        for (int j = 0; j < length; j++) {
            long total = 0;
            for (int i = 0; i < weiDu; i++) {

                total += stdScoresFinal.get(i).get(j);
            }
//            double temp =  (double)(Math.round(total/4.0*10)/10.0);
            totalRegularScore.add(total/4);
        }

        return totalRegularScore;
    }


    public List<StudyResultDto> getFinalCommentByOpenId(String openId){

        List<Long> goal = getAvgWithStudent(openId);
        List<StudyResultDto> studyResultDtos = new ArrayList<StudyResultDto>();
        for(int i=0;i<4;i++) {
            StudyResultDto studyResultDto = new StudyResultDto();
            studyResultDto.setOpenId(openId);
            studyResultDto.setScore(goal.get(i));
            switch (i){
                case 0:
                    studyResultDto.setContent(StudyResultUtil.getFenXin(goal.get(i)));
                    break;
                case 1:
                    studyResultDto.setContent(StudyResultUtil.getYaoDian(goal.get(i)));
                    break;
                case 2:
                    studyResultDto.setContent(StudyResultUtil.getXingxi(goal.get(i)));
                    break;
                case 3:
                    studyResultDto.setContent(StudyResultUtil.getJiaoLv(goal.get(i)));
                    break;
                default:
                    break;
            }
            studyResultDtos.add(studyResultDto);
        }

      return studyResultDtos;

    }


}





