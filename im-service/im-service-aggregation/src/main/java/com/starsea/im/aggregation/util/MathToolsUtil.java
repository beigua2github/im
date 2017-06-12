package com.starsea.im.aggregation.util;

import com.starsea.im.biz.entity.StudyForm;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danny on 16/4/12.
 */

@Component
public class MathToolsUtil {

    //总分
    public static long getSum(List<Integer> score){

        long sunTemp = 0;
        for(long hc:score){

            sunTemp+=hc;
        }

        return sunTemp;

    }

    //总分
    public static long getSumWithLong(List<Long> hcs){

        long sunTemp = 0;
        for(long hc:hcs){

            sunTemp+=hc;
        }

        return sunTemp;

    }
    //平均分
    public static long getAvg(List<Integer> score){

        long avg = getSum(score)/score.size();

        return avg;

    }

    //平均分
    public static long getAvgWithLong(List<Long> hcs){

        long avg = getSumWithLong(hcs)/hcs.size();

        return avg;

    }

    //方差
    public static long getVar(List<Integer> hcs){

        long avg=getAvg(hcs);

        long var = 0;
        for(long hc:hcs){
            var += (hc - avg) * (hc - avg);
        }

        return var/hcs.size();
    }

   //标准差
    public  static long getStd(long var){

      return (long)Math.sqrt(var);
    }


    /**
     *  学习诊断的工具类
     * @param
     * @return
     */

    //均分  分别传入4个纬度需要计算的分数 studyForms.size()we为学生人数
    public static long getAvgWithStudents(List<List<Integer>> studyForms){

        long sum = 0;
        for(List<Integer> studyForm:studyForms){

            //一个学生的X
            sum+=getSum(studyForm);

        }

        return sum/studyForms.size();

    }

    //标准差  s
    public  static long getStdWithStudents(List<List<Integer>> studyForms){

        long sum = 0;
        long avg = getAvgWithStudents(studyForms);

        for (List<Integer> studyForm:studyForms){
            long sumOne = getSum(studyForm);

            sum += (sumOne - avg)*(sumOne - avg);

        }
        return getStd(sum/(studyForms.size()-1));
    }


    //标准分数z 对应每个学生
    public static List<Long> getStdScore(List<List<Integer>> studyForms){

        long s = getStdWithStudents(studyForms);
        long avg = getAvgWithStudents(studyForms);
        List<Long> stdScore = new ArrayList<Long>();
        for(List<Integer> studyForm:studyForms){
           long z =  (getSum(studyForm) - avg)/s;
            stdScore.add(z);
        }

        return stdScore;

    }

    //转化为常模分数 c
    public static List<Long> getRegularScore(List<Long> scores){


        List<Long> regularScore = new ArrayList<Long>();
        for (long score:scores){
            long c = 100 + 15*score;
            regularScore.add(c);

        }

        return regularScore;
    }

    //D 换算成最高分的100
    public static long getMax(List<Long> c) {

        long cMax = c.get(0);
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i) > cMax) {
                cMax = c.get(i);
            }

        }

        return cMax - 100;
    }

    //C'
    public static List<Long> getFinalRegularScore(List<Long> regularScore){

        long D = getMax(regularScore);
        List<Long> finalRegularScore = new ArrayList<Long>();
        for (long score : regularScore) {
            long c1 = score - D;
            finalRegularScore.add(c1);
        }

        return finalRegularScore;
    }


    /**
     * 每日观察的工具类
     */




}
