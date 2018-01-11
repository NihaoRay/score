package com.marsdl.modules.sys.dao;

import com.marsdl.common.annotation.MyBatisDao;
import com.marsdl.modules.sys.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@MyBatisDao
public interface UserDao {

    void insert(User user);

    List<User> findByEntityParams(User user);

    User get(User user);
}
