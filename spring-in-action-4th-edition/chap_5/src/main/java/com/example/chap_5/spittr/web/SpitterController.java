package com.example.chap_5.spittr.web;

import com.example.chap_5.spittr.Spitter;
import com.example.chap_5.spittr.data.SpitterRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("${path.spitter}")
@AllArgsConstructor
public class SpitterController {

    @Value("${path.spitter}")
    private final String ROOT;

    private SpitterRepository spitterRepository;

    @RequestMapping(value="${path.spitter.register}", method=RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value="${path.spitter.register}", method=RequestMethod.POST)
    public String processRegistration(Spitter spitter) {

        spitterRepository.save(spitter);

        return "redirect:" + ROOT + "/" + spitter.getUsername();
    }

}
