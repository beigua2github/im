package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.dto.WatchFormDto;
import com.starsea.im.aggregation.transfor.Transformer;
import com.starsea.im.aggregation.util.MathToolsUtil;
import com.starsea.im.biz.dao.WatchDao;
import com.starsea.im.biz.entity.WatchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

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

    @Override
    public List<WatchFormDto> queryLastWatchFormByNameWeek(String name) {
        Date fDateEnd = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fDateEnd);
        cal.add(Calendar.DAY_OF_MONTH, -7);
        Date fDateStart = cal.getTime();

        List<WatchForm> watchForms = watchDao.queryLastWatchFormByNameWeek(name, fDateStart, fDateEnd);
        List<WatchFormDto> watchFormDtos = new ArrayList<WatchFormDto>();
        if(watchForms.size()!= 0){

            for (WatchForm watchForm:watchForms){
                WatchFormDto watchFormDto = Transformer.convertWatchFormDtoFromWatchForm(watchForm);
                watchFormDtos.add(watchFormDto);
            }

        }
        return watchFormDtos;

    }


    @Override
    public List<WatchFormDto> queryLastWatchFormByNameMonth(String name) {
        Date fDateEnd = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fDateEnd);
        cal.add(Calendar.MONTH, -1);
        Date fDateStart = cal.getTime();

        List<WatchForm> watchForms = watchDao.queryLastWatchFormByNameWeek(name,fDateStart,fDateEnd);
        List<WatchFormDto> watchFormDtos = new ArrayList<WatchFormDto>();
        if(watchForms.size()!= 0){

            for (WatchForm watchForm:watchForms){
                WatchFormDto watchFormDto = Transformer.convertWatchFormDtoFromWatchForm(watchForm);
                watchFormDtos.add(watchFormDto);
            }

        }
        return watchFormDtos;

    }


    @Override
    public Long queryAvgWatchFormByNameDay(String name,int day) {
        Date fDateEnd = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fDateEnd);
        cal.add(Calendar.DATE, -(day));
        Date fDateStart = cal.getTime();

        List<WatchForm> watchForms = watchDao.queryLastWatchFormByNameWeek(name, fDateStart, fDateEnd);
        List<WatchFormDto> watchFormDtos = new ArrayList<WatchFormDto>();
        List<Integer> avgWatchForm = new ArrayList<Integer>();
        if(watchForms.size()!= 0){

            for (WatchForm watchForm:watchForms){
                WatchFormDto watchFormDto = Transformer.convertWatchFormDtoFromWatchForm(watchForm);
                watchFormDtos.add(watchFormDto);
            }

            for(WatchFormDto watchFormDto:watchFormDtos){
                Long temp = MathToolsUtil.getAvg(Transformer.converListFromIntArray(watchFormDto.getNow_score()));
                avgWatchForm.add(Integer.parseInt(temp.toString()));
            }
        }

        Long avg = MathToolsUtil.getAvg(avgWatchForm);

        return avg;
    }


}
