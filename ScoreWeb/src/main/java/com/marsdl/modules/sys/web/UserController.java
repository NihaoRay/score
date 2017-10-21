package com.marsdl.modules.sys.web;

import com.marsdl.common.util.RetCode;
import com.marsdl.modules.sys.entity.User;
import com.marsdl.modules.sys.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute
    public User get(@RequestParam(required=false) String id) {
        if (StringUtils.isNotBlank(id)){
            return null;
        }else{
            return new User();
        }
    }

    @RequestMapping(value = "save")
    @ResponseBody
    public String save(User user, HttpServletRequest request) {
        userService.insert(user);
        return RetCode.SUCCESS;
    }

}
