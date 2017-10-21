package com.marsdl.modules.sys.service;

import com.marsdl.common.util.IdGen;
import com.marsdl.modules.sys.dao.UserDao;
import com.marsdl.modules.sys.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = false)
    public void insert(User user) {
        if(StringUtils.isBlank(user.getId())) {
            user.setId(IdGen.uuid());
            userDao.insert(user);
        }
    }
}
