package com.marsdl.test.service;

import com.marsdl.test.dao.TestDao;
import com.marsdl.test.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public Test get(String id) {
        Test testU = testDao.get(id);
        return testU;
    }

}
