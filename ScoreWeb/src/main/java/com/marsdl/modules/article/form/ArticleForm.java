package com.marsdl.modules.article.form;

import com.marsdl.modules.article.entity.Article;
import com.marsdl.modules.article.entity.ArticleText;

/**
 * <p>titile  </p>
 * <p>@description </p>
 *
 * @author chenrui
 * @since 2018/1/31
 */
public class ArticleForm {

    private Article article;
    private ArticleText articleText;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public ArticleText getArticleText() {
        return articleText;
    }

    public void setArticleText(ArticleText articleText) {
        this.articleText = articleText;
    }
}
