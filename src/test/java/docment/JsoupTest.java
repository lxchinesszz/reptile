package docment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.logging.Logger;

/**
 * @Package: docment
 * @Description: 测试
 * @author: liuxin
 * @date: 17/6/9 下午1:02
 */
public class JsoupTest {
    private static final Logger logger = Logger.getLogger("JsoupTset");

    public static void main(String[] args) {
        String html = "<html><head><title>First parse</title></head>" +
                "<a href=\"dfas\">woshia</a><a href=\"dfas\">woshia</a><a href=\"dfas\">woshia</a><a href=\"dfas.jsp\">woshia</a>" +
                "<dev></dev>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        //a[href$=.jsp]  获取带有href且内容.jsp结尾的
        //a[href] 获取带有href的a标签
        Elements elements = doc.select("a[href$=.jsp]");
        System.out.println(elements);
        logger.info("获取属性值" + elements.get(0).attr("href"));//获取属性值
        logger.info("获取标签文本" + elements.get(0).text());//获取标签内容
        logger.info("设置属性" + elements.get(2).attr("src", "/img/1.jsp"));

        junit.framework.Assert.assertEquals(1,1,1);
    }
}
