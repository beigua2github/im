package com.starsea.im.biz.dao;

import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.annotation.Single;
import com.starsea.im.biz.entity.WatchForm;
import org.springframework.stereotype.Repository;

/**
 * Created by danny on 16/4/28.
 */

@Repository
@Single
public interface WatchDao {

    @DataSource("write")
    public  int addWatchForm(WatchForm watchForm);

    @DataSource("read")
    public WatchForm queryLastWatchFormByName(String name);
}
