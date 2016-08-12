package com.starsea.im.web.controller;

import com.starsea.im.aggregation.util.ServiceResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/8/10.
 */
@Controller
public class TestController extends AjaxBase{
    public  String userName="abc";

    @RequestMapping("getUserName")
    @ResponseBody
    public ServiceResult getUserName(){
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        serviceResult.setMsg(userName);
        return setResponseData(serviceResult);
    }
    @RequestMapping(value = "queryOpenId",method =RequestMethod.POST)
    @ResponseBody
    public ServiceResult queryOpenId(@RequestParam String openid){
        ServiceResult serviceResult = new ServiceResult();
        if(openid.equals("123")){
           serviceResult.setCode(500);
           serviceResult.setMsg("error");
        }else{
            serviceResult.setCode(200);
            serviceResult.setMsg("黑仔一号");
        }
        return setResponseData(serviceResult);
    }

}
