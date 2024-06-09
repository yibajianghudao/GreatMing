package com.Web.GreatMing;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/hello")
    public List<String> hello() {
        return List.of("Hello","World");
    }
}
