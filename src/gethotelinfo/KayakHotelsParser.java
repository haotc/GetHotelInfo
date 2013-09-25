/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gethotelinfo;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.HtmlParserImpl;

/**
 *
 * @author WIN7
 */
public class KayakHotelsParser implements HotelInfoParser{
    private String url;
    
    public KayakHotelsParser(String url) {
        this.url = url;
    }
    
    public Elements getResultList() throws IOException {
        HtmlParserImpl htmlParser = new HtmlParserImpl();
        Elements tmp = htmlParser.connect(this.url).select(".hotelresult.resultrow").not(".inlineOpaque, .opaqueAd6");
        return tmp;
    }
    
    @Override
    public String getName(Element result) {     
        return result.getElementsByClass("hotelname").first().text();
    }

    @Override
    public String getAddress(Element result) {
        return "";
    }

    @Override
    public String getDetailInfo(Element result) {
        return "";
    }

    @Override
    public double getPrice(Element result) {
        double priceResult = 0;
        String price = result.getElementsByClass("pricerange").first().text();
        Matcher matcher = Pattern.compile("\\d+[.]\\d+").matcher(price);
        if( matcher.find() ) {
            price = matcher.group();
            priceResult = Double.parseDouble(price);
        } else {
            matcher = Pattern.compile("\\d+").matcher(price);
            if(matcher.find()) {
                price = matcher.group();
                priceResult = Double.parseDouble(price);
            }
        }
        
        return priceResult;
    }
    
    @Override
    public String getImageUrl(Element result) {
        return result.getElementsByTag("img").first().absUrl("src");
    }
    
}
