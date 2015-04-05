package spoon.domain;

import org.junit.Before;
import org.junit.Test;
import spoon.common.http.GeocodeManager;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AddressTest {

    private String addr1;
    private String addr2;

    @Before
    public void setUp() throws Exception {
        addr1 = "대한민국 대구광역시 동구 신암4동";
        addr2 = "144-32";
    }

    @Test
    public void canCreate() throws Exception {
        Address address = new Address(addr1, addr2);
        GeocodeManager geocodeManager = new GeocodeManager();

        address.geocoding(geocodeManager);

        assertThat(address.getLat(), is(35.8862363));
        assertThat(address.getLng(), is(128.6284085));
    }


}
