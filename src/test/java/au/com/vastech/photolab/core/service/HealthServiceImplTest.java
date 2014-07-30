package au.com.vastech.photolab.core.service;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HealthServiceImplTest {

    private HealthServiceImpl healthServiceImpl;
    @Before
    public void setup() {
        healthServiceImpl = new HealthServiceImpl();
    }

    @Test
    public void getApplicationHealth_WillReturnOk_WhenItsRunning() {
        assertThat(healthServiceImpl.getApplicationHealth(), is("APP-OK"));
    }

}