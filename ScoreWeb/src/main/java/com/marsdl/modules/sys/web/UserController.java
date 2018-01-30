package com.marsdl.modules.sys.web;

import com.marsdl.common.persistence.ActionResult;
import com.marsdl.common.util.IPUtil;
import com.marsdl.common.util.RetCode;
import com.marsdl.modules.sys.entity.User;
import com.marsdl.modules.sys.service.UserService;
import com.marsdl.modules.sys.util.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute
    public User get(@RequestParam(required=false) String id) {
        if (StringUtils.isNotBlank(id)){
            return userService.get(id);
        }else{
            return new User();
        }
    }

    /**
     * 根据id获得用户对象
     * 经过持久层
     * @param user
     * @return
     */
    @RequestMapping("get")
    @ResponseBody
    public User get(User user) {
        User sysUser = null;
        try{
            sysUser= userService.get(user);
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
        return sysUser;
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
        User currentUser = UserUtil.getUser();
        User userparam = user.getCurrentUser();
        UserUtil.get("1");
      /*  UserUtil.clearCache(userparam);*/

        User nochache = UserUtil.getUser();
        User userparamcache = user.getCurrentUser();

        ActionResult actionResult = new ActionResult();
        /*userService.update(user);*/
        actionResult.setMessage(RetCode.SUCCESS);
        return actionResult;
    }
}
