package com.example.chap_5.spittr.web;

import com.example.chap_5.spittr.Spitter;
import com.example.chap_5.spittr.data.SpitterRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value="${path.spitter.register}", method=RequestMethod.POST)
    public String processRegistration(Spitter spitter) {

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
