package com.iflyer.angular;

import org.apache.commons.collections.CollectionUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.util.List;

/**
 * @Package: com.iflyer.angular
 * @Description: 抓取使用js渲染的页面
 * @author: liuxin
 * @date: 17/6/12 上午9:47
 */
public class AngularJSProcessor implements PageProcessor {

    private Site site = Site.me();

    private static final String ARITICALE_URL = "http://angularjs\\.cn/api/article/\\w+";

    private static final String LIST_URL = "http://angularjs\\.cn/api/article/latest.*";

    /**
     * JsonPath使用方法:
     * http://www.cnblogs.com/weilunhui/p/3857366.html
     *
     * GitBook可以写一些Api
     * https://www.gitbook.com
     * @param page
     */
    public void process(Page page) {
        page.getRawText();
        System.out.println(page.getRawText());
        if (page.getUrl().regex(LIST_URL).match()) {
            //TODO 从json中获取所有的_id属性,改地址返回的都是json数据，所以可以使用json去解析，获取页面信息
            List<String> ids = new JsonPathSelector("$.data[*]._id").selectList(page.getRawText());
            if (CollectionUtils.isNotEmpty(ids)) {
                for (String id : ids) {
                    page.addTargetRequest("http://angularjs.cn/api/article/" + id);
                }
            }
        } else {
            page.putField("title", new JsonPathSelector("$.data.title").select(page.getRawText()));
            page.putField("content", new JsonPathSelector("$.data.content").select(page.getRawText()));
        }

    }


    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new AngularJSProcessor()).addUrl("http://angularjs.cn/api/article/latest?p=1&s=20").run();
    }
}

