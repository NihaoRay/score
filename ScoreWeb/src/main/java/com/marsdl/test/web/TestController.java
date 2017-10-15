package com.marsdl.test.web;

import com.marsdl.test.pojo.Test;
import com.marsdl.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;

@Controller
@RequestMapping(value="/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value="/test")
    @ResponseBody
    public Test test(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") String id) {
        Test test = testService.get(id);
        return test;
    }
}
