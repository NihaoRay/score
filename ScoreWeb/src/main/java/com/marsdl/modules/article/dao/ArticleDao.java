package com.marsdl.modules.article.dao;

import com.marsdl.common.annotation.MyBatisDao;
import com.marsdl.modules.article.entity.Article;
import com.marsdl.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

/**
 * <p>titile 文章基本信息</p>
 * <p>@description </p>
 *
 * @author chenrui
 * @since 2018/1/28
 */
@MyBatisDao
public interface ArticleDao extends BaseDao<Article> {

    /**
     * 发布文章
     * @param id
     */
    public void publishArticle(@Param("id") String id);

    /**
     * 根据id获得文章信息和内容
     * @param id
     * @return
     */
    public Article queryObjectContent(@Param("id")String id);
}
