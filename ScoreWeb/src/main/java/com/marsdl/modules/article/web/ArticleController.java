package com.marsdl.modules.article.web;

import com.marsdl.common.persistence.ActionResult;
import com.marsdl.common.util.RetCode;
import com.marsdl.modules.article.entity.Article;
import com.marsdl.modules.article.form.ArticleForm;
import com.marsdl.modules.article.service.ArticleService;
import com.marsdl.modules.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>@description 文章模块</p>
 * @author chenrui
 * @since 2018/1/4
 */
@Controller
@RequestMapping("/article/")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "addArticle")
    public String addArtilce(User user, HttpServletRequest request, HttpServletResponse response) {

        return null;
    }

    @RequestMapping("/save")
    @ResponseBody
    public ActionResult save(Article article, HttpServletRequest request, HttpServletResponse response) {
        ActionResult result = new ActionResult();
        articleService.saveArticle(article, request, response);
        result.setCode(RetCode.SUCCESS_CODE);
        result.setMessage(RetCode.SUCCESS);
        result.setResult(article);
        return result;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public ActionResult upload (@RequestParam("file") MultipartFile file) {
        /*if(file.isEmpty()) {

        }*/
        ActionResult result = new ActionResult();

        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String url = "/img/sys/logon.png";
        result.setCode(RetCode.SUCCESS_CODE);
        result.setResult(url);

        return result;
    }

}
