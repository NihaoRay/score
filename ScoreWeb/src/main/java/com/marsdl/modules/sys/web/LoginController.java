package com.marsdl.modules.sys.web;

import com.marsdl.common.persistence.ActionResult;
import com.marsdl.common.util.ImgCode;
import com.marsdl.common.util.RetCode;
import com.marsdl.common.util.SessionKey;
import com.marsdl.modules.sys.entity.User;
import com.marsdl.modules.sys.service.UserService;
import com.marsdl.modules.sys.util.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author chenrui
 * @since 2017/12/31
 */

@Controller
@RequestMapping("/sys/")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="login")
    @ResponseBody
    public ActionResult login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionResult result = new ActionResult();
        try{
            Subject subject = UserUtil.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            result.setMessage(RetCode.LOGIN_SUCCESS);
        } catch (UnknownAccountException e) {
            result.setMessage(RetCode.NO_USER);
        } catch (IncorrectCredentialsException e) {
            result.setMessage(RetCode.ERROR_PASSWORD);
        } catch (AuthenticationException e) {
            result.setMessage(RetCode.ERROR);
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

    @RequestMapping(value="logout")
    public String logout() {
        //首先清除当前用户信息缓存
        /*UserUtil.clearCache(UserUtil.getUser());*/
        //然后清除shiro系统的缓存
        /*UserUtil.clearCache();*/

        SecurityUtils.getSubject().logout();
        return "redirect: /index.html";
    }

}
