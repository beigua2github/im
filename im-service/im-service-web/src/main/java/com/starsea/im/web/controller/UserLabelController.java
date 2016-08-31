package com.starsea.im.web.controller;

import com.starsea.im.aggregation.service.UserLabelService;
import com.starsea.im.aggregation.util.ServiceResult;
import com.starsea.im.biz.entity.LabelEntity;
import com.starsea.im.biz.entity.UserLabelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by danny on 16/8/20.
 */

@Controller
@RequestMapping("/userlabel")
public class UserLabelController extends AjaxBase{

    @Autowired
    private  UserLabelService userLabelService;


    @RequestMapping(value = "/addUserLabel", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult addLabel(HttpServletRequest request,
                                  @RequestParam("openId") String openId,
                                  @RequestParam("labelId") Integer labelId) {
        ServiceResult serviceResult = new ServiceResult();
        UserLabelEntity userLabelEntity = new UserLabelEntity();
        userLabelEntity.setOpenId(openId);
        userLabelEntity.setLabelId(labelId);
        serviceResult.setMsg(userLabelService.addUserLabel(userLabelEntity));
        serviceResult.setCode(200);
        return setResponseData(serviceResult);
    }

    @RequestMapping(value = "/getLabelByOpenId",method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult getLabelByOpenId(HttpServletRequest req,
                                  @RequestParam("openId") String openId){
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setMsg(userLabelService.queryLabelByOpenId(openId));
        serviceResult.setCode(200);
        return setResponseData(serviceResult);
    }


    @RequestMapping(value = "/queryEnergyByOpenId",method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult queryEnergyByOpenId(HttpServletRequest req,
                                          @RequestParam("openId") String openId){
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setMsg(userLabelService.queryEnergyByOpenId(openId));
        serviceResult.setCode(200);
        return setResponseData(serviceResult);
    }




}
