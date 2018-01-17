package com.marsdl.modules.sys.web;

import com.marsdl.common.persistence.ActionResult;
import com.marsdl.common.util.ImgCode;
import com.marsdl.common.util.SessionKey;
import com.marsdl.modules.sys.entity.User;
import com.marsdl.modules.sys.service.UserService;
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
     * @param user
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="login")
    public String login(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String failure = (String) request.getAttribute("shiroLoginFailure");

        return "/view/sign/login";
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
