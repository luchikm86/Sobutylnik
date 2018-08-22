package com.sobutylnik.hello;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
    public class IndexController {

//        @ResponseBody
//        public String textHello() {
//            return "Hello";
//        }

    @RequestMapping(value = "/index", produces = MediaType.APPLICATION_JSON_VALUE)
    public String textHello() { return "Hello"; }
}

