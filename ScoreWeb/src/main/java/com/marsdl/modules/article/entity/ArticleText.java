package com.marsdl.modules.article.entity;

import com.marsdl.common.persistence.DataEntity;

/**
 * <p>titile  文本文章内容</p>
 * <p>@description </p>
 *
 * @author chenrui
 * @since 2018/1/28
 */
public class ArticleText  extends DataEntity<ArticleText>{

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
