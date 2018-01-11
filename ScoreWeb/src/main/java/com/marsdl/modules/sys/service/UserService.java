package com.marsdl.modules.sys.service;

import com.marsdl.common.util.IPUtil;
import com.marsdl.common.util.IdGen;
import com.marsdl.common.util.SendMailUtil;
import com.marsdl.modules.sys.dao.UserDao;
import com.marsdl.modules.sys.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserDao userDao;

    public User get(User user) {
        User sysUser = userDao.get(user);
        return sysUser;
    }

    public List<User> findByEntityParams(User user) {
        return userDao.findByEntityParams(user);
    }

    @Transactional(readOnly = false)
    public boolean insert(User user) {
        if (StringUtils.isBlank(user.getId())) {
            user.setId(IdGen.uuid());
            user.setCreateDate(new Date());
            //验证用户必填邮箱和用户名
            boolean isSave = StringUtils.isNotBlank(user.getEmail()) && StringUtils.isNotBlank(user.getUsername());
            try {
                if (isSave) {
                    userDao.insert(user);
                    SendMailUtil.sendEmail(user.getEmail(), user.getUsername());
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } //在id不为null时，可以执行修改功能
        return true;
    }

}
