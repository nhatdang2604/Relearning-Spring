package com.example.chap_5.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("${path.spitter}")
public class SpitterController {

    @RequestMapping(value="${path.spitter.register}", method= RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

}
