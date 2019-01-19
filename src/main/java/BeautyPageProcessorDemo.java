import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

/**
 * @ClassName: BeautyPageProcessorDemo
 * @Description:
 * @Author: Mr.Hu
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
        List<String> urls = html.xpath("//[@class=latticePad]//a/@href").all();
        System.out.println(urls);
        String firstUrl = "http://www.kingsfintech.com";
    }

    public static void main(String[] ages) {
        String url = "http://www.kingsfintech.com/p-99/page-1.html";
        BeautyPageProcessorDemo bppd = new BeautyPageProcessorDemo();
        Spider.create(bppd).addUrl(url).thread(5).run();
    }
}