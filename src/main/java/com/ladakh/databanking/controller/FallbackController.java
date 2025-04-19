package com.ladakh.databanking.controller; // Update with your package

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FallbackController {

    public FallbackController() {
        System.out.println("FallbackController loaded!");
    }
    @RequestMapping("/{path:^(?!api|static).*$}") // Avoid conflicts with API and static resources
    public String redirect() {
        System.out.println("Fallback triggered for: /{path}");
        return "forward:/index.html";
    }

    @RequestMapping("/test")
    public String testRoute() {
        System.out.println("Test route hit!");
        return "forward:/index.html";
    }
}
