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

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = false)
    public boolean insert(User user) {
        if(StringUtils.isBlank(user.getId())) {
            user.setId(IdGen.uuid());
            user.setCreateDate(new Date());
            try{
                userDao.insert(user);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            //发送邮件
            if(StringUtils.isNotBlank(user.getEmail()) && StringUtils.isNotBlank(user.getUsername())) {
                SendMailUtil.sendEmail(user.getEmail(), user.getUsername());
            } else {
                return false;
            }
        } //在id不为null时，可以执行修改功能
        return true;
    }
}
