package com.marsdl.modules.sys.web;

import com.marsdl.common.persistence.ActionResult;
import com.marsdl.common.util.IPUtil;
import com.marsdl.common.util.RetCode;
import com.marsdl.modules.sys.entity.User;
import com.marsdl.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping(value = "findEntityByParams")
    @ResponseBody
    public ActionResult findEntityByParams(User user, HttpServletRequest request, HttpServletResponse response) {
        ActionResult actionResult = new ActionResult();
        userService.findByEntityParams(user);

        actionResult.setMessage("你好，我是陈瑞");

        return actionResult;
    }


    @RequestMapping(value = "delete")
    @ResponseBody
    public ActionResult delete(User user, HttpServletRequest request, HttpServletResponse response) {
        ActionResult actionResult = new ActionResult();
        userService.delete(user);
        actionResult.setMessage(RetCode.SUCCESS);
        return actionResult;
    }

    @RequestMapping(value="update")
    @ResponseBody
    public ActionResult update(User user, HttpServletRequest request, HttpServletResponse response) {
        ActionResult actionResult = new ActionResult();
        userService.update(user);
        actionResult.setMessage(RetCode.SUCCESS);
        return actionResult;
    }
}
