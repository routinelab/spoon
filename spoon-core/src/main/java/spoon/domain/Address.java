package spoon.domain;

import spoon.common.http.GeocodeManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.StringUtils.isEmpty;

public class Address {

    private String addr1;
    private String addr2;
    private Double lat;
    private Double lng;

    public Address(String addr1, String addr2) {
        this.addr1 = addr1;
        this.addr2 = addr2;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public void geoCoding(GeocodeManager geocodeManager) {
        String json = geocodeManager.getGeocode(makeAddress());
        Pattern p = Pattern.compile("lat[^0-9]+([0-9.]+)[^0-9]+([0-9.]+)");
        Matcher m = p.matcher(json);
        if (m.find()) {
            this.lat = Double.parseDouble(m.group(1));
            this.lng = Double.parseDouble(m.group(2));
        }
    }

    private String makeAddress() {
        hasText(addr1);

        StringBuffer sb = new StringBuffer();
        sb.append(addr1);
        if (!isEmpty(addr2)) sb.append(" ").append(addr2);

        return sb.toString();
    }
}
