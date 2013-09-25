package gethotelinfo;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.HtmlParserImpl;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: HaoTC
 * Date: 9/23/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class YesGoHotelsParser implements HotelInfoParser, HrefPagingParser {

    private String url;

    public YesGoHotelsParser(String url) {
        this.url = url;
    }

    public Elements getResultList() throws IOException {
        HtmlParserImpl htmlParser = new HtmlParserImpl();
        Elements tmp = htmlParser.connect(this.url).select(".box_list_content");
        return tmp;
    }

    @Override
    public String getName(Element result) {
        return result.select(".co2 .font18.ogrange_color a").first().text();
    }

    @Override
    public String getAddress(Element result) {
        return result.select(".gray_color.text_i.p5b").first().text();
    }

    @Override
    public String getDetailInfo(Element result) {
        return result.select(".co2 .textdeription").first().text();
    }

    @Override
    public double getPrice(Element result) {
        Elements e = result.select(".co1 .price strong");
        String priceStr = e.first().text();
        if (priceStr.indexOf("Từ ") == -1) {
            return 0;
        }
        priceStr = priceStr.replaceAll("[^0-9]", "");
        return Double.parseDouble(priceStr);
    }

    @Override
    public String getImageUrl(Element result) {
        return result.select(".co1 a img").first().absUrl("data-src");
    }

    @Override
    public String getNextPageUrl(String e) throws IOException {
        HtmlParserImpl htmlParser = new HtmlParserImpl();
        Elements elements = htmlParser.connect(this.url).select(".box_pagin_top.w230.float_right .next");
        if (elements.size() == 0) {
            return null;
        }
        return elements.first().absUrl("href");
    }
}
