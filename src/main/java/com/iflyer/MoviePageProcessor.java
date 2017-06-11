package com.iflyer;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.Iterator;

/**
 * Created by mac on 2017/6/11.
 */
public class MoviePageProcessor implements PageProcessor {

    private static Site site = Site.me().setCharset("utf-8").setRetryTimes(2);

    public void process(Page page) {
        //TODO 首先获取分类
        Elements elementsByTag = page.getHtml().getDocument().getElementsByTag("a");
        Iterator<Element> iterator = elementsByTag.iterator();
        //TODO 从当前页面中获取视频地址
        while (iterator.hasNext()) {
            Element next = iterator.next();
            //TODO 提取电影分类数据，添加到爬虫请求中
            String nav = next.attr("class");
            if (nav.endsWith("nav-link")) {
                String context = next.text();
                String nextUrl = next.absUrl("href");
                System.out.printf("添加分类:%s,地址:%s", context, nextUrl);
                System.out.println();
            }
            String title = next.attr("title");
            String color = next.attr("class");
            if (StringUtils.isEmpty(title) || !StringUtils.isEmpty(color)) {
                if (!next.attr("target").equals("_blank")) {
                    continue;
                }
            } else {
                String url = next.absUrl("href");
                if (url.endsWith("html") || url.endsWith("xml")) {
                    continue;
                }
                System.out.printf("title:%s,地址:%s", title, url);
                System.out.println();
            }
        }

    }

    public Site getSite() {
        return site;
    }
}
