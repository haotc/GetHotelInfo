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
public class MyTourHotelsParser implements HotelInfoParser {

    private String url;

    public MyTourHotelsParser(String url) {
        this.url = url;
    }

    public Elements getResultList() throws IOException {
        HtmlParserImpl htmlParser = new HtmlParserImpl();
        Elements tmp = htmlParser.connect(this.url).select(".wrapprer-detail .detail_list");
        return tmp;
    }

    @Override
    public String getName(Element result) {
        return result.getElementsByClass("hotel_name").first().child(1).text();
    }

    @Override
    public String getAddress(Element result) {
        return result.getElementsByClass("address").first().text();
    }

    @Override
    public String getDetailInfo(Element result) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public double getPrice(Element result) {
        String priceStr = result.select(".min_price .price_show").first().text();
        priceStr = priceStr.replace(",", "");
        return Double.parseDouble(priceStr);
    }

    @Override
    public String getImageUrl(Element result) {
        return result.getElementsByClass("image_small").first().absUrl("src");
    }
}
