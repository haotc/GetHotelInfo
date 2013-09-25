/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gethotelinfo;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author WIN7
 */
public class GetHotelInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        try {
//            String url = "http://www.kayak.com/hotels/Ho-Chi-Minh-City,Vietnam-c18144";
//            HotelInfoParser hotelsParser = new KayakHotelsParser(url);
//            Elements resultList = ((KayakHotelsParser)hotelsParser).getResultList();
//            // Get info
//            for (Element element : resultList) {
//                String address = hotelsParser.getAddress(element);
//                String name = hotelsParser.getName(element);
//                double price = hotelsParser.getPrice(element);
//                String detailInfo = hotelsParser.getDetailInfo(element);
//                Hotel hotel = new Hotel(name, detailInfo, price, address);
//                System.out.println("Hotel: " + hotel.toString() + "Image Url : " + hotelsParser.getImageUrl(element));
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(GetHotelInfo.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            String url = "http://mytour.vn/c3/khach-san-tai-ho-chi-minh-sai-gon.html";
            HotelInfoParser hotelsParser = new MyTourHotelsParser(url);
            Elements resultList = ((MyTourHotelsParser) hotelsParser).getResultList();
            // Get info
            for (Element element : resultList) {
                String address = hotelsParser.getAddress(element);
                String name = hotelsParser.getName(element);
                double price = hotelsParser.getPrice(element);
                String detailInfo = hotelsParser.getDetailInfo(element);
                Hotel hotel = new Hotel(name, detailInfo, price, address);
                System.out.println("Hotel: " + hotel.toString() + "Image Url : " + hotelsParser.getImageUrl(element));
            }
        } catch (IOException ex) {
            Logger.getLogger(GetHotelInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
