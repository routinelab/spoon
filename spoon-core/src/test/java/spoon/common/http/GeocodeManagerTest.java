package spoon.common.http;

import org.junit.Before;
import org.junit.Test;

import static org.springframework.util.StringUtils.hasText;

public class GeocodeManagerTest {

    private GeocodeManager geocodeManager;

    @Before
    public void setUp() throws Exception {
        geocodeManager = new GeocodeManager();
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidParameter() throws Exception {
        geocodeManager.getGeocode("  ");
    }

    @Test
    public void validParameter() throws Exception {
        String geocode = geocodeManager.getGeocode("대구시 동구");
        hasText(geocode);
        System.out.println(geocode);
    }

}