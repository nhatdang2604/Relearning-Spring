package com.example.chap_5.spittr.web;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController homeController = new HomeController();
        assertEquals("home", homeController.home());
    }
}