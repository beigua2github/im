package com.starsea.im.aggregation.transfor;

import com.starsea.im.aggregation.dto.StudyFormDto;
import com.starsea.im.aggregation.dto.WatchFormDto;
import com.starsea.im.biz.entity.StudyForm;
import com.starsea.im.biz.entity.WatchForm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by danny on 16/4/21.
 */
public class Transformer {

    /**
     * 日期格式字符串转换成时间戳
     * @param timestamp
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String timeStampToDate(String timestamp,String format) {
        if(timestamp == null || timestamp.isEmpty() || timestamp.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()) format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(timestamp)));
    }

    public static StudyForm enrichStudyForm(String name, String sex, String myClass, String school, String organization, String evaluationPerson, String evaluationTime, int[] hc) throws ParseException {

        StudyForm studyForm = new StudyForm();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(evaluationTime);
        studyForm.setName(name);
        studyForm.setSex(sex);
        studyForm.setBanji(myClass);
        studyForm.setSchool(school);
        studyForm.setOrganization(organization);
        studyForm.setEvaluationPerson(evaluationPerson);
        studyForm.setEvaluationTime(date);
        studyForm.setQuestion1(hc[0]);
        studyForm.setQuestion2(hc[1]);
        studyForm.setQuestion3(hc[2]);
        studyForm.setQuestion4(hc[3]);
        studyForm.setQuestion5(hc[4]);
        studyForm.setQuestion6(hc[5]);
        studyForm.setQuestion7(hc[6]);
        studyForm.setQuestion8(hc[7]);
        studyForm.setQuestion9(hc[8]);
        studyForm.setQuestion10(hc[9]);
        studyForm.setQuestion11(hc[10]);
        studyForm.setQuestion12(hc[11]);
        studyForm.setQuestion13(hc[12]);
        studyForm.setQuestion14(hc[13]);
        studyForm.setQuestion15(hc[14]);
        studyForm.setQuestion16(hc[15]);
        studyForm.setQuestion17(hc[16]);
        studyForm.setQuestion18(hc[17]);
        return studyForm;

    }

    public static WatchForm enrichWatchForm(String name, String evaluationPerson, String evaluationTime, int[] now_score,String[] now_comment) throws ParseException {

        WatchForm watchForm = new WatchForm();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(evaluationTime);
        watchForm.setName(name);
        watchForm.setEvaluationPerson(evaluationPerson);
        watchForm.setEvaluationTime(date);
        watchForm.setQuestion1(now_score[0]);
        watchForm.setQuestion2(now_score[1]);
        watchForm.setQuestion3(now_score[2]);
        watchForm.setQuestion4(now_score[3]);
        watchForm.setQuestion5(now_score[4]);
        watchForm.setQuestion6(now_score[5]);
        watchForm.setQuestion7(now_score[6]);
        watchForm.setQuestion8(now_score[7]);
        watchForm.setQuestion9(now_score[8]);
        watchForm.setQuestion10(now_score[9]);
        watchForm.setQuestion11(now_score[10]);
        watchForm.setQuestion12(now_score[11]);
        watchForm.setQuestion13(now_score[12]);
        watchForm.setQuestion14(now_score[13]);
        watchForm.setQuestion15(now_score[14]);
        watchForm.setQuestion16(now_score[15]);
        watchForm.setQuestion17(now_score[16]);
        watchForm.setQuestion18(now_score[17]);
        watchForm.setQuestion19(now_score[18]);
        watchForm.setQuestion20(now_score[19]);
        watchForm.setQuestion21(now_score[20]);
        watchForm.setQuestion22(now_score[21]);
        watchForm.setQuestion23(now_score[22]);
        watchForm.setQuestion24(now_score[23]);
        watchForm.setQuestion25(now_score[24]);
        watchForm.setQuestion26(now_score[25]);
        watchForm.setQuestion27(now_score[26]);
        watchForm.setQuestion28(now_score[27]);
        watchForm.setQuestion29(now_score[28]);
        watchForm.setQuestion30(now_score[29]);
        watchForm.setQuestion31(now_score[30]);
        watchForm.setQuestion32(now_score[31]);
        watchForm.setQuestion33(now_score[32]);
        watchForm.setQuestion34(now_score[33]);
        watchForm.setQuestion35(now_score[34]);
        watchForm.setQuestion36(now_score[35]);
        watchForm.setQuestion37(now_score[36]);
        watchForm.setQuestion38(now_score[37]);
        watchForm.setQuestion39(now_score[38]);
        watchForm.setQuestion40(now_score[39]);
        watchForm.setQuestion41(now_score[40]);
        watchForm.setQuestion42(now_score[41]);
        watchForm.setQuestion43(now_score[42]);
        watchForm.setQuestion44(now_score[43]);
        watchForm.setQuestion45(now_score[44]);
        watchForm.setQuestion46(now_score[45]);
        watchForm.setQuestion47(now_score[46]);
        watchForm.setQuestion48(now_score[47]);
        watchForm.setQuestion49(now_score[48]);
        watchForm.setQuestion50(now_score[49]);
        watchForm.setQuestion51(now_score[50]);
        watchForm.setQuestion52(now_score[51]);
        watchForm.setQuestion53(now_score[52]);
        watchForm.setQuestion54(now_score[53]);
        watchForm.setQuestion55(now_score[54]);
        watchForm.setQuestion56(now_score[55]);
        watchForm.setQuestion57(now_score[56]);

        watchForm.setComment1(now_comment[0]);
        watchForm.setComment2(now_comment[1]);
        watchForm.setComment3(now_comment[2]);
        watchForm.setComment4(now_comment[3]);
        watchForm.setComment5(now_comment[4]);
        watchForm.setComment6(now_comment[5]);
        watchForm.setComment7(now_comment[6]);
        watchForm.setComment8(now_comment[7]);
        watchForm.setComment9(now_comment[8]);
        watchForm.setComment10(now_comment[9]);
        watchForm.setComment11(now_comment[10]);
        watchForm.setComment12(now_comment[11]);
        watchForm.setComment13(now_comment[12]);
        watchForm.setComment14(now_comment[13]);
        watchForm.setComment15(now_comment[14]);
        watchForm.setComment16(now_comment[15]);
        watchForm.setComment17(now_comment[16]);
        watchForm.setComment18(now_comment[17]);
        watchForm.setComment19(now_comment[18]);
        watchForm.setComment20(now_comment[19]);
        watchForm.setComment21(now_comment[20]);
        watchForm.setComment22(now_comment[21]);
        watchForm.setComment23(now_comment[22]);
        watchForm.setComment24(now_comment[23]);
        watchForm.setComment25(now_comment[24]);
        watchForm.setComment26(now_comment[25]);
        watchForm.setComment27(now_comment[26]);
        watchForm.setComment28(now_comment[27]);
        watchForm.setComment29(now_comment[28]);
        watchForm.setComment30(now_comment[29]);
        watchForm.setComment31(now_comment[30]);
        watchForm.setComment32(now_comment[31]);
        watchForm.setComment33(now_comment[32]);
        watchForm.setComment34(now_comment[33]);
        watchForm.setComment35(now_comment[34]);
        watchForm.setComment36(now_comment[35]);
        watchForm.setComment37(now_comment[36]);
        watchForm.setComment38(now_comment[37]);
        watchForm.setComment39(now_comment[38]);
        watchForm.setComment40(now_comment[39]);
        watchForm.setComment41(now_comment[40]);
        watchForm.setComment42(now_comment[41]);
        watchForm.setComment43(now_comment[42]);
        watchForm.setComment44(now_comment[43]);
        watchForm.setComment45(now_comment[44]);
        watchForm.setComment46(now_comment[45]);
        watchForm.setComment47(now_comment[46]);
        watchForm.setComment48(now_comment[47]);
        watchForm.setComment49(now_comment[48]);
        watchForm.setComment50(now_comment[49]);
        watchForm.setComment51(now_comment[50]);
        watchForm.setComment52(now_comment[51]);
        watchForm.setComment53(now_comment[52]);
        watchForm.setComment54(now_comment[53]);
        watchForm.setComment55(now_comment[54]);
        watchForm.setComment56(now_comment[55]);
        watchForm.setComment57(now_comment[56]);


        return watchForm;

    }

    public static StudyFormDto convertWatchFormDtoFromStudyForm(StudyForm studyForm){

        int[] now_score = new int[57];
        StudyFormDto studyFormDto = new StudyFormDto();
        studyFormDto.setName(studyForm.getName());
        studyFormDto.setAge(studyForm.getAge());
        studyFormDto.setSex(studyForm.getSex());
        studyFormDto.setBanji(studyForm.getBanji());
        studyFormDto.setSchool(studyForm.getSchool());
        studyFormDto.setOrganization(studyForm.getOrganization());
        studyFormDto.setEvaluationTime(timeStampToDate(String.valueOf(studyForm.getEvaluationTime().getTime()), null));

        now_score[0] = studyForm.getQuestion1();
        now_score[1] = studyForm.getQuestion2();
        now_score[2] = studyForm.getQuestion3();
        now_score[3] = studyForm.getQuestion4();
        now_score[4] = studyForm.getQuestion5();
        now_score[5] = studyForm.getQuestion6();
        now_score[6] = studyForm.getQuestion7();
        now_score[7] = studyForm.getQuestion8();
        now_score[8] = studyForm.getQuestion9();
        now_score[9] = studyForm.getQuestion10();
        now_score[10] = studyForm.getQuestion11();
        now_score[11] = studyForm.getQuestion12();
        now_score[12] = studyForm.getQuestion13();
        now_score[13] = studyForm.getQuestion14();
        now_score[14] = studyForm.getQuestion15();
        now_score[15] = studyForm.getQuestion16();
        now_score[16] = studyForm.getQuestion17();
        studyFormDto.setNow_score(now_score);
        return studyFormDto;

    }

    public static WatchFormDto convertWatchFormDtoFromWatchForm(WatchForm watchForm){

        int[] now_score = new int[57];
        String[] now_comment = new String[57];
        WatchFormDto watchFormDto = new WatchFormDto();
        watchFormDto.setName(watchForm.getName());
        watchFormDto.setEvaluationPerson(watchForm.getEvaluationPerson());
        watchFormDto.setEvaluationTime(timeStampToDate(String.valueOf(watchForm.getEvaluationTime().getTime()),null));
        now_score[0]= watchForm.getQuestion1();
        now_score[1]= watchForm.getQuestion2();
        now_score[2]= watchForm.getQuestion3();
        now_score[3]= watchForm.getQuestion4();
        now_score[4]= watchForm.getQuestion5();
        now_score[5]= watchForm.getQuestion6();
        now_score[6]= watchForm.getQuestion7();
        now_score[7]= watchForm.getQuestion8();
        now_score[8]= watchForm.getQuestion9();
        now_score[9]= watchForm.getQuestion10();
        now_score[10]= watchForm.getQuestion11();
        now_score[11]= watchForm.getQuestion12();
        now_score[12]= watchForm.getQuestion13();
        now_score[13]= watchForm.getQuestion14();
        now_score[14]= watchForm.getQuestion15();
        now_score[15]= watchForm.getQuestion16();
        now_score[16]= watchForm.getQuestion17();
        now_score[17]= watchForm.getQuestion18();
        now_score[18]= watchForm.getQuestion19();
        now_score[19]= watchForm.getQuestion20();
        now_score[20]= watchForm.getQuestion21();
        now_score[21]= watchForm.getQuestion22();
        now_score[22]= watchForm.getQuestion23();
        now_score[23]= watchForm.getQuestion24();
        now_score[24]= watchForm.getQuestion25();
        now_score[25]= watchForm.getQuestion26();
        now_score[26]= watchForm.getQuestion27();
        now_score[27]= watchForm.getQuestion28();
        now_score[28]= watchForm.getQuestion29();
        now_score[29]= watchForm.getQuestion30();
        now_score[30]= watchForm.getQuestion31();
        now_score[31]= watchForm.getQuestion32();
        now_score[32]= watchForm.getQuestion33();
        now_score[33]= watchForm.getQuestion34();
        now_score[34]= watchForm.getQuestion35();
        now_score[35]= watchForm.getQuestion36();
        now_score[36]= watchForm.getQuestion37();
        now_score[37]= watchForm.getQuestion38();
        now_score[38]= watchForm.getQuestion39();
        now_score[39]= watchForm.getQuestion40();
        now_score[40]= watchForm.getQuestion41();
        now_score[41]= watchForm.getQuestion42();
        now_score[42]= watchForm.getQuestion43();
        now_score[43]= watchForm.getQuestion44();
        now_score[44]= watchForm.getQuestion45();
        now_score[45]= watchForm.getQuestion46();
        now_score[46]= watchForm.getQuestion47();
        now_score[47]= watchForm.getQuestion48();
        now_score[48]= watchForm.getQuestion49();
        now_score[49]= watchForm.getQuestion50();
        now_score[50]= watchForm.getQuestion51();
        now_score[51]= watchForm.getQuestion52();
        now_score[52]= watchForm.getQuestion53();
        now_score[53]= watchForm.getQuestion54();
        now_score[54]= watchForm.getQuestion55();
        now_score[55]= watchForm.getQuestion56();
        now_score[56]= watchForm.getQuestion57();

        now_comment[0]= watchForm.getComment1();
        now_comment[1]= watchForm.getComment2();
        now_comment[2]= watchForm.getComment3();
        now_comment[3]= watchForm.getComment4();
        now_comment[4]= watchForm.getComment5();
        now_comment[5]= watchForm.getComment6();
        now_comment[6]= watchForm.getComment7();
        now_comment[7]= watchForm.getComment8();
        now_comment[8]= watchForm.getComment9();
        now_comment[9]= watchForm.getComment10();
        now_comment[10]= watchForm.getComment11();
        now_comment[11]= watchForm.getComment12();
        now_comment[12]= watchForm.getComment13();
        now_comment[13]= watchForm.getComment14();
        now_comment[14]= watchForm.getComment15();
        now_comment[15]= watchForm.getComment16();
        now_comment[16]= watchForm.getComment17();
        now_comment[17]= watchForm.getComment18();
        now_comment[18]= watchForm.getComment19();
        now_comment[19]= watchForm.getComment20();
        now_comment[20]= watchForm.getComment21();
        now_comment[21]= watchForm.getComment22();
        now_comment[22]= watchForm.getComment23();
        now_comment[23]= watchForm.getComment24();
        now_comment[24]= watchForm.getComment25();
        now_comment[25]= watchForm.getComment26();
        now_comment[26]= watchForm.getComment27();
        now_comment[27]= watchForm.getComment28();
        now_comment[28]= watchForm.getComment29();
        now_comment[29]= watchForm.getComment30();
        now_comment[30]= watchForm.getComment31();
        now_comment[31]= watchForm.getComment32();
        now_comment[32]= watchForm.getComment33();
        now_comment[33]= watchForm.getComment34();
        now_comment[34]= watchForm.getComment35();
        now_comment[35]= watchForm.getComment36();
        now_comment[36]= watchForm.getComment37();
        now_comment[37]= watchForm.getComment38();
        now_comment[38]= watchForm.getComment39();
        now_comment[39]= watchForm.getComment40();
        now_comment[40]= watchForm.getComment41();
        now_comment[41]= watchForm.getComment42();
        now_comment[42]= watchForm.getComment43();
        now_comment[43]= watchForm.getComment44();
        now_comment[44]= watchForm.getComment45();
        now_comment[45]= watchForm.getComment46();
        now_comment[46]= watchForm.getComment47();
        now_comment[47]= watchForm.getComment48();
        now_comment[48]= watchForm.getComment49();
        now_comment[49]= watchForm.getComment50();
        now_comment[50]= watchForm.getComment51();
        now_comment[51]= watchForm.getComment52();
        now_comment[52]= watchForm.getComment53();
        now_comment[53]= watchForm.getComment54();
        now_comment[54]= watchForm.getComment55();
        now_comment[55]= watchForm.getComment56();
        now_comment[56]= watchForm.getComment57();

        watchFormDto.setNow_score(now_score);
        watchFormDto.setNow_comment(now_comment);

        return watchFormDto;

    }

}
