package com.starsea.im.web.controller;

import com.starsea.im.aggregation.service.impl.WatchService;
import com.starsea.im.aggregation.transfor.Transformer;
import com.starsea.im.aggregation.util.ServiceResult;
import com.starsea.im.biz.entity.WatchForm;
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
@RequestMapping("/watch")
public class WatchController extends AjaxBase {

    @Autowired
    WatchService watchService;

    @RequestMapping(value = "/addWatch", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult addWatch(HttpServletRequest req,
                                     @RequestParam(value = "name") String name,
                                     @RequestParam(value = "evaluationPerson") String evaluationPerson,
                                     @RequestParam(value = "evaluationTime") String evaluationTime,
                                     @RequestParam(value = "now_score[]") int[] now_score,
                                     @RequestParam(value = "now_comment[]") String[] now_comment
    ) throws ParseException {

        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        WatchForm watchForm = Transformer.enrichWatchForm(name, evaluationPerson, evaluationTime, now_score, now_comment);
        serviceResult.setMsg(watchService.addWatchForm(watchForm));
        return setResponseData(serviceResult);
    }

    @RequestMapping(value = "/getLastWatchForm", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult getLastWatchForm() {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        serviceResult.setMsg(watchService.queryLastWatchFormByName("黑仔一号"));
        return setResponseData(serviceResult);
    }

}
