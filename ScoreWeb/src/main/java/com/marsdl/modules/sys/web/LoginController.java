package com.marsdl.modules.sys.web;

import com.marsdl.common.persistence.ActionResult;
import com.marsdl.common.util.ImgCode;
import com.marsdl.common.util.MD5;
import com.marsdl.common.util.RetCode;
import com.marsdl.common.util.SessionKey;
import com.marsdl.modules.sys.entity.User;
import com.marsdl.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description
 * @Author chenrui
 * @since 2017/12/31
 */

@Controller
@RequestMapping("/user/")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @param logincode
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="login")
    @ResponseBody
    public ActionResult login(User user, String logincode, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionResult result = new ActionResult();

        //根据用户名或者邮箱获得用户列表
        List<User> userList = userService.findByEntityParams(user);
        //校验验证码
        String loginCodeInsession = (String) request.getSession().getAttribute("RANDOMVALIDATECODEKEY");
        //判断验证码是否正确
        boolean isCode = false;
        if(loginCodeInsession.equals(logincode)) {
            isCode = true;
        }
        //验证码输入正确
        if(isCode) {
            if(!userList.isEmpty()) {
                //获取当前用户
                User currentUser = userList.get(0);
                MD5 md5 = new MD5();
                //下面是验证用户输入的密码与库中的密码是否一致 md5.getMD5ofStr(user.getPassword())
                if(user.getPassword().equals(currentUser.getPassword())) {
                    user = currentUser;
                    request.getSession(true).setAttribute(SessionKey.SYS_USER, user);
                   /* request.getSession(true).setAttribute(SessionKey.SYS_ROLE, sysUserRoles);
                    request.getSession(true).setAttribute(SessionKey.SYS_USER_NAME, sysUser.getRealName());*/
                   result.setSuccess(true);
                   result.setMessage(RetCode.LOGIN_SUCCESS);
                }
                else {
                    result.setSuccess(false);
                    result.setMessage(RetCode.ERROR_PASSWORD);
                }
            }
            else {
                result.setSuccess(false);
                result.setMessage(RetCode.NO_USER);
            }
        }
        else {
            result.setSuccess(true);
            result.setMessage(RetCode.ERRORCODE);
        }
        return result;
    }

    /**
     * 生成验证码
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping(value = "getCode")
    public void getCode(HttpServletResponse response, HttpServletRequest request) throws Exception {
        ImgCode imgCode = new ImgCode();
        imgCode.getRandCode(request, response);
    }

    @RequestMapping("loginOut")
    public String loginOut(HttpServletRequest request) throws Exception {
        request.getSession(true).removeAttribute(SessionKey.SYS_USER);
        request.getSession(true).removeAttribute(SessionKey.SYS_ROLE);
        return "/view/sign/login";
    }

}
