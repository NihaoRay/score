package com.marsdl.modules.article.entity;

import com.marsdl.common.persistence.DataEntity;

import java.util.Date;

/**
 * <p>titile 文章基本信息  </p>
 * <p>@description </p>
 *
 * @author chenrui
 * @since 2018/1/28
 */
public class Article extends DataEntity<Article>{

    /**
     *  a.id as "id",
     a.title as "title",
     a.link as "link",
     a.color as "color",
     a.title_image as "titleImage",
     a.keywords as "keywords",
     a.weight as "weight",
     a.posid as "posid",
     a.is_publish as "isPublish",
     a.update_date as "updateDate",
     a.create_date as "createDate",
     a.remarks as "remarks",
     a.del_flag as "delFlag"
     */
    private String title;   //文章标题
    private String link;    //链接
    private String color;   //颜色
    private String titleImage;  //标题图片
    private String keywords;    //关键词
    private ArticleText textId;  //文本的id
    private Integer hits;   //点击率
    private String weight;  //权重
    private String posid;   //位置id
    private String isPublish;//是否发布

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPosid() {
        return posid;
    }

    public void setPosid(String posid) {
        this.posid = posid;
    }

    public String getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish;
    }

    public ArticleText getTextId() {
        return textId;
    }

    public void setTextId(ArticleText textId) {
        this.textId = textId;
    }
}
