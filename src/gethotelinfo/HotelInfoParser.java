/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gethotelinfo;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author WIN7
 */
public interface HotelInfoParser {
    public String getName(Element result);
    public String getAddress(Element result);
    public String getDetailInfo(Element result);
    public double getPrice(Element result);
    public String getImageUrl(Element result);
}
