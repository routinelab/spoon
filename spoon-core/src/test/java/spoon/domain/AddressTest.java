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
        addr1 = "서울 서초구 양재동";
        addr2 = "양재역";
    }

    @Test
    public void canCreate() throws Exception {
        Address address = new Address(addr1, addr2);
        GeocodeManager geocodeManager = new GeocodeManager();

        address.geoCoding(geocodeManager);

        assertThat(address.getLat(), is(37.48366499999999));
        assertThat(address.getLng(), is(127.034796));
    }


}
