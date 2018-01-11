package com.marsdl.modules.article.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author chenrui
 * @since 2018/1/4
 */
@Controller
@RequestMapping("/article/")
public class ArticleController {

    @RequestMapping(value = "addArticle")
    public String addArtilce(HttpServletRequest request, HttpServletResponse response) {

        return "/WEB-INF/view/article/add-article";
    }

}
