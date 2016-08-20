package com.starsea.im.biz.dao;

import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.annotation.Single;
import com.starsea.im.biz.entity.UserLabelEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by danny on 16/8/20.
 */

@Repository
@Single
public interface UserLabelDao {
    @DataSource("write")
    public int addUserLabel(UserLabelEntity userLabelEntity);

    @DataSource("read")
    public List<Integer> queryLabelByOpenId(String openId);


}
