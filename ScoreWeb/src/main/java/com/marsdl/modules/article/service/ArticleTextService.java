package com.marsdl.modules.article.service;

import com.marsdl.common.service.CrudService;
import com.marsdl.modules.article.dao.ArticleDao;
import com.marsdl.modules.article.dao.ArticleTextDao;
import com.marsdl.modules.article.entity.Article;
import com.marsdl.modules.article.entity.ArticleText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>titile  </p>
 * <p>@description </p>
 *
 * @author chenrui
 * @since 2018/1/31
 */
@Service
@Transactional(readOnly = true)
public class ArticleTextService extends CrudService<ArticleTextDao, ArticleText>{

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ArticleTextDao articleTexDao;

}
