package com.collector.main;

import com.collector.dao.ArticleDao;
import com.collector.domain.Article;
import com.collector.utils.quarz.LzstoneMain;

/**
 * Created by root on 17-6-16.
 * 程序入口
 */
public class Main {
    public static void main(String[] args){

//        LzstoneMain.run();
        process();
    }
    public static void process(){
        ArticleDao articleDao = new ArticleDao();
        while (true){
            Article article = articleDao.select();
            if (article!=null){//如果找到一条满足条件的需要更新的记录
                if(article.getBody()!=null){//如果获取到的博客正文内容不为null。，则进行更新数据库
                    articleDao.updateContent(article);
                    System.out.println("update id: "+article.getId()+"  success.");
                }else {//获取失败
                    System.out.println("update id: "+article.getId()+"  fail.");
                }

            }
        }
    }
}
