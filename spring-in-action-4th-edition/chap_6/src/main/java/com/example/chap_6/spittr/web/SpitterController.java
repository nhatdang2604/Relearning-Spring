package com.example.chap_6.spittr.web;

import com.example.chap_6.spittr.Spitter;
import com.example.chap_6.spittr.data.SpitterRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("${path.spitter}")
@NoArgsConstructor
public class SpitterController {

    private static final String PARAM_SPITTER_USERNAME = "username";
    @Value("${path.spitter}")
    private String ROOT;

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value="${path.spitter.register}", method=RequestMethod.GET)
    public String showRegistrationForm(Spitter spitter) {
        return "registerForm";
    }

    @RequestMapping(value="${path.spitter.register}", method=RequestMethod.POST)
    public String processRegistration(
            @Valid Spitter spitter,
            Errors errors) {

        if (errors.hasErrors()) {
            return "registerForm";
        }

        spitterRepository.save(spitter);
        return "redirect:" + ROOT + "/" + spitter.getUsername();
    }

    @RequestMapping(value="/{" + PARAM_SPITTER_USERNAME + "}", method=RequestMethod.GET)
    public String showSpitterProfile(
            @PathVariable(PARAM_SPITTER_USERNAME) String username,
            Model model
    ) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);

        return "profile";
    }

}
