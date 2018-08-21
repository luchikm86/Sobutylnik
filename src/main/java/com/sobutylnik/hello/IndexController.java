package com.sobutylnik.hello;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ResponseBody;



@Controller
    public class IndexController {

        @ResponseBody
        public String textHello() {
            return "Hello, Sobutylnik!";
        }
}

