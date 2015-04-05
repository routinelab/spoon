package spoon.common.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.StringUtils.replace;

public class GeocodeManager {

    private static final String GOOGLE_GEOCODE_URL = "http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=";
    private static final Logger logger = LoggerFactory.getLogger(GeocodeManager.class);

    public String getGeocode(String addr) {
        hasText(addr);

        String url = GOOGLE_GEOCODE_URL + replace(addr, " ", "%20");
        StringBuffer sb = new StringBuffer();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
        } catch (MalformedURLException e) {
            logger.warn("해당 주소로 JSON을 가져오지 못합니다. : {}", url);
        } catch (IOException e) {
            logger.error("해당 주소로 접속할 수 없습니다. : {}", url);
        }
        return sb.toString();
    }
}
