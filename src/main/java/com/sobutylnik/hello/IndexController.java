package com.sobutylnik.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {

    @RequestMapping ( "/index" )
    public ModelAndView helloWorld () {
        ModelAndView mav = new ModelAndView ();
        mav.setViewName ( "helloWorld" );
        mav.addObject ("Hello World!");
        return mav;
    }
}
