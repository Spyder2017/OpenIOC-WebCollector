package com.collector.dao;

import com.collector.domain.Article;
import com.collector.utils.database.DBHelper;

import javax.servlet.jsp.jstl.sql.Result;
import java.util.SortedMap;

/**
 * Created by root on 17-6-15.
 * 1.ArticleDao主要通过访问mysql数据库spider中articles表
 * 2.通过selectSql查询语句获取一条需要更新的博客正文内容的记录
 * 3.通过该记录的html信息，调用webcollctor的getContextByHtml接口进行获取博客正文内容
 * 4.通过updateSql将该记录对应的博客正文内容，更新到数据库中
 */
public class ArticleDao {
    /**
     * is_extract 代表是否获取过正文内容 0 表示未获取  1 表示已获取
     * count代表获取次数，如果count大于1表示获取了多次，如果大于10表示获取了10次仍然未成功，那么则表示该记录无法通过webcollctor获取博客正文内容。需要进行人工干预
     * selectSql获取一条满足要求的记录
     */
    private static String selectSql = "select id,url,count,html from articles where is_extract=0 and count<10 limit 1;";
    private static String updateSql = "update articles set body =? , is_extract =1 ,count = ? where id=?;";

    /**
     * 通过updateSql将该记录对应的博客正文内容，更新到数据库中
     * @param article
     * @return
     */
    public boolean updateContent(Article article){
        int res = DBHelper.executeNonQuery(updateSql,new Object[]{article.getBody(),article.getCount(),article.getId()});
        if(res >0){
            return true;
        }
        return false;
    }
    /**
     * 通过selectSql查询语句获取一条需要更新博客正文内容的记录
     * @return
     */
    public Article select(){
        Result result = DBHelper.executeQuery(selectSql);
        for(SortedMap item : result.getRows()) {
            Article article = new Article();

            article.setId(item.get("id").toString());
//            article.setUrl(item.get("url").toString());

            article.setCount(Integer.parseInt(item.get("count").toString())+1);
            article.setHtml(item.get("html").toString());
            article.setBody(ExtractorContext.getContextByHtml(article.getHtml()));
            return article;
        }
        return null;

    }

}
