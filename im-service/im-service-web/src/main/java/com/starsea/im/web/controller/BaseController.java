package com.starsea.im.web.controller;

import com.starsea.im.aggregation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by beigua on 2015/8/5.
 */
@Controller("baseController")
public class BaseController {

    @Autowired
    private UserService userService;
        @RequestMapping(value = "/home",method = RequestMethod.GET)
        public String index(HttpServletRequest request){


            String account = request.getParameter("account") ;
            String pwd = request.getParameter("pwd");

            if(userService.isExsit(1) == null){
               return "base";
            }
            return "base";
        }
}
