package pl.eninja.meteo.cfg;

import org.junit.Test;
import springfox.documentation.spring.web.plugins.Docket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SwaggerConfigTest {

    @Test
    public void verifyDocket() {
        Docket docket = new SwaggerConfig().productApi();
        assertEquals("default", docket.getGroupName());
        assertNotNull(docket);
    }
}