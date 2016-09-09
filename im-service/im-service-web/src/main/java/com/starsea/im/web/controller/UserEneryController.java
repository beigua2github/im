package com.starsea.im.web.controller;

import com.starsea.im.aggregation.service.UserEneryService;
import com.starsea.im.aggregation.util.ServiceResult;
import com.starsea.im.biz.entity.UserEneryEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/8/24.
 */
@Controller
@RequestMapping("/userenery")
public class UserEneryController extends AjaxBase {
    @Autowired
    private UserEneryService userEneryService;

    @RequestMapping(value = "/addUserEnery", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult addUserEnery(HttpServletRequest request,
                                  @RequestParam("openId") String openId,
                                  @RequestParam("enerySelect") String enerySelect,
                                  @RequestParam("title") String title,
                                  @RequestParam("customResult") String customResult,
                                  @RequestParam(value = "evaluationTime") String evaluationTime) {
        ServiceResult serviceResult = new ServiceResult();
        UserEneryEntity userEneryEntity = new UserEneryEntity();
        userEneryEntity.setOpenId(openId);
        userEneryEntity.setEnerySelect(enerySelect);
        userEneryEntity.setEvaluationTime(evaluationTime);
        userEneryEntity.setTitle(title);
        userEneryEntity.setCustomResult(customResult);
        serviceResult.setMsg(userEneryService.addUserEnery(userEneryEntity));
        serviceResult.setCode(200);
        return setResponseData(serviceResult);
    }


    @RequestMapping(value = "/queryEnergyByOpenId",method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult queryEnergyByOpenId(HttpServletRequest req,
                                             @RequestParam("openId") String openId){
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        serviceResult.setMsg(userEneryService.queryEneryByOpenId(openId));
        return setResponseData(serviceResult);
    }

    @RequestMapping(value = "/addScore", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult addScore(HttpServletRequest request,
                                  @RequestParam("openId") String openId,
                                  @RequestParam("score") String score,
                                  @RequestParam("commont") String commont) {
        ServiceResult serviceResult = new ServiceResult();
        UserEneryEntity userEneryEntity = new UserEneryEntity();
        userEneryEntity.setOpenId(openId);
        userEneryEntity.setScore(score);
        userEneryEntity.setCommont(commont);
        serviceResult.setMsg(userEneryService.addScore(userEneryEntity));
        serviceResult.setCode(200);
        return setResponseData(serviceResult);
    }
}
