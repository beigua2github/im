package com.starsea.im.web.controller;

import com.starsea.im.aggregation.service.UserService;
import com.starsea.im.biz.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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


}
