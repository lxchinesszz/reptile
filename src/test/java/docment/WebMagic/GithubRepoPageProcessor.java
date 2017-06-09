package docment.WebMagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

/**
 * @Package: docment.WebMagic
 * @Description: 处理逻辑
 * @author: liuxin
 * @date: 17/6/9 下午4:44
 */
public class GithubRepoPageProcessor implements PageProcessor {
    //爬虫的配置重试次数3次，间隔1秒
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    /**
     * XPath本来是用于XML中获取元素的一种查询语言，但是用于Html也是比较方便的。例如：
     * $CSS选择器:$('h1.entry-title')
     * regex:它表示匹配所有"https://github.com/code4craft/webmagic"这样的链接。
     * JsonPath:JsonPath是于XPath很类似的一个语言，它用于从Json中快速定位一条内容。
     *
     * @param page
     */
    public void process(Page page) {
        //对目标网站,linke和url进行正在匹配,将这些链接加入到待抓取的队列中去
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
        //保存这些值到resultItems结果集合中
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        Selectable selectable = page.getHtml().$(".name");
        //说明文档:http://webmagic.io/docs/zh/posts/ch4-basic-page-processor/selectable.html


        if (page.getResultItems().get("name") == null) {
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args)throws Exception {
//        long start = System.currentTimeMillis();
//        Spider.create(new GithubRepoPageProcessor()).addUrl("https://github.com/code4craft").thread(50).run();
//        long end = System.currentTimeMillis();
//        System.out.printf("执行时间:%d", (end - start));

        //TODO 测试
        Spider oschinaSpider = Spider.create(new GithubRepoPageProcessor())
                .addUrl("http://my.oschina.net/flashsword/blog");
        Spider githubSpider = Spider.create(new GithubRepoPageProcessor())
                .addUrl("https://github.com/code4craft");

        SpiderMonitor.instance().register(oschinaSpider);
        SpiderMonitor.instance().register(githubSpider);
        oschinaSpider.start();
        githubSpider.start();

    }
}
