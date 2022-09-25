package com.example.chap_5.spittr.web;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SpitterControllerTest {

    @Test
    public void shouldShowRegistration() throws Exception {

        //Placeholder building
        String[] keys = {"path.spitter", "path.spitter.register"};
        Map<String, String> placeholders = new HashMap<>();
        placeholders.put(keys[0], "/spitter");
        placeholders.put(keys[1], "/register");

        //Mocking test
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .addPlaceholderValue(keys[0], placeholders.get(keys[0]))
                .addPlaceholderValue(keys[1], placeholders.get(keys[1]))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.get(placeholders.get(keys[0]) + placeholders.get(keys[1])))
                .andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }

}