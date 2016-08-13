package com.starsea.im.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.starsea.im.aggregation.util.ServiceResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/8/10.
 */
@Controller
public class TestController extends AjaxBase {
    public String userName = "abc";

    @RequestMapping("openid")
    public String openid(HttpServletRequest request,HttpServletResponse response) {
        String code = request.getParameter("code");
        String appid = "wx9b08b42b34258af7";
        String secret = "615cbcd9c3b4d7ec4d510fd82b172842";
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
        String  oppid="";
        try {
            oppid = new HttpRequestor().doGet(requestUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("oppid:"+oppid);
        Cookie cookie_id=new Cookie("openid",oppid);
        response.addCookie(cookie_id);
        request.setAttribute("openID", oppid);
        return "openid";
    }

    @RequestMapping(value = "queryOpenId", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult queryOpenId(@RequestParam String openid) {
        ServiceResult serviceResult = new ServiceResult();
        if (openid.equals("123")) {
            serviceResult.setCode(500);
            serviceResult.setMsg("error");
        } else {
            serviceResult.setCode(200);
            serviceResult.setMsg("黑仔一号");
        }
        return setResponseData(serviceResult);
    }

}
