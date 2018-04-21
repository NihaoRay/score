package com.marsdl.modules.sys.service;

import com.marsdl.common.service.CrudService;
import com.marsdl.modules.sys.dao.UserDao;
import com.marsdl.modules.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService extends CrudService<UserDao, User> {

    @Autowired
    private UserDao userDao;

    public List<User> findByEntityParams(User user) {
        List<User> list = null;
        try{
            list = userDao.findByEntityParams(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public User findUserByUsername(String username) {
        User user = null;
        try{
            user = userDao.queryObjectByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }
    /*@Transactional(readOnly = false)
    public boolean insert(User user) {
        try {
            userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }*/

    /**
     * 删除
     * @param user
     */
    @Transactional(readOnly = false)
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional(readOnly = false)
    public void update(User user) {
        userDao.update(user);
    }
}
