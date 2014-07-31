package au.com.vastech.photolab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {


    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/services")
    public String services() {
        return "services";
    }

    @RequestMapping("/articles")
    public String articles() {
        return "articles";
    }

    @RequestMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }
}
