package com.starsea.im.web.controller;

import com.starsea.im.aggregation.service.DiagnoseService;
import com.starsea.im.aggregation.transfor.Transformer;
import com.starsea.im.aggregation.util.ServiceResult;
import com.starsea.im.biz.entity.StudyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by danny on 16/4/28.
 */
@Controller
@RequestMapping("/diagnose")
public class DiagnoseController extends AjaxBase{

    @Autowired
    DiagnoseService diagnoseService;


    @RequestMapping(value = "/addStudyForm", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult addStudyForm(HttpServletRequest req,
                                 @RequestParam(value = "myName") String name,
                                 @RequestParam(value = "sex") String sex,
                                 @RequestParam(value = "myClass") String myClass,
                                 @RequestParam(value = "school") String school,
                                 @RequestParam(value = "organization") String organization,
                                 @RequestParam(value = "evaluationPerson") String evaluationPerson,
                                 @RequestParam(value = "evaluationTime") String evaluationTime,
                                 @RequestParam(value = "hc[]") int[] hc,
                                 @RequestParam(value = "xf1") int xf1) throws ParseException {

        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        serviceResult.setMsg("ok");

        StudyForm studyForm = Transformer.enrichStudyForm(name, sex, myClass, school, organization, evaluationPerson, evaluationTime, hc);
        serviceResult.setMsg(diagnoseService.addStudyForm(studyForm));
        return setResponseData(serviceResult);
    }

    @RequestMapping(value = "/getStudyForm", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult getStudyForm() {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        serviceResult.setMsg(diagnoseService.queryStudyForm());
        return setResponseData(serviceResult);
    }

    @RequestMapping(value = "/getLastStudyForm", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult getLastStudyForm(@RequestParam(value = "name") String name) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        serviceResult.setMsg(diagnoseService.queryLastStudyFormByName("黑仔二号"));
        return setResponseData(serviceResult);
    }



}
