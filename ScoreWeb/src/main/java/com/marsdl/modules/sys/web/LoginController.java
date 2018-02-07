package com.marsdl.modules.sys.web;

import com.marsdl.common.persistence.ActionResult;
import com.marsdl.common.util.ImgCode;
import com.marsdl.common.util.RetCode;
import com.marsdl.modules.sys.entity.User;
import com.marsdl.modules.sys.service.UserService;
import com.marsdl.modules.sys.util.UserUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>titile  返回数据</p>
 * <p>@description </p>
 *
 * @author chenrui
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
            //获得shiro访问栈顶的url
            String url = null;
            //获得栈顶的url可能会出现异常
            try{
                //获得shiro访问栈顶的url
                url = WebUtils.getSavedRequest(request).getRequestUrl();
            } catch (Exception e) {
                url = null;
            }
            if(StringUtils.isNotBlank(url)) {
                result.setResult(url);
            }
            //封装返回的编码
            result.setMessage(RetCode.LOGIN_SUCCESS);
            result.setCode(RetCode.LOGIN_SUCCESS_CODE);
        } catch (UnknownAccountException e) {

            result.setMessage(RetCode.NO_USER);
            result.setCode(RetCode.NO_USER_CODE);
        } catch (IncorrectCredentialsException e) {

            result.setMessage(RetCode.ERROR_PASSWORD);
            result.setCode(RetCode.ERROR_PASSWORD_CODE);
        } catch (AuthenticationException e) {

            result.setMessage(RetCode.ERROR);
            result.setCode(RetCode.ERROR_CODE);
        }
        return result;
    }

    /**
     * 获取当前的用户，从缓存中调用，不经过数据库
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("getCurrentUser")
    @ResponseBody
    public ActionResult getCurrentUser(HttpServletRequest request, HttpServletResponse response) {
        ActionResult result = new ActionResult();
        User sysUser = UserUtil.getUser();
        if(StringUtils.isNotBlank(sysUser.getUsername())) {
            result.setResult(sysUser);
            return result;
        }
        result.setMessage(RetCode.NO_USER);
        result.setCode(RetCode.NO_USER_CODE);
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
        UserUtil.clearCache(UserUtil.getUser());
        //然后清除shiro系统的缓存
        UserUtil.clearCache();
        SecurityUtils.getSubject().logout();
        return "redirect:/index.html";
    }

}
