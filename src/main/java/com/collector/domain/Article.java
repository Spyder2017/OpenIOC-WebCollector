package com.collector.domain;

/**
 * Created by root on 17-6-15.
 * 对应Mysql数据库spider中articles表
 * 字段分别代表articles表中的列元素
 */
public class Article {

    private String id;
    private String body;
    private String url;
    private int is_extract;
    private int count;
    private String html;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIs_extract() {
        return is_extract;
    }

    public void setIs_extract(int is_extract) {
        this.is_extract = is_extract;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
