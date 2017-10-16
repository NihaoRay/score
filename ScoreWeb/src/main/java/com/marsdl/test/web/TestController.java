package com.marsdl.test.web;

import com.marsdl.common.mapper.JsonMapper;
import com.marsdl.common.util.IPUtil;
import com.marsdl.common.util.RetCode;
import com.marsdl.test.pojo.Test;
import com.marsdl.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value="/test")
    @ResponseBody
    public String test(HttpServletRequest request, HttpServletResponse response, Test test) throws Exception {
        String ip = IPUtil.getIp(request);
        Test newTest = testService.get(test);
        if(newTest != null) {
            String stringTest = JsonMapper.toJsonString(newTest);
            return stringTest;
        }
        return RetCode.NOTHING;
    }
}
