package com.starsea.im.biz.dao;

import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.annotation.Single;
import com.starsea.im.biz.entity.UserEneryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/8/24.
 */
@Repository
@Single
public interface UserEneryDao {
    @DataSource("write")
    public int addUserEnery(UserEneryEntity userEneryEntity);

    @DataSource("read")
    public UserEneryEntity queryEneryByOpenId(String openId);

    public int addScore(UserEneryEntity userEneryEntity);
}
