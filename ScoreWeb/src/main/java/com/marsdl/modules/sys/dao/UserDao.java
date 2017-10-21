package com.marsdl.modules.sys.dao;

import com.marsdl.common.annotation.MyBatisDao;
import com.marsdl.modules.sys.entity.User;

@MyBatisDao
public interface UserDao {

    void insert(User user);

}
