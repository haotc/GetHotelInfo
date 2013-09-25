/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gethotelinfo;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
//        try {
//            String url = "http://mytour.vn/c3/khach-san-tai-ho-chi-minh-sai-gon.html";
//            HotelInfoParser hotelsParser = new MyTourHotelsParser(url);
//            Elements resultList = ((MyTourHotelsParser) hotelsParser).getResultList();
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
            Elements resultList = null;
            YesGoHotelsParser hotelsParser = null;
//            String url = "http://www.yesgo.vn/vi/khach-san/viet-nam/ho-chi-minh.html?gclid=CL-0xpPO3rkCFRF64godaUQA_A";
            String url = "http://www.yesgo.vn/vi/khach-san/viet-nam/ho-chi-minh.html?page=14&gclid=CL-0xpPO3rkCFRF64godaUQA_A";
            Hotel hotel = null;
            List<Hotel> hotelList = new ArrayList<Hotel>();
            int count = 0;
            do {
                hotelsParser = new YesGoHotelsParser(url);
                resultList = ((YesGoHotelsParser) hotelsParser).getResultList();
                // Get info
                for (Element element : resultList) {
                    String address = hotelsParser.getAddress(element);
                    String name = hotelsParser.getName(element);
                    double price = hotelsParser.getPrice(element);
                    String detailInfo = hotelsParser.getDetailInfo(element);
                    hotelList.add(new Hotel(name, detailInfo, price, address));
                    System.out.println(++count);
//                    System.out.println("Hotel: " + hotel.toString() + "Image Url : " + hotelsParser.getImageUrl(element));
                }
                url = hotelsParser.getNextPageUrl(url);
            } while (url != null);
            System.out.println("Hello hotels");
        } catch (IOException ex) {
            Logger.getLogger(GetHotelInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
