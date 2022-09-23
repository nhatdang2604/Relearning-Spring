package com.example.chap_5.spittr.web;

import com.example.chap_5.spittr.Spittle;
import com.example.chap_5.spittr.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("${path.spittles}")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String spittles(Model model) {

        List<Spittle> spittles = spittleRepository.findSpittles(Long.MAX_VALUE, 20);

        model.addAttribute("spittleList", spittles);

        return "spittles";
    }
}
