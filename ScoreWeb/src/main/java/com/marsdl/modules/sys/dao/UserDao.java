package com.marsdl.modules.sys.dao;

import com.marsdl.common.annotation.MyBatisDao;
import com.marsdl.modules.sys.entity.User;

import java.util.List;

@MyBatisDao
public interface UserDao {

    void insert(User user);

    List<User> get(User user);

}
