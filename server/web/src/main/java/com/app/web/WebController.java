package com.app.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WebController {

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

}
