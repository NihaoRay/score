package com.marsdl.modules.sys.web;

import com.marsdl.common.util.IPUtil;
import com.marsdl.common.util.RetCode;
import com.marsdl.modules.sys.entity.User;
import com.marsdl.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("get")
    public String get(User user) {
        User sysUser = userService.get(user);
        return null;
    }

    @RequestMapping(value = "save")
    @ResponseBody
    public String save(User user, HttpServletRequest request) {
        user.setRemarks(IPUtil.getIp(request));
        boolean isSuccess =  userService.insert(user);
        if(isSuccess) {
            return RetCode.SUCCESS;
        } else {
            return RetCode.ERROR;
        }
    }

}
