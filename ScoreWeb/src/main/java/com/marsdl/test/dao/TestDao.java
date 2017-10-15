package com.marsdl.test.dao;

import com.marsdl.common.annotation.MyBatisDao;
import com.marsdl.test.pojo.Test;

@MyBatisDao
public interface TestDao {

    public Test get(String id);

}
