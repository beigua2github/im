package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.service.OpenIdService;
import com.starsea.im.aggregation.util.HttpRequestor;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/8/14.
 */
@Service
public class OpenIdServiceImpl implements OpenIdService{
    public String getOpenId(String code) {
        String appid="wxf606eeb0e062cec4";
        String secret = "4bec6eee61f9d6400febb0c27bc40118 ";
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
        String  json="";
        try {
            json = new HttpRequestor().doGet(requestUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        json="{'dsad':'dasdsa','dsfsa':'cdsvs','openid':'3543csdcuuwd89','cds':'cdcs'}";
        int start=json.indexOf("openid")+9;
        int end=json.indexOf(",",start)-1;
        String openid=json.substring(start,end);//提取openid
        return  openid;
    }
}
