package com.starsea.im.web.controller;

import com.starsea.im.aggregation.service.LabelService;
import com.starsea.im.aggregation.service.UserService;
import com.starsea.im.aggregation.util.CheckUtil;
import com.starsea.im.aggregation.util.MessageUtil;
import com.starsea.im.aggregation.util.ServiceResult;
import com.starsea.im.biz.entity.LabelEntity;
import com.starsea.im.biz.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/label")
public class LabelController extends AjaxBase{
    @Autowired
    private LabelService labelService;

    @RequestMapping(value = "/addLabel", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult addLabel(HttpServletRequest request,
                                  @RequestParam("openId") String openId,
                                  @RequestParam("labelone") String labelOne,
                                  @RequestParam("labelTwo") String labelTwo,
                                  @RequestParam("content") String content) {
        ServiceResult serviceResult = new ServiceResult();
        LabelEntity labelEntity = new LabelEntity();
        labelEntity.setLabelOne(labelOne);
        labelEntity.setLabelTwo(labelTwo);
        labelEntity.setContent(content);
        serviceResult.setMsg(labelService.addLabel(labelEntity));
        serviceResult.setCode(200);
        return setResponseData(serviceResult);
    }


    @RequestMapping(value = "/getLabel",method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult getLabel(HttpServletRequest req ){
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setMsg(labelService.queryLabel());
        serviceResult.setCode(200);
        return setResponseData(serviceResult);
    }



}
