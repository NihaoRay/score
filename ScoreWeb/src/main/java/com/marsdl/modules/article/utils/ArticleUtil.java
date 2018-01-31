package com.marsdl.modules.article.utils;

import com.marsdl.common.util.SpringContextHolder;
import com.marsdl.modules.article.dao.ArticleDao;

/**
 * <p>titile  文本文章工具类</p>
 * <p>@description </p>
 *
 * @author chenrui
 * @since 2018/1/31
 */
public class ArticleUtil {

    private static ArticleDao articleDao = SpringContextHolder.getBean(ArticleDao.class);

    public static final String ARTICLE_CACHE = "articleCache";
    public static final String ARTICLE_CACHE_ID = "id_";

}
