package com.starsea.im.web.controller;

import com.starsea.im.aggregation.service.AdvantageService;
import com.starsea.im.aggregation.service.decodeService;
import com.starsea.im.aggregation.transfor.Transformer;
import com.starsea.im.aggregation.util.ServiceResult;
import com.starsea.im.biz.entity.AdvantageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

/**
 * Created by danny on 16/5/8.
 */
@Controller
@RequestMapping("/advantage")
public class AdvantageController extends AjaxBase {

    @Autowired
    private AdvantageService advantageService;
    @Autowired
    private decodeService utilService;

    @RequestMapping(value = "/addAdvantageForm", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult addAdvantageForm(
                                        @RequestParam(value = "openId") String openId,
                                        @RequestParam(value = "school") String school,
                                        @RequestParam(value = "myClass") String myClass,
                                        @RequestParam(value = "name") String name,
                                        @RequestParam(value = "sex") String sex,
                                        @RequestParam(value = "age") int age,
                                        @RequestParam(value = "now_score[]") int[] now_score) throws ParseException {

        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        serviceResult.setMsg("ok");

        AdvantageForm advantageForm = Transformer.enrichAdvantage(school, myClass, name, sex, age, openId, now_score);
        serviceResult.setMsg(advantageService.addAdvantageForm(advantageForm));
        return setResponseData(serviceResult);
    }

    @RequestMapping(value = "/getAdvantageForm", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult getAdvantageForm() {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        serviceResult.setMsg(advantageService.queryAdvantageForm());
        return setResponseData(serviceResult);
    }

    @RequestMapping(value = "/getAdvantageFormByName", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult getAdvantageFormByName(@RequestParam(value = "name",defaultValue = "小孟") String name ) {
        name=utilService.decode(name);
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        serviceResult.setMsg(advantageService.queryAdvantageFormByName(name));
        return setResponseData(serviceResult);
    }


    @RequestMapping(value = "/getAdvantageFormByOpenId", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult getAdvantageFormByOpenId(@RequestParam(value = "openId", defaultValue = "test") String openId) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(200);
        serviceResult.setMsg(advantageService.queryAdvantageFormByOpenId(openId));
        return setResponseData(serviceResult);
    }
}
