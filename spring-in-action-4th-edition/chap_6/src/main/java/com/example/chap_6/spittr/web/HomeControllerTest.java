package com.example.chap_6.spittr.web;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController homeController = new HomeController();

        MockMvc mockMvc =
                standaloneSetup(homeController)
                        .addPlaceholderValue("path.home", "/homepage")
                        .addPlaceholderValue("path.root", "/")
                        .build();

        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }
}