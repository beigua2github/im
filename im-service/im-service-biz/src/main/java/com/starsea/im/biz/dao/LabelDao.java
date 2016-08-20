package com.starsea.im.biz.dao;

import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.annotation.Single;
import com.starsea.im.biz.entity.LabelEntity;
import com.starsea.im.biz.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by danny on 16/8/19.
 */
@Repository
@Single
public interface LabelDao {
    @DataSource("write")
    public int addLabel(LabelEntity labelEntity);

    @DataSource("read")
    public List<LabelEntity> queryLabel();

    @DataSource("read")
    public LabelEntity queryLabelById(int id);


}
