package com.starsea.im.biz.dao;

import com.starsea.im.biz.annotation.DataSource;
import com.starsea.im.biz.annotation.Single;
import com.starsea.im.biz.entity.DiagnoseForm;
import com.starsea.im.biz.entity.StudyForm;
import com.starsea.im.biz.entity.UserEntity;
import com.starsea.im.biz.entity.WatchForm;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by beigua on 2015/8/5.
 */
@Repository
@Single
public interface UserDao {
    @DataSource("write")
    public UserEntity queryUser(int id);

    @DataSource("read")
    public List<UserEntity> queryUsers();

    //使用@Insert注解指明add方法要执行的SQL
//    @Insert("insert into users(email, password) values(#{email}, #{password})")
    @DataSource("write")
    public int addUser(UserEntity user);

    @DataSource("write")
    public int addStudyFormByTeacher(StudyForm studyForm);

    @DataSource("read")
    public List<StudyForm> queryStudyFormByTeacher();

    @DataSource("read")
    public StudyForm queryLastStudyFormByName(String name);

    @DataSource("write")
    public  int addWatchForm(WatchForm watchForm);

    @DataSource("read")
    public WatchForm queryLastWatchFormByName(String name);
}
