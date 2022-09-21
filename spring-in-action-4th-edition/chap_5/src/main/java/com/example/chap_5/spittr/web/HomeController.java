package com.example.chap_5.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@PropertySource("classpath:application.properties")
public class HomeController {

    @RequestMapping(value="${path.home}", method=RequestMethod.GET)
    public String home() {
        return "home";
    }

}
