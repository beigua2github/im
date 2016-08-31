package com.starsea.im.biz.dao;

import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.annotation.Single;
import com.starsea.im.biz.entity.WatchForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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

    @DataSource("read")
    public WatchForm queryWatchFormByOpenId(String openId);

    @DataSource("read")
    public List<WatchForm> queryLastWatchFormByNameWeek(@Param("name") String name, @Param("dateStart") Date dateStart,@Param("dateEnd") Date dateEnd);

    @DataSource("read")
    public List<WatchForm> queryLastWatchFormByOpenIdWeek(@Param("openId") String openId, @Param("dateStart") Date dateStart,@Param("dateEnd") Date dateEnd);

}
