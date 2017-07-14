package com.collector.dao;

import cn.edu.hfut.dmic.contentextractor.ContentExtractor;

/**
 * Created by root on 17-6-15.
 * 封装webcollctor的两种获取博客正文内容的方法
 * 1.getContextByUrl通过url进行获取博客正文内容
 * 2.getContextByHtml通过html进行获取博客正文内容
 * 在本程序中使用第二种方法，由于一些国外网站需要翻墙访问，因此我们在爬虫的同时获取到该页面的html代码，写入数据库中
 * 通过getContextByHtml函数和html代码可以直接提取博客正文内容，无需进行请求url获取内容
 */
public class ExtractorContext {
    /**
     * 通过url获取博客正文内容
     * @param url
     * @return
     */
    public static String getContextByUrl(String url){

        try {
            System.out.println("url: "+url);
            String content = ContentExtractor.getContentByUrl(url);
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    /**
     * 通过html获取博客正文内容
     * @param html
     * @return
     */
    public static String getContextByHtml(String html){


        try {

            String content = ContentExtractor.getContentByHtml(html);
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    /**
     *测试用例
     * 通过html内容和getContextByHtml进行获取正文内容
     */

    public static void main(String[] args){
//        String url = "https://www.recordedfuture.com/gartner-security-risk-management-summit-2017/";
//        System.out.println( ExtractorContext.getContextByUrl(url));
        String html = "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "\n" +
                "<head>\n" +
                "<title>【国外节能环保展会信息】_2017年海外展会信息_国外展会网|WWW.CNENA.COM</title>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.cnena.com/images/yellow/2014style.css\">\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.cnena.com/images/yellow/2014cms.css\">\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.cnena.com/images/yellow/2014new.css\">\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\">\n" +
                "<meta name=\"keywords\" content=\" 会展网、会展信息、展会预告、会展活动、会展产业、会展资讯、会展策划、会展新闻、展览会、会议信息、会展网站、北京展会、上海展会、广州展会、国外展会、展会预告\">\n" +
                "<meta name=\"description\" content=\"全国约80%的会展活动主办方驻站招商，每年约有百万家企业从这里走向各个展会现场。五大搜索引擎新闻源网站，掌握会展业流量入口，引领会展行业发展方向！\">\n" +
                "</head>\n" +
                "\n" +
                "<script language=\"JavaScript\">\n" +
                "//屏蔽可忽略的js脚本错误\n" +
                "function killErr(){\n" +
                "\treturn true;\n" +
                "}\n" +
                "window.onerror=killErr;\n" +
                "</script>\n" +
                "\n" +
                "<script language=\"JavaScript\" src=\"http://www.cnena.com/images/default/inc.js\"></script>\n" +
                "<script language=\"JavaScript\" src=\"http://www.cnena.com/images/default/default.js\"></script>\n" +
                "<script language=\"JavaScript\" src=\"http://www.cnena.com/images/default/swfobject.js\"></script>\n" +
                "<script language=\"JavaScript\" src=\"http://www.cnena.com/images/default/jquery-1.2.6.min.js\"></script>\n" +
                "\n" +
                "<body ondblclick=\"\" bgcolor=\"#FFFFFF\" text=\"#000000\" leftmargin=\"0\" topmargin=\"0\">\n" +
                "<style type=\"text/css\">\n" +
                "<!--\n" +
                "#foot8\n" +
                "{\n" +
                "    font-size: 16px;\n" +
                "    font-family: Arial, \"宋体\";\n" +
                "    height: 0px;\n" +
                "    border-top: solid 1px #E2E2E2;\n" +
                "    padding-top: 190px;\n" +
                "    text-align: center;\n" +
                "    color: #6c6c6c;\n" +
                "}\n" +
                "#foot9\n" +
                "{\n" +
                "    font-size: 12px;\n" +
                "    font-family: Arial, \"宋体\";\n" +
                "    height: 0px;\n" +
                "    border-top: solid 1px #D5D5D5;\n" +
                "    padding-top: 1px;\n" +
                "    text-align: center;\n" +
                "    color: #6c6c6c;\n" +
                "}\n" +
                "#foot10\n" +
                "{\n" +
                "    font-size: 12px;\n" +
                "    font-family: Arial, \"宋体\";\n" +
                "    height: 0px;\n" +
                "    border-top: solid 3px #F26B13;\n" +
                "    padding-top: 1px;\n" +
                "    text-align: center;\n" +
                "    color: #6c6c6c;\n" +
                "}\n" +
                "-->\n" +
                "</style>\n" +
                "    <div id=\"alibar\" class=\"alibar2013 mod-alibar fd-clr\">\n" +
                "    <div id=\"alibar-v4\">\n" +
                "        <div class=\"alibar-container\">\n" +
                "            <div class=\"account-sign-status\">\n" +
                "                <ul>\n" +
                "                    <li class=\"account-welcome\">\n" +
                "      <div id=\"top_login\">\n" +
                "\n" +
                "<script language=\"JavaScript\">\n" +
                "<!--\n" +
                "document.write('<span id=\"head_loginer\"></span>');\n" +
                "document.write('<div style=\"display:none;\"><iframe src=\"http://www.cnena.com/do/hack.php?hack=login&iframeID=head_loginer&styletype=yellow\" width=0 height=0></iframe></div>');\n" +
                "//-->\n" +
                "</script>\n" +
                "</div>\n" +
                "                    </li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "            <div class=\"topnav\">\n" +
                "                <ul>\n" +
                "                    <li class=\"topnav-myali extra list-first\">\n" +
                "                        <div class=\"nav-title\">\n" +
                "                            <a rel=\"nofollow\" class=\"nav-arrow\" title=\"我的CNENA\">我的CNENA</a>\n" +
                "                        </div>\n" +
                "                        <div class=\"nav-content\">                           <dl>\n" +
                "                                <dt>\n" +
                "                                    发布信息\n" +
                "                                </dt>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/about/vip.htm\" title=\"发布国内展览\" target=\"_blank\">国内展览</a>\n" +
                "                                </dd>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/member/?main=http://www.cnena.com/waizhan/member/post_b.php?roomid=1\" title=\"发布会议信息\" target=\"_blank\">会议信息</a>\n" +
                "                                </dd>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/about/vip.htm\" title=\"发布境外展会\" target=\"_blank\">境外展会</a>\n" +
                "                                </dd>\n" +
                "                            </dl>\n" +
                "                            <dl>\n" +
                "                                <dt>\n" +
                "                                    管理信息\n" +
                "                                </dt>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/member/?main=http://www.cnena.com/showroom/member/listzh.php\" title=\"管理国内展会信息\" target=\"_blank\">国内展览</a>\n" +
                "                                </dd>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/member/?main=http://www.cnena.com/huiyi/member/listzh.php\" title=\"管理会议信息\" target=\"_blank\">会议管理</a>\n" +
                "                                </dd>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/member/?main=http://www.cnena.com/waizhan/member/listzh.php\" title=\"管理国外展会信息\" target=\"_blank\">国外展会</a>\n" +
                "                                </dd>\n" +
                "                            </dl>\n" +
                "                            <dl>\n" +
                "                                <dt>\n" +
                "                                    推广展会\n" +
                "                                </dt>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/member/?main=http://www.cnena.com/a_d/member/norm.php?job=list\" title=\"站内积分换推广\" target=\"_blank\">站内推广</a>\n" +
                "                                </dd>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/about/lianxi.htm\" title=\"展会专题推广\" target=\"_blank\">专题推广</a>\n" +
                "                                </dd>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/about/lianxi.htm\" title=\"会展企业推广\" target=\"_blank\">企业推广</a>\n" +
                "                                </dd>\n" +
                "                            </dl></div>\n" +
                "                    </li>\n" +
                "                    <li>\n" +
                "                        <div class=\"nav-title\">\n" +
                "                            <a href=\"http://www.cnena.com/about/ruzhu.html\" title=\"展会信息发布\" target=\"_blank\">展会信息发布</a>\n" +
                "                        </div>\n" +
                "                    </li>\n" +
                "                    <li class=\"topnav-kf extra\">\n" +
                "                        <div class=\"nav-title\">\n" +
                "                            <a class=\"nav-arrow\" rel=\"nofollow\">客服中心</a>\n" +
                "                        </div>\n" +
                "                        <div class=\"nav-content\">                            <dl>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/news/bencandy-htm-fid-34-id-5899.html\" title=\"信息审核标准\" target=\"_blank\">内展审核</a>\n" +
                "                                </dd>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/news/bencandy-htm-fid-34-id-37323.html\" title=\"国外展会审核标准\" target=\"_blank\">外展审核</a>\n" +
                "                                </dd>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/huiyuanfuwu.htm\" title=\"展会信息修改与删除\" target=\"_blank\">信息修改</a>\n" +
                "                                </dd>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/about/liuyan.htm\" target=\"_blank\">展览搭建</a>\n" +
                "                                </dd>\n" +
                "                                <dd>\n" +
                "                                    <a href=\"http://www.cnena.com/news/bencandy-htm-fid-34-id-55693.html\" target=\"_blank\">展会认证</a>\n" +
                "                                </dd>\n" +
                "                                <dd>\n" +
                "                                    <a rel=\"nofollow\" href=\"http://www.cnena.com/huiyuanfuwu.htm\" target=\"_blank\">其它事务</a>\n" +
                "                                </dd>\n" +
                "                            </dl></div>\n" +
                "                    </li>\n" +
                "                    <li class=\"topnav-sitemap extra\">\n" +
                "                        <div class=\"nav-title\">\n" +
                "                            <a class=\"nav-arrow\" href=\"http://www.cnena.com/sitemap.htm\" title=\"网站导航\" data-trace=\"cn_alibar_allservice\" target=\"_blank\">网站导航</a>\n" +
                "                        </div>\n" +
                "                        <div class=\"nav-content\">                            <div class=\"hangye-category\">\n" +
                "                                <dl class=\"zone fd-clr\">\n" +
                "                                    <dt class=\"name\">中国展会</dt>\n" +
                "                                    <dd class=\"detail\">\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/\" title=\"全国展会\" target=\"_blank\">全国展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_city.php?cityid=1\" title=\"北京展会信息\" target=\"_blank\">北京展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_city.php?cityid=2\" title=\"上海展会信息\" target=\"_blank\">上海展会</a></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_city.php?cityid=3\" title=\"广州展会信息\" target=\"_blank\">广州展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_city.php?cityid=4\" title=\"深圳展会信息\" target=\"_blank\">深圳展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_city.php?cityid=7\" title=\"重庆展会信息\" target=\"_blank\">重庆展会</a></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_city.php?cityid=50\" title=\"成都展会信息\" target=\"_blank\">成都展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_city.php?cityid=47\" title=\"浙江展会信息\" target=\"_blank\">浙江展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_city.php?cityid=60\" title=\"河南展会信息\" target=\"_blank\">河南展会</a></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_city.php?cityid=46\" title=\"山东展会信息\" target=\"_blank\">山东展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_city.php?cityid=44\" title=\"陕西展会信息\" target=\"_blank\">陕西展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom\" title=\"全国展会\" target=\"_blank\">......</a></span>\n" +
                "                                    </dd>\n" +
                "                                </dl>\n" +
                "                                <dl class=\"dashedline\"></dl>\n" +
                "                                <dl class=\"zone fd-clr\">\n" +
                "                                    <dt class=\"name\">中国展会</dt>\n" +
                "                                    <dd class=\"detail\">\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_time.php?daytime=1\" title=\"一月展会\" target=\"_blank\">一月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_time.php?daytime=2\" title=\"二月展会\" target=\"_blank\">二月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_time.php?daytime=3\" title=\"三月展会\" target=\"_blank\">三月展会</a></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_time.php?daytime=4\" title=\"四月展会\" target=\"_blank\">四月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_time.php?daytime=5\" title=\"五月展会\" target=\"_blank\">五月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_time.php?daytime=6\" title=\"六月展会\" target=\"_blank\">六月展会</a></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_time.php?daytime=7\" title=\"七月展会\" target=\"_blank\">七月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_time.php?daytime=8\" title=\"八月展会\" target=\"_blank\">八月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_time.php?daytime=9\" title=\"九月展会\" target=\"_blank\">九月展会</a></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_time.php?daytime=10\" title=\"十月展会\" target=\"_blank\">十月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_time.php?daytime=11\" title=\"11月展会\" target=\"_blank\">11月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/showroom/list_time.php?daytime=12\" title=\"12月展会\" target=\"_blank\">12月...</a></span>\n" +
                "                                    </dd>\n" +
                "                                </dl>\n" +
                "                                <dl class=\"dashedline\"></dl>\n" +
                "                              <dl class=\"zone fd-clr\">\n" +
                "                                    <dt class=\"name\">国外展会</dt>\n" +
                "                                    <dd class=\"detail\">\n" +
                "                                        <span><a href=\"http://www.cnena.com/waizhan/list_time.php?daytime=1\" title=\"一月展会\" target=\"_blank\">一月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/waizhan/list_time.php?daytime=2\" title=\"二月展会\" target=\"_blank\">二月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/waizhan/list_time.php?daytime=3\" title=\"三月展会\" target=\"_blank\">三月展会</a></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/waizhan/list_time.php?daytime=4\" title=\"四月展会\" target=\"_blank\">四月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/waizhan/list_time.php?daytime=5\" title=\"五月展会\" target=\"_blank\">五月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/waizhan/list_time.php?daytime=6\" title=\"六月展会\" target=\"_blank\">六月展会</a></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/waizhan/list_time.php?daytime=7\" title=\"七月展会\" target=\"_blank\">七月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/waizhan/list_time.php?daytime=8\" title=\"八月展会\" target=\"_blank\">八月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/waizhan/list_time.php?daytime=9\" title=\"九月展会\" target=\"_blank\">九月展会</a></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/waizhan/list_time.php?daytime=10\" title=\"十月展会\" target=\"_blank\">十月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/waizhan/list_time.php?daytime=11\" title=\"11月展会\" target=\"_blank\">11月展会</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/waizhan/list_time.php?daytime=12\" title=\"12月展会\" target=\"_blank\">12月...</a></span>\n" +
                "                                    </dd>\n" +
                "                              </dl>\n" +
                "                                <dl class=\"dashedline\"></dl>\n" +
                "                                <dl class=\"zone fd-clr\">\n" +
                "                                    <dt class=\"name\">重点版块</dt>\n" +
                "                                    <dd class=\"detail\">\n" +
                "                                        <span><a href=\"http://www.cnena.com/news/\" title=\"会展新闻\" target=\"_blank\">会展资讯</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/news/list-htm-fid-32.html\" title=\"会展动态\" target=\"_blank\">展会动态</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/news/list-htm-fid-3.html\" title=\"会展城市\" target=\"_blank\">会展城事</a></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/news/list-htm-fid-54.html\" title=\"会议资讯\" target=\"_blank\">会议资讯</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/news/list-htm-fid-49.html\" title=\"展馆动态\" target=\"_blank\">展馆动态</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/news/list-htm-fid-4.html\" title=\"会展政策\" target=\"_blank\">会展政策</a></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/news/list-htm-fid-61.html\" title=\"会展机构\" target=\"_blank\">机构动态</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/huijiang/\" title=\"会奖旅游\" target=\"_blank\">会奖旅游</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/news/list-htm-fid-62.html\" title=\"会展曝光台\" target=\"_blank\">曝 光 台</a></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/news/list-htm-fid-33.html\" title=\"节事资讯\" target=\"_blank\">节事资讯</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/news/list-htm-fid-56.html\" title=\"会展评论\" target=\"_blank\">会展评论</a></span>\n" +
                "                                        <span class=\"spacing\"></span>\n" +
                "                                        <span><a href=\"http://www.cnena.com/zts\" title=\"展通社\" target=\"_blank\">展通社</a></span>\n" +
                "                                    </dd>\n" +
                "                                </dl>\n" +
                "                            </div>\n" +
                "                            <div class=\"more\">\n" +
                "                                <a rel=\"nofollow\" class=\"moreBtn\" href=\"http://www.cnena.com/sitemap.htm\" target=\"_blank\">更多导航</a>\n" +
                "                            </div></div>\n" +
                "                    </li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "    </div>    </div>\n" +
                "    <div id=\"header\" class=\"nav-content\">\n" +
                "    <div class=\"header-container layout\">\n" +
                "    <div id=\"masthead-v5\" class=\"fd-clr\">\n" +
                "      \n" +
                "      <div class=\"ali-logo-v5\">\n" +
                "        <a target=\"_self\" title=\"CNENA.COM——中国会展门户网站！\" href=\"http://www.cnena.com/\" class=\"main-logo-v5\"><img width=\"270\" height=\"78\" alt=\"CNENA.COM——中国会展门户网站\" src=\"http://www.cnena.com/images/2014logo.png\"></a>\n" +
                "      </div>\n" +
                "\n" +
                " \n" +
                "\t <div class=\"masthead-right\">\n" +
                "        <div class=\"ali-search-v5\">\n" +
                "          <form name=\"form2\" method=\"POST\" target=\"_blank\" action=\"http://www.cnena.com/showroom/search.php?action=search&amp;mid=1\" id=\"main_serach\" onsubmit=\"return checksearch(this)\">\n" +
                "            <fieldset>\n" +
                "              <legend>\n" +
                "                中国会展门户搜索\n" +
                "              </legend>\n" +
                "        <div class=\"hot-keyword\" id=\"hot-keyword\">\n" +
                "          <div class=\"fd-clr hot-keyword-success\">\n" +
                "            <ol>\n" +
                "              <li><a class=\"vip-hot-keyword\" rel=\"nofollow\" href=\"http://www.cnena.com/showroom/search.php?mid=1\" target=\"_blank\">国内展会</a>  <a class=\"vip-hot-keyword\" rel=\"nofollow\" href=\"http://www.cnena.com/waizhan/search.php?mid=1\" target=\"_blank\">国外展会</a>  <a class=\"vip-hot-keyword\" rel=\"nofollow\" href=\"http://www.cnena.com/huiyi/search.php?search&amp;mid=1\" target=\"_blank\">商业会议</a>  <a class=\"vip-hot-keyword\" rel=\"nofollow\" href=\"http://www.cnena.com/news/search.php\" target=\"_blank\">会展资讯</a>\n" +
                "              </li>\n" +
                "            </ol>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "              <div class=\"alisearch-container-v5\">\n" +
                "                <div class=\"alisearch-keywords-v5 keyword\">\n" +
                "                  <input type=\"text\" value=\"\" name=\"keyword\" id=\"keyword\" class=\"inputkeyword\" placeholder=\"输入国内展会所属行业或举办城市\" x-webkit-speech=\"\">  \n" +
                "                </div>\n" +
                "                <div class=\"alisearch-action-v5 serchr\">\n" +
                "                  <button type=\"submit\" name=\"Submit\" id=\"subbtn\" class=\"alisearch-textbotton\">\n" +
                "                    搜索\n" +
                "                  </button>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </fieldset>\n" +
                "          </form>  </div>\n" +
                "\n" +
                "       <div class=\"alisearch-top\">\n" +
                "          <a href=\"/form/form.php?mid=5\" title=\"发布参展需求\" target=\"_blank\">\n" +
                "              <p class=\"more\">发布参展需求</p>\n" +
                "          </a>\n" +
                "          <a href=\"/form/form.php?mid=5\" title=\"发布参展需求\" target=\"_blank\">\n" +
                "              <p class=\"more\">展会不再错过</p>\n" +
                "          </a>\n" +
                "        </div>\n" +
                "       <style type=\"text/css\">\n" +
                "       \t\t#masthead-v5 .masthead-right .wei-bd {height: 81px;}\n" +
                "         \t#masthead-v5 .masthead-right .wei-bd .h {padding-bottom:3px;}\n" +
                "       </style>\n" +
                "       <div class=\"alisearch-saoma\" id=\"twowei_download\">\n" +
                "\t\t\t<a href=\"http://www.cnena.com/about/fensi.htm\" class=\"wei-bd\" target=\"_blank\">\n" +
                "\t\t\t\t<span class=\"h\">  官方公众号</span>\n" +
                "\t\t\t\t<img src=\"http://www.cnena.com/images/2014images/fensituan.jpg\" alt=\"关注会展门户官方微信\">    \n" +
                "\t\t\t</a>\n" +
                "\t\t</div>\n" +
                "       \n" +
                "        <div class=\"hot-keyword\" id=\"hot-keyword\">\n" +
                "          <div class=\"fd-clr hot-keyword-success\">\n" +
                "            <ol>\n" +
                "              <li>热搜展会：<a class=\"vip-hot-keyword\" href=\"http://www.cnena.com/news/bencandy-htm-fid-32-id-58880.html\" target=\"_blank\">中阿博览会</a>    <a class=\"vip-hot-keyword\" href=\"http://www.cnena.com/showroom/bencandy-htm-fid-4-id-24928.html\" target=\"_blank\">微商博览会</a>    <a class=\"vip-hot-keyword\" href=\"http://www.cnena.com/topzhanhui/bencandy-htm-fid-39-id-1935.html\" target=\"_blank\">2015百货会</a>    <a class=\"vip-hot-keyword\" href=\"http://www.cnena.com/topzhanhui/bencandy-htm-fid-38-id-1969.html\" target=\"_blank\">东北亚博览会</a>    <a class=\"vip-hot-keyword\" href=\"http://www.cnena.com/showroom/bencandy-htm-fid-2-id-24701.html\" target=\"_blank\">绵阳科博会</a>\n" +
                "              </li>\n" +
                "            </ol>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "    </div>\n" +
                "  </div> </div>\n" +
                "<div id=\"foot9\"></div>\n" +
                "<center><table width=\"990\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" id=\"header_menu\">\n" +
                "  <tr> \n" +
                "    <td>\n" +
                "\n" +
                "<a href=\"http://www.cnena.com/\" target=\"\">首页</a> \n" +
                " \n" +
                "<a href=\"http://www.cnena.com/showroom/\" target=\"\">国内展会</a> \n" +
                " \n" +
                "<a href=\"http://www.cnena.com/huiyi/\" target=\"\">会议论坛</a> \n" +
                " \n" +
                "<a href=\"http://www.cnena.com/waizhan/\" target=\"\">国外展会</a> \n" +
                " \n" +
                "<a href=\"http://www.cnena.com/jieqing/\" target=\"\">节事</a> \n" +
                " \n" +
                "<a href=\"http://www.cnena.com/showroom/listroom.php\" target=\"\">会展场馆</a> \n" +
                " \n" +
                "<a href=\"http://www.cnena.com/news/\" target=\"\">会展资讯</a> \n" +
                " \n" +
                "<a href=\"http://www.cnena.com/hr/\" target=\"\">会展职场</a> \n" +
                " \n" +
                "<a href=\"http://www.cnena.com/brand/\" target=\"\">参展商</a> \n" +
                " \n" +
                "<a href=\"http://www.cnena.com/fws/\" target=\"\">会展服务商</a> \n" +
                " \n" +
                "<a href=\"http://www.cnena.com/topzhanhui/list_time.php\" target=\"\">品牌展会</a> \n" +
                " \n" +
                "<a href=\"http://www.cnena.com/huijiang\" target=\"_blank\">会奖旅游</a> \n" +
                " \n" +
                "<script language=\"JavaScript\">\n" +
                "<!--\n" +
                "function click_head_menu(obj){\n" +
                "\too=document.getElementById(\"header_menu\").getElementsByTagName('A');\n" +
                "\tfor(var i=0;i<oo.length;i++){\n" +
                "\t\too[i].className='';\n" +
                "\t}\n" +
                "\tobj.className='choose';\n" +
                "}\n" +
                "//-->\n" +
                "</script>\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table></center>\n" +
                "<div id=\"foot10\"></div>\n" +
                "\n" +
                "<script language=\"JavaScript\">\n" +
                "<!--//目的是为了做风格方便\n" +
                "document.write('<div class=\"wrap\" onmouseover=hiddendiv(\"listselect\")>');\n" +
                "//-->\n" +
                "</script>\n" +
                "\n" +
                "<!--\n" +
                "--> \n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.cnena.com/images/yellow/showroom_time.css\">\n" +
                "<script type=\"text/javascript\" src=\"images/blue/sliding.js\"></script>\n" +
                "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"nav_guide\">\n" +
                "  <tr> \n" +
                "    <td><div class=\"t1\">您所在的页面：</div><div class=\"t2\"><a href=\"http://www.cnena.com/\">中国会展门户</a>-&gt; <a href=\"http://www.cnena.com/waizhan/\">国外展会</a>-&gt; <a href=\"\">国外节能环保展会信息</a></div></td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listalltable\">\n" +
                "  <tr>\n" +
                "    <td width=\"70%\" class=\"main\">\n" +
                "    \t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"dragTable\">\n" +
                "          <tr>\n" +
                "            <td class=\"head\">\n" +
                "            \t<span class=\"FL\">节能环保</span>\n" +
                "                <span class=\"FR\"><a href=\"\" class=\"ch\">您正在浏览国外节能环保展会</a>\n" +
                "                </span>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td class=\"cont\">\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-43080.html\" target=\"_blank\"><img src=\"http://www.cnena.com/upload_files/qb_waizhan_/16/56989_20170405130457_JUJCJUI3JUIxJUEzJUQ1JUI5TE9HTw==.png.gif\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-43080.html\" target=\"_blank\" title=\"2017年香港国际环保博览会\" style=\"color:;\">2017年香港国际环保博览会</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-10-26 至 2017-10-29  举办地点：中国香港-香港湾仔会展中心</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=43080\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2017-04-05  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=56989\" target=\"_blank\">余珊珊</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：737 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-42948.html\" target=\"_blank\"><img src=\"http://www.cnena.com/upload_files/qb_waizhan_/16/54632_20170103110144_UVElQkQlRDglQ0QlQkMyMDE3MDEwMzExMzI0OQ==.jpg.gif\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-42948.html\" target=\"_blank\" title=\"2017第九届越南国际节能环保及新能源产业展览会\" style=\"color:;\">2017第九届越南国际节能环保及新能源产业展览会</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-05-11 至 2017-05-13  举办地点：越南-西贡国际会展中心</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=42948\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2017-01-03  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=54632\" target=\"_blank\">莫红梅Amy</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：2424 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-42946.html\" target=\"_blank\"><img src=\"http://www.cnena.com/upload_files/qb_waizhan_/16/23176_20170102160102_MjAxNyVBMSVBMzQlRDQlQkQlQzQlQ0Yx.jpg.gif\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-42946.html\" target=\"_blank\" title=\"2017年越南新能源环保技术设备展览会\" style=\"color:;\">2017年越南新能源环保技术设备展览会</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-04-19 至 2017-04-22  举办地点：越南-越南国际会展中心(ICE)</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=42946\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2017-01-02  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=23176\" target=\"_blank\">zqsb01</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：804 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-42708.html\" target=\"_blank\"><img src=\"\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-42708.html\" target=\"_blank\" title=\"2017阿尔及利亚水展\" style=\"color:;\">2017阿尔及利亚水展</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-02-13 至 2017-02-16  举办地点：阿尔及利亚-safex展览中心</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=42708\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2016-12-19  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=49899\" target=\"_blank\">guojizhanhui</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：488 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-42526.html\" target=\"_blank\"><img src=\"\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-42526.html\" target=\"_blank\" title=\"2017年土耳其聚氨酯与复合材料展\" style=\"color:;\">2017年土耳其聚氨酯与复合材料展</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-11-09 至 2017-11-11  举办地点：土耳其-伊斯坦布尔</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=42526\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2016-12-14  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=54266\" target=\"_blank\">联世小艾</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：409 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-42369.html\" target=\"_blank\"><img src=\"\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-42369.html\" target=\"_blank\" title=\" 2017沙特五大行业制冷暖通展 \" style=\"color:;\"> 2017沙特五大行业制冷暖通展 </a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-01-15 至 2017-01-17  举办地点：阿联酋-吉达国际会展中心</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=42369\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2016-12-09  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=19786\" target=\"_blank\">庞京城</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：443 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-42308.html\" target=\"_blank\"><img src=\"http://www.cnena.com/upload_files/qb_waizhan_/19/40823_20161209091208_JUI2JUY3JUM1JUI1JUQwJUM1JUJCJUUxJUQ1JUI5bG9nbw==.jpg.gif\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-42308.html\" target=\"_blank\" title=\"2017年第39届韩国国际环保水处理展会\" style=\"color:;\">2017年第39届韩国国际环保水处理展会</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-03-01 至 2017-03-04  举办地点：韩国-BEXCO</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=42308\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2016-12-09  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=40823\" target=\"_blank\">恩诺信会展</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：419 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-42300.html\" target=\"_blank\"><img src=\"\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-42300.html\" target=\"_blank\" title=\"2017年澳大利亚国际能源展览会\" style=\"color:;\">2017年澳大利亚国际能源展览会</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-10-11 至 2017-10-12  举办地点：澳大利亚-墨尔本</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=42300\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2016-12-09  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=54146\" target=\"_blank\">文成朝</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：573 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-42174.html\" target=\"_blank\"><img src=\"\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-42174.html\" target=\"_blank\" title=\"2017年5月沙特（利雅得）暖通制冷展\" style=\"color:;\">2017年5月沙特（利雅得）暖通制冷展</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-05-14 至 2017-05-16  举办地点：沙特-利雅得国际展览中心</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=42174\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2016-12-07  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=54096\" target=\"_blank\">马思杨</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：373 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-41745.html\" target=\"_blank\"><img src=\"\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-41745.html\" target=\"_blank\" title=\"2017年第13届土耳其国际环保固废展\" style=\"color:;\">2017年第13届土耳其国际环保固废展</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-03-16 至 2017-03-19  举办地点：土耳其-伊斯坦布尔国际会展中心</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=41745\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2016-11-29  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=20952\" target=\"_blank\">zhaoyanxin0424</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：847 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-41474.html\" target=\"_blank\"><img src=\"\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-41474.html\" target=\"_blank\" title=\"2017 年第十九届中东迪拜水处理展\" style=\"color:;\">2017 年第十九届中东迪拜水处理展</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-10-23 至 2017-10-25  举办地点：迪拜-迪拜国际世贸中心</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=41474\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2016-11-23  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=5849\" target=\"_blank\">dbsfairs</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：409 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-41420.html\" target=\"_blank\"><img src=\"\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-41420.html\" target=\"_blank\" title=\"2017年第28届巴西水处理环保展览会\" style=\"color:;\">2017年第28届巴西水处理环保展览会</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-10-03 至 2017-10-05  举办地点：巴西-圣保罗</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=41420\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2016-11-23  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=51342\" target=\"_blank\">13716659655</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：567 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-41387.html\" target=\"_blank\"><img src=\"\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-41387.html\" target=\"_blank\" title=\"2017 年亚洲国际泵阀及管道展\" style=\"color:;\">2017 年亚洲国际泵阀及管道展</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-03-29 至 2017-04-01  举办地点：印度尼西亚-JIE</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=41387\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2016-11-22  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=5849\" target=\"_blank\">dbsfairs</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：417 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-41315.html\" target=\"_blank\"><img src=\"\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-41315.html\" target=\"_blank\" title=\"第28届巴西水处理环保展览\" style=\"color:;\">第28届巴西水处理环保展览</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-10-03 至 2017-10-05  举办地点：圣保罗-圣保罗</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=41315\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2016-11-21  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=51342\" target=\"_blank\">13716659655</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：401 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"listshop\">\n" +
                "              <tr> \n" +
                "                <td class=\"img\"><a rel=\"nofollow\" href=\"bencandy-htm-fid-16-id-41311.html\" target=\"_blank\"><img src=\"http://www.cnena.com/upload_files/qb_waizhan_/16/52403_20161121111117_JTdFJTdEMSUyNExWSlFGJTdEVUxLVVQxTzFDJTdCUCUyOEo=.png.gif\" onerror=\"this.src='http://www.cnena.com/images/default/nopic.jpg'\" width=\"120\" height=\"90\"></a></td>\n" +
                "                <td class=\"info\"> \n" +
                "                  <div class=\"title\"><a href=\"bencandy-htm-fid-16-id-41311.html\" target=\"_blank\" title=\"2017年美国国际废料回收工业展ISRI展\" style=\"color:;\">2017年美国国际废料回收工业展ISRI展</a></div>\n" +
                "                  <div class=\"company\">展会时间：2017-04-24 至 2017-04-26  举办地点：美国-路易斯安那州新奥尔良</div>\n" +
                "                  <div class=\"sort\"> 同行业展会：<a href=\"list-htm-fid-16.html\" target=\"_blank\">节能环保</a> 您可以：<a href=\"http://www.cnena.com/waizhan/member/join.php?fid=16&amp;cid=41311\" target=\"_blank\">报名参展</a>｜<a href=\"http://www.cnena.com/form/form.php?mid=1\" target=\"_blank\">投诉举报</a></div>\n" +
                "                  <div class=\"more\">发布日期：2016-11-21  发布者:<a href=\"http://www.cnena.com/member/homepage.php?uid=52403\" target=\"_blank\">李源源源</a>  状态：\n" +
                "                  \n" +
                "                  已通过审核\n" +
                "                  共：840 人关注  </div>\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "\n" +
                "\t\t\t  <div class=\"page\"><a href=\"list-htm-fid-16-page-1.html\" title=\"首页\">首页</a> <a href=\"list-htm-fid-16-page-1.html\" title=\"上一页\">上一页</a>   <a href=\"#\"><font color=\"red\">1</font></a> <a href=\"list-htm-fid-16-page-2.html\" title=\"第2页\">2</a> <a href=\"list-htm-fid-16-page-3.html\" title=\"第3页\">3</a> <a href=\"list-htm-fid-16-page-4.html\" title=\"第4页\">4</a> <a href=\"list-htm-fid-16-page-5.html\" title=\"第5页\">5</a> <a href=\"list-htm-fid-16-page-6.html\" title=\"第6页\">6</a> <a href=\"list-htm-fid-16-page-7.html\" title=\"第7页\">7</a>  <a href=\"list-htm-fid-16-page-2.html\" title=\"下一页\">下一页</a> <a href=\"list-htm-fid-16-page-55.html\" title=\"尾页\">尾页</a> <a href=\"#\"><font color=\"red\">1</font>/55/815</a></div>\n" +
                "\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </table>\n" +
                "    </td>\n" +
                "    <td width=\"30%\" class=\"side\">\n" +
                "    \t<div class=\"sortcontainer\">\n" +
                "        \t<div class=\"head\"><span>赞助商链接</span></div>\n" +
                "            <div class=\"cont\">\n" +
                "\t\t\t\t<div class=\"listsort2\"><center><script type=\"text/javascript\">\n" +
                "/*250*250，图片代码*/\n" +
                "var cpro_id = \"u1613734\";\n" +
                "</script>\n" +
                "<script src=\"http://cpro.baidustatic.com/cpro/ui/c.js\" type=\"text/javascript\"></script></center></div>\n" +
                "            </div><br>\n" +
                "    \t<div class=\"sortcontainer\">\n" +
                "        \t<div class=\"head\"><span>行业导航</span></div>\n" +
                "            <div class=\"cont\">\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-2.html\">【国外经贸综合展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-1.html\">【国外机械工业展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-3.html\">【国外广告传媒展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-4.html\">【国外IT通信展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-5.html\">【国外纺织鞋服展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-6.html\">【国外医疗保健展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-7.html\">【国外百货家居展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-8.html\">【国外汽车交通展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-9.html\">【国外礼品工艺展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-16.html\">【国外节能环保展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-11.html\">【国外珠宝首饰展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-12.html\">【国外妇婴玩具展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-13.html\">【国外休闲旅游展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-14.html\">【国外餐饮食品展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-15.html\">【国外农林渔牧展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-19.html\">【国外能源化工展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-20.html\">【国外文体办公展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-21.html\">【国外数码家电展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-23.html\">【国外房产建材展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-26.html\">【国外电子光电展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-27.html\">【国外劳保安防展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "\t\t\t\t<div class=\"listsort\"><a href=\"list-htm-fid-24.html\">【国外其它展会展会信息】</a></div>\t\t\t\n" +
                "\n" +
                "       </div><br>\n" +
                "        </div>\n" +
                "    \t<div class=\"sortcontainer\">\n" +
                "        \t<div class=\"head\"><span>提示信息</span></div>\n" +
                "            <div class=\"cont\">\n" +
                "\t\t\t\t<div class=\"listsort2\"><center><br><div class=\"bdlikebutton\"></div>\n" +
                "<script id=\"bdlike_shell\"></script>\n" +
                "<script>\n" +
                "var bdShare_config = {\n" +
                "\t\"type\":\"large\",\n" +
                "\t\"color\":\"orange\",\n" +
                "\t\"uid\":\"160206\",\n" +
                "\t\"likeText\":\"这个页面对您有帮助吗？\",\n" +
                "\t\"likedText\":\"您已经表过态了：）\"\n" +
                "};\n" +
                "document.getElementById(\"bdlike_shell\").src=\"http://bdimg.share.baidu.com/static/js/like_shell.js?t=\" + new Date().getHours();\n" +
                "</script></center><br><!-- Baidu Button BEGIN -->\n" +
                "<div id=\"bdshare\" class=\"bdshare_t bds_tools get-codes-bdshare\">\n" +
                "<span class=\"bds_more\">分享到：</span>\n" +
                "<a class=\"bds_tsina\"></a>\n" +
                "<a class=\"bds_tqq\"></a>\n" +
                "<a class=\"bds_qzone\"></a>\n" +
                "<a class=\"bds_renren\"></a>\n" +
                "<a class=\"bds_kaixin001\"></a>\n" +
                "<a class=\"bds_tsohu\"></a>\n" +
                "<a class=\"shareCount\"></a>\n" +
                "</div>\n" +
                "<script type=\"text/javascript\" id=\"bdshare_js\" data=\"type=tools&amp;uid=160206\"></script>\n" +
                "<script type=\"text/javascript\" id=\"bdshell_js\"></script>\n" +
                "<script type=\"text/javascript\">\n" +
                "var bds_config={\"snsKey\":{'tsina':'3458418210','tqq':'801288478','t163':'','tsohu':''}}\n" +
                "document.getElementById(\"bdshell_js\").src = \"http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=\" + Math.ceil(new Date()/3600000)\n" +
                "</script>\n" +
                "<!-- Baidu Button END --><br><br><br>\n" +
                "  此页面专门为您整理【<a href=\"list-htm-fid-16.html\" class=\"ch\">2016年国外节能环保展会信息</a>】，涵盖国外节能环保行业2016年将举办的展览会、博览会、交易会等信息，欢迎收藏！<br>\n" +
                " \n" +
                "</div>\t\t\n" +
                "       </div>\n" +
                "        </div>\n" +
                "    </div></td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<!--\n" +
                "-->\n" +
                "<style type=\"text/css\">\n" +
                "<!--\n" +
                "#foot8\n" +
                "{\n" +
                "    font-size: 12px;\n" +
                "    font-family: Arial, \"宋体\";\n" +
                "    height: 90px;\n" +
                "    border-top: solid 2px #F75000;\n" +
                "    padding-top: 15px;\n" +
                "    text-align: center;\n" +
                "    color: #6c6c6c;\n" +
                "}\n" +
                ".STYLE3 {color: #666666}\n" +
                "-->\n" +
                "</style>\n" +
                "\n" +
                "<script src=\"http://www.cnena.com/js/duilianjs/js/ad.js\" type=\"text/javascript\"></script>\n" +
                "<br>\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "/*全站底部，创建于2013-8-24*/\n" +
                "var cpro_id = \"u1353518\";\n" +
                "</script>\n" +
                "<script src=\"http://cpro.baidustatic.com/cpro/ui/c.js\" type=\"text/javascript\"></script><br>\n" +
                "        <!-- Message View -->\n" +
                "    \n" +
                "    <div style=\"clear: both\">\n" +
                "    </div>\n" +
                "    <!-- Message View -->\n" +
                "<div id=\"foot8\" style=\"clear:both;\">\n" +
                "  <center><table width=\"980\" height=\"83\" border=\"0.5\" align=\"center\">\n" +
                "    <tr>\n" +
                "      <td width=\"196\" rowspan=\"4\"><a href=\"http://www.cnena.com\"><img src=\"http://www.cnena.com/images/default/nopic2.jpg\" border=\"0\"></a></td>\n" +
                "      <td width=\"774\" height=\"20\"><div align=\"left\">  提示：本站展会信息均由会员发布，网站已尽严格审核义务，因办展过程的不可控性，请您参展前务必再次与组织方或展馆方核实。</div></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"20\"><div align=\"left\">  声明：中国会展门户(CNENA)与站内所有展会之间均无主办/协办或承办等关联关系。如遇参展纠纷，请追究办展主体的法律责任。  \n" +
                "</div></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"20\"><div align=\"left\">  本站网页设计及原创内容受版权保护,未经许可，严禁模仿、采集、复制以及建立镜像！  对外合作咨询：906992643(QQ)</div></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td><div align=\"left\" height=\"20\">  Copyright 2008-2017, \n" +
                "          <script type=\"text/javascript\">\n" +
                "var _bdhmProtocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");\n" +
                "document.write(unescape(\"%3Cscript src='\" + _bdhmProtocol + \"hm.baidu.com/h.js%3Fb900951428bb6dcb2b2c2a63d36bc755' type='text/javascript'%3E%3C/script%3E\"));\n" +
                "</script>\n" +
                "       <a href=\"http://www.cnena.com/\" target=\"_blank\">中国会展门户</a>  网站备案/许可证号：京ICP备<a href=\"http://www.miibeian.gov.cn\" target=\"_blank\">13004363</a>号-1 京公网安备：11010502004098 - \n" +
                "      <span style=\"display:none\"><script language=\"javascript\" type=\"text/javascript\" src=\"http://js.users.51.la/2844959.js\"></script>\n" +
                "<noscript><a href=\"http://www.51.la/?2844959\" target=\"_blank\"><img alt=\"我要啦免费统计\" src=\"http://img.users.51.la/2844959.asp\" style=\"border:none\"></a></noscript></span>  <span style=\"display:none\"><script type=\"text/javascript\">var cnzz_protocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");document.write(unescape(\"%3Cspan id='cnzz_stat_icon_1598548'%3E%3C/span%3E%3Cscript src='\" + cnzz_protocol + \"s4.cnzz.com/stat.php%3Fid%3D1598548' type='text/javascript'%3E%3C/script%3E\"));</script></span>\n" +
                "</div></td>\n" +
                "    </tr>\n" +
                "  </table>\n" +
                "  <table width=\"980\" border=\"0\" align=\"center\">\n" +
                "<tr>\n" +
                "\t  <td width=\"30\" bgcolor=\"#FF9900\"> </td>\n" +
                "\t  <td width=\"165\"><div align=\"center\"><span class=\"STYLE3\">会  聚  四  海  ·  展  通  天  下</span></div></td>\n" +
                "\t  <td width=\"30\" bgcolor=\"#006699\"> </td>\n" +
                "\t  <td width=\"18\"> </td>\n" +
                "\t  <td width=\"102\" bgcolor=\"#CCCCCC\"><a href=\"http://www.cnena.com/about/\" target=\"_blank\">关于我们</a></td>\n" +
                "      <td width=\"100\" bgcolor=\"#CCCCCC\"><a href=\"http://www.cnena.com/about/news.htm\" target=\"_blank\">网站动态</a></td>\n" +
                "      <td width=\"100\" bgcolor=\"#CCCCCC\"><a href=\"http://www.cnena.com/about/baodao.htm\" target=\"_blank\">媒体报道</a></td>\n" +
                "      <td width=\"100\" bgcolor=\"#CCCCCC\"><a href=\"http://www.cnena.com/about/tuiguang/shixiang.htm\" target=\"_blank\">展会推广</a></td>\n" +
                "      <td width=\"100\" bgcolor=\"#CCCCCC\"><a href=\"http://www.cnena.com/about/ruzhu.html\" target=\"_blank\">展会信息发布</a></td>\n" +
                "      <td width=\"100\" bgcolor=\"#CCCCCC\"><a href=\"http://www.cnena.com/about/rongyu.htm\" target=\"_blank\">网站荣誉</a></td>\n" +
                "      <td width=\"87\" bgcolor=\"#CCCCCC\"><a href=\"http://www.cnena.com/about/lianxi.htm\" target=\"_blank\">联系我们</a></td>\n" +
                "    </tr>\n" +
                "  </table></center>\n" +
                "  <br>\n" +
                "</div>\n" +
                "<script language=\"JavaScript\">\n" +
                "<!--//目的是为了做风格方便\n" +
                "document.write('</div>');\n" +
                "//-->\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";
        System.out.println(ExtractorContext.getContextByHtml(html));
    }

}
