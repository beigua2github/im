package com.starsea.im.web.controller;


import com.starsea.im.aggregation.service.OpenIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by Administrator on 2016/8/10.
 */
@Controller
public class OpenIdController extends AjaxBase {

    @Autowired
    OpenIdService openIdService;

    @RequestMapping("openid")
    public String openid(HttpServletRequest request) {
        String code = request.getParameter("code");
        String openid=openIdService.getOpenId(code);
        request.setAttribute("openID", openid);
        return "openid";
    }

}
