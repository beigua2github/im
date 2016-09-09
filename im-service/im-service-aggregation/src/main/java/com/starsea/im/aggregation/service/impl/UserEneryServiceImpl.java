package com.starsea.im.aggregation.service.impl;

import com.starsea.im.aggregation.service.UserEneryService;
import com.starsea.im.biz.dao.UserEneryDao;
import com.starsea.im.biz.entity.UserEneryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/8/24.
 */
@Service("UserEneryService")
public class UserEneryServiceImpl implements UserEneryService{

    @Autowired
    private UserEneryDao userEneryDao;

    public int addUserEnery(UserEneryEntity userEneryEntity) {
        return userEneryDao.addUserEnery(userEneryEntity);
    }

    public UserEneryEntity queryEneryByOpenId(String openId) {
        UserEneryEntity userEneryEntity=userEneryDao.queryEneryByOpenId(openId);
        return userEneryEntity;
    }

    public int addScore(UserEneryEntity userEneryEntity) {
        return userEneryDao.addScore(userEneryEntity);
    }
}
