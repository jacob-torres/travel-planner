package com.app.welcome;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.welcome.WelcomeBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WelcomeController {
    // Test server-client connection with the welcome component
    @GetMapping(path = "/welcome")
    public String welcome() {
        return "Welcome friend!";
    }

    // Add path variable to welcome path
    @GetMapping(path = "/welcome/{name}")
    public String dynamicWelcome(@PathVariable String name) {
        return String.format("Welcome %s!", name);
    }

    // Get welcome bean rather than plain string
    @GetMapping(path = "/welcomebean/{name}")
    public WelcomeBean welcomeBean(@PathVariable String name) {
        return new WelcomeBean(String.format("Welcome %s!", name));
    }
}
