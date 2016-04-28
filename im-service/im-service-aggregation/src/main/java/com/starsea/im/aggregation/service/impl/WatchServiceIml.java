package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.dto.WatchFormDto;
import com.starsea.im.aggregation.transfor.Transformer;
import com.starsea.im.biz.dao.WatchDao;
import com.starsea.im.biz.entity.WatchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by danny on 16/4/28.
 */
@Service("watchService")
public class WatchServiceIml implements com.starsea.im.aggregation.service.impl.WatchService {


    @Autowired
    private WatchDao watchDao;

    @Override
    public  int addWatchForm(WatchForm watchForm){

        return watchDao.addWatchForm(watchForm);
    }



    @Override
    public WatchFormDto queryLastWatchFormByName(String name) {
        WatchForm watchForm = watchDao.queryLastWatchFormByName(name);
        WatchFormDto watchFormDto = new WatchFormDto();
        if(watchForm!=null){
            watchFormDto =  Transformer.convertWatchFormDtoFromWatchForm(watchForm);
        }
        return watchFormDto;
    }

}
