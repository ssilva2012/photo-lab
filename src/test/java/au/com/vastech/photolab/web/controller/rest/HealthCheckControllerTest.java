package au.com.vastech.photolab.web.controller.rest;

import au.com.vastech.photolab.Application;
import au.com.vastech.photolab.core.service.HealthServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class HealthCheckControllerTest {

    private MockMvc mockMvc;

    @Mock
    private HealthServiceImpl healthServiceImpl;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new HealthCheckController(healthServiceImpl)).build();
    }

    @Test
    public void getApplicationHealth_WillReturnTrue_WhenItsUp() throws Exception {
        whenApplicationOkay();
        mockMvc.perform(get("/health"))
               .andExpect(status().isOk());
    }

    @Test
    public void getApplicationHealth_WillReturnTrue_WhenItsUp2() throws Exception {
        whenApplicationOkay();
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("APP-OK"));
    }

    @Test
    public void getApplicationHealth_WillReturnFalse_WhenItsNotUp() throws Exception {
        whenApplicationError();
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("APP-ERROR"));
    }

    private void whenApplicationOkay() {
        when(healthServiceImpl.getApplicationHealth()).thenReturn("APP-OK");
    }

    private void whenApplicationError() {
        when(healthServiceImpl.getApplicationHealth()).thenReturn("APP-ERROR");
    }

}