package spoon.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class OwnerTest {

    @Test
    public void canCreate() throws Exception {

        Owner owner = new Owner("username", "password");
        assertNotNull(owner);

    }
}
