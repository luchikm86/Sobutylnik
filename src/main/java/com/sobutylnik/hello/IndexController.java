package com.sobutylnik.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private static final String hello = "Hello";

    @RequestMapping("/")
//    @RequestMapping(value = "/index", produces = MediaType.APPLICATION_JSON_VALUE)
    public String index(){
        return hello;
    }
}
