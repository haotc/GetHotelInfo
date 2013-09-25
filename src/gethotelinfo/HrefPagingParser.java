package gethotelinfo;

import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: haotc
 * Date: 9/25/13
 * Time: 2:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface HrefPagingParser {
    String getNextPageUrl(String e) throws IOException;
}
