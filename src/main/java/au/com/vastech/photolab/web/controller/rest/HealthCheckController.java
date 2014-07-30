package au.com.vastech.photolab.web.controller.rest;

import au.com.vastech.photolab.core.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    private HealthService healthService;

    @Autowired
    public HealthCheckController(HealthService healthService) {
        this.healthService = healthService;
    }

    @RequestMapping("/health")
    public String getApplicationHealth() {
        return healthService.getApplicationHealth();
    }


}
