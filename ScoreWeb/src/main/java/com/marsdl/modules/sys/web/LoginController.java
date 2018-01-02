package com.marsdl.modules.sys.web;

import com.marsdl.common.persistence.ActionResult;
import com.marsdl.common.util.ImgCode;
import com.marsdl.modules.sys.entity.User;
import org.apache.commons.lang.StringUtils;
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
@RequestMapping("/user/")
public class LoginController {


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
        //校验验证码
        String loginCodeInsession = (String) request.getSession().getAttribute("RANDOMVALIDATECODEKEY");
        if(loginCodeInsession.equals(logincode)) {
            result.setMessage("成功");
        }
        else {
            result.setMessage("失败");
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

}
