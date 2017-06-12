package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.service.decodeService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by Administrator on 2016/8/10.
 */
@Service
public class DecodeService implements decodeService {
    public String decode(String name) {
        String ajax_name="";
        try {
            ajax_name= URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ajax_name;
    }
}
