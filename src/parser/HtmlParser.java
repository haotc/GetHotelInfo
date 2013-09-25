/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.IOException;
import org.jsoup.select.Elements;


/**
 *
 * @author WIN7
 */
public interface HtmlParser {
    public Elements getByID(String url, String id) throws IOException;
    public Elements getByClass(String url, String clazz) throws IOException;
    public Elements getByID(Elements element, String id);
    public Elements getByClass(Elements element, String clazz);
}
