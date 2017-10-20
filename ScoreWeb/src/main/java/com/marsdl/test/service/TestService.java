package com.marsdl.test.service;

import com.marsdl.test.dao.TestDao;
import com.marsdl.test.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    @Transactional(readOnly = true)
    public Test get(Test test) throws Exception {
        Test testU = testDao.get(test);
        return testU;
    }

}
