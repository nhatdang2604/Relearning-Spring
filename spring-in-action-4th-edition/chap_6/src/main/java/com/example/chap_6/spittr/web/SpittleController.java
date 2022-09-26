package com.example.chap_6.spittr.web;

import com.example.chap_6.spittr.Spittle;
import com.example.chap_6.spittr.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("${path.spittles}")
public class SpittleController {

    private static final String PARAM_SPITTLE_ID = "spittle-id";
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    //1st approach
//    @RequestMapping(method=RequestMethod.GET)
//    public String spittles(Model model) {
//
//        List<Spittle> spittles = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
//
//        model.addAttribute("spittleList", spittles);
//
//        return "spittles";
//    }

    //2nd approach
//    @RequestMapping(method=RequestMethod.GET)
//    public String spittles(Map model) {
//
//        List<Spittle> spittles = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
//
//        model.put("spittleList", spittles);
//
//        return "spittles";
//    }

    //3rd approach
    @RequestMapping(method=RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value="max", defaultValue="9223372036854775807") long max,
            @RequestParam(value="count", defaultValue="20") int count
    ) {

        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value="${path.spittles.show}", method=RequestMethod.GET)
    public String showSpittle(
            @RequestParam("spittle-id") long spittleId,
            Model model
    ) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (null == spittle) {
            spittle = new Spittle();
        }
        model.addAttribute(spittle);

        return "spittle";
    }

    @RequestMapping(value="/{" + PARAM_SPITTLE_ID + "}", method=RequestMethod.GET)
    public String spittle(
            @PathVariable(PARAM_SPITTLE_ID) long spittleId,
            Model model
    ) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (null == spittle) {
            spittle = new Spittle();
        }
        model.addAttribute(spittle);

        return "spittle";
    }
}
