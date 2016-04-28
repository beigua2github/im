package com.starsea.im.web.controller;

import com.starsea.im.aggregation.service.UserService;
import com.starsea.im.aggregation.transfor.Transformer;
import com.starsea.im.aggregation.util.ServiceResult;
import com.starsea.im.biz.entity.Student;
import com.starsea.im.biz.entity.StudyForm;
import com.starsea.im.biz.entity.WatchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by danny on 16/4/4.
 */
@Controller
@RequestMapping("/HelloWeb")
public class StudentController extends AjaxBase {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView student() {
      return new ModelAndView("student", "command", new Student());
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb") Student student,
                             ModelMap model) {
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("id", student.getId());
        return "result";
    }


    @RequestMapping(value = "/addForm", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult addForm(HttpServletRequest req,
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
        serviceResult.setMsg(userService.addStudyForm(studyForm));
        return setResponseData(serviceResult);
    }


    @RequestMapping(value = "/getLastStudyForm", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult getLastStudyForm() {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        serviceResult.setMsg(userService.queryLastStudyFormByName("黑仔二号"));
        return setResponseData(serviceResult);
    }

    @RequestMapping(value = "/getStudyForm", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult getStudyForm() {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        serviceResult.setMsg(userService.queryStudyForm());
        return setResponseData(serviceResult);
    }


    @RequestMapping(value = "/addWatch", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult addDiagnose(HttpServletRequest req,
                                     @RequestParam(value = "name") String name,
                                     @RequestParam(value = "evaluationPerson") String evaluationPerson,
                                     @RequestParam(value = "evaluationTime") String evaluationTime,
                                     @RequestParam(value = "now_score[]") int[] now_score,
                                     @RequestParam(value = "now_comment[]") String[] now_comment
    ) throws ParseException {

        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        WatchForm watchForm = Transformer.enrichWatchForm(name, evaluationPerson, evaluationTime, now_score, now_comment);
        serviceResult.setMsg(userService.addWatchForm(watchForm));
        return setResponseData(serviceResult);
    }

    @RequestMapping(value = "/getWatchForm", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult getWatchForm(@RequestParam(value = "name") String name) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        serviceResult.setMsg(userService.queryLastWatchFormByName("黑仔一号"));
        return setResponseData(serviceResult);
    }

}
