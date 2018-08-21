package com.sobutylnik.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
    public class IndexController {

        @RequestMapping(value="/index", method=GET)
        @ResponseBody
        public String textHello() {
            return "Hello, Sobutylnik!";
        }
}

