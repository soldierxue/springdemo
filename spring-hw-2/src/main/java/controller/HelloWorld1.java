package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Hello World Service
 */
@RestController
public class HelloWorld1 {
    
    @RequestMapping("/")
    public String index() {
        return "Hello World! The first Spring boot App Service";
    }
}