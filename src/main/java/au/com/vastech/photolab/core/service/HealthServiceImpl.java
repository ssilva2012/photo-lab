package au.com.vastech.photolab.core.service;

import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl implements HealthService {

    @Override
    public String getApplicationHealth() {
        return "APP-OK";
    }
}
