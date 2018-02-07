package com.marsdl.modules.article.webnotauth;

import com.marsdl.common.persistence.ActionResult;
import com.marsdl.common.util.RetCode;
import com.marsdl.modules.article.entity.Article;
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
import java.util.List;

/**
 * <p>@description 文章模块</p>
 * @author chenrui
 * @since 2018/1/4
 */
@Controller
@RequestMapping("/notauth/article/")
public class ArticleNotauthController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "getArticle")
    @ResponseBody
    public ActionResult addArtilce(Article article, HttpServletRequest request, HttpServletResponse response) {
        ActionResult result = new ActionResult();
        Article articleText = articleService.getArticleContent(article);
        result.setResult(articleText);
        result.setCode(RetCode.SUCCESS_CODE);
        return result;
    }

    @RequestMapping(value = "queryList")
    @ResponseBody
    public ActionResult queryList(Article article, HttpServletRequest request, HttpServletResponse response) {
        ActionResult result = new ActionResult();
        List<Article> list = articleService.queryList(article);
        result.setResult(list);
        return result;
    }

}
