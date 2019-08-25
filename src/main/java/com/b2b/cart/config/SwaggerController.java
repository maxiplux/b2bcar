package com.b2b.cart.config;


import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: franc
 * Date: 09/09/2018
 * Time: 8:09
 */
//@Controller //note - this is a spring-boot controller, not @RestController
public class SwaggerController {
    @RequestMapping("/docs")
    public String home() {
        return "redirect:/swagger-ui.html";
    }
}
