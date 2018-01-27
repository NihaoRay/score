package com.marsdl.modules.article.web;

import com.marsdl.common.persistence.ActionResult;
import com.marsdl.common.util.RetCode;
import com.marsdl.modules.sys.entity.User;
import com.marsdl.modules.sys.util.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

/**
 * <p>@description 文章模块</p>
 * @author chenrui
 * @since 2018/1/4
 */
@Controller
@RequestMapping("/article/")
public class ArticleController {

    @RequestMapping(value = "addArticle")
    public String addArtilce(User user, HttpServletRequest request, HttpServletResponse response) {

        return null;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public ActionResult upload (@RequestParam("file") MultipartFile file) {
        /*if(file.isEmpty()) {

        }*/
        ActionResult result = new ActionResult();

        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String url = "/img/sys/logon.png";
        result.setCode(0);
        result.setMessage(url);

        return result;
    }

}
