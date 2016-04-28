package com.starsea.im.aggregation.service.impl;

import com.google.common.collect.Lists;
import com.starsea.im.aggregation.aop.LogParams;
import com.starsea.im.aggregation.dto.SearchDto;
import com.starsea.im.aggregation.dto.StudyFormDto;
import com.starsea.im.aggregation.dto.UserDto;
import com.starsea.im.aggregation.dto.WatchFormDto;
import com.starsea.im.aggregation.transfor.Transformer;
import com.starsea.im.biz.entity.*;
import com.starsea.im.aggregation.service.UserService;
import com.starsea.im.aggregation.transfor.UserTransfor;
import com.starsea.im.biz.dao.UserDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by beigua on 2015/8/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    @LogParams
    public UserDto isExsit(int id){
        UserEntity entity = userDao.queryUser(id);
        UserDto userDto = new UserDto();
        if(entity != null){ BeanUtils.copyProperties(entity, userDto);}
        return userDto;
    }

    @Override
    @LogParams
    public PageModel queryUsersForPage(SearchDto searchDto) {
        return null;
    }

    @Override
    @LogParams
    public List<UserDto> querUsers() {
        return Lists.transform(userDao.queryUsers(), UserTransfor.INSTANCE);
    }

    @Override
    public int insert() {

        return 0;
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }


    @Override
    public int addUser(UserEntity userEntity){
        return userDao.addUser(userEntity);
    }

    @Override
    public int addStudyForm(StudyForm studyForm){
        return userDao.addStudyFormByTeacher(studyForm);
    }

    @Override
    public List<StudyForm> queryStudyForm(){

        return userDao.queryStudyFormByTeacher();
    }

    @Override
    public StudyFormDto queryLastStudyFormByName(String name){

        StudyForm studyForm = userDao.queryLastStudyFormByName(name);
        StudyFormDto studyFormDto = new StudyFormDto();
        if(studyForm != null){
            studyFormDto = Transformer.convertWatchFormDtoFromStudyForm(studyForm);
        }

        return studyFormDto;

    }

    @Override
    public  int addWatchForm(WatchForm watchForm){

        return userDao.addWatchForm(watchForm);
    }



    @Override
    public WatchFormDto queryLastWatchFormByName(String name) {
        WatchForm watchForm = userDao.queryLastWatchFormByName(name);
        WatchFormDto watchFormDto = new WatchFormDto();
        if(watchForm!=null){
            watchFormDto =  Transformer.convertWatchFormDtoFromWatchForm(watchForm);
        }
        return watchFormDto;
    }

}