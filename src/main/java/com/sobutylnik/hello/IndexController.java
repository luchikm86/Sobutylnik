package com.sobutylnik.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


    @Controller
    public class IndexController {

    @ResponseBody
    public String HelloWorld() {
        return "hello";
    }
}

//@Controller
//public class IndexController {
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String printHello(ModelMap model) {
//        model.addAttribute("message", "Hello Spring MVC Framework!");
//        return "hello";
//    }
//}

