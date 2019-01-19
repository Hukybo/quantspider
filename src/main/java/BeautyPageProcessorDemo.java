//import sun.jvm.hotspot.gc.shared.Space;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

/**
 * @ClassName: BeautyPageProcessorDemo
 * @Description:
 * @Auther: Mr.hukaibo
 * @Date: 2019-01-11 06:11
 * @Version: 1.0
 */
public class BeautyPageProcessorDemo implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    @Override
    public Site getSite() {
        return site;
    }
    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        //page.putField("auther", page.getUrl().regex().toString());
        //page.putField("name", page.getHtml().xpath());
        //String re = "http://blog.sina.com.cn/s/blog_97e854b60102.{4}.html";
        List url = html.xpath("//span[@class=title]//a/@href").all();
        System.out.println();
        for (int i = 0; i < url.size(); i++) {
            System.out.println("网址：" + url);
        }
    }

    public static void main(String[] ages) {
        for(int i = 0; i < 10; i++) {
            String url = "http://www.mmjpg.com/home/" + (i + 2);
            Spider.create(new BeautyPageProcessorDemo())
                    .addUrl(url)
                    .thread(5).run();

        }
    }
}
