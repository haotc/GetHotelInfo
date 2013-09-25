/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author WIN7
 */
public class HtmlParserImpl implements HtmlParser{

    public Document connect(String url) throws IOException{
        return Jsoup.connect(url).timeout(0).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").get();
    }
    
    @Override
    public Elements getByID(String url, String id) throws IOException{
        Document doc = this.connect(url);
        return doc.select("#"+id);
    }

    @Override
    public Elements getByClass(String url, String clazz) throws IOException {
        Document doc = Jsoup.connect(url).get();
        return doc.select("." + clazz);
    }

    @Override
    public Elements getByID(Elements element, String id) {
        return element.select("#" + id);
    }

    @Override
    public Elements getByClass(Elements element, String clazz) {
        return element.select("." + element);
    }  
}
