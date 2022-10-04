package com.example.chap_7.spittr.web;

import com.example.chap_7.spittr.Spitter;
import com.example.chap_7.spittr.data.SpitterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.util.HashMap;
import java.util.Map;

class SpitterControllerTest {

    private Map<String, String> placeholders;
    private String[] keys = new String[]{"path.spitter", "path.spitter.register"};

    //Construct the placeholder for each test
    @BeforeEach
    public void buildPlaceholder() {
        placeholders = new HashMap<>();
        placeholders.put(keys[0], "/spitter");
        placeholders.put(keys[1], "/register");
    }

    //Add the placeholder with <key, value>, to the MockMvcBuilder
    private StandaloneMockMvcBuilder placeholderBuilder(Object controller) {
        StandaloneMockMvcBuilder builder = MockMvcBuilders.standaloneSetup(controller);
        for (Map.Entry<String, String> entry: placeholders.entrySet()) {
            builder = builder.addPlaceholderValue(entry.getKey(), entry.getValue());
        }

        return builder;
    }


    @Test
    public void shouldShowRegistration() throws Exception {

        //Placeholder building
//        String[] keys = {"path.spitter", "path.spitter.register"};
//        Map<String, String> placeholders = new HashMap<>();
//        placeholders.put(keys[0], "/spitter");
//        placeholders.put(keys[1], "/register");

        //Mocking test
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = placeholderBuilder(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get(placeholders.get(keys[0]) + placeholders.get(keys[1])))
                .andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository =
                Mockito.mock(SpitterRepository.class);

        String username = "test_username";
        Spitter unsaved =
                new Spitter(null, username, "test_password", "test_firstName", "test_lastName");

        Spitter saved =
                new Spitter(0L, username, "test_password", "test_firstName", "test_lastName");

        Mockito.when(mockRepository.save(unsaved))
                .thenReturn(saved);

        SpitterController spitterController = new SpitterController(mockRepository);

        //Add ROOT property with value "/spitter" (because ROOT injected by using @Value)
        ReflectionTestUtils.setField(spitterController, "ROOT", placeholders.get(keys[0]));

        MockMvc mockMvc = placeholderBuilder(spitterController).build();

        mockMvc.perform(MockMvcRequestBuilders.post(placeholders.get(keys[0]) + placeholders.get(keys[1]))
                .param("firstName", "test_firstName")
                .param("lastName", "test_lastName")
                .param("username", "test_username")
                .param("password", "test_password"))
                .andExpect(MockMvcResultMatchers.redirectedUrl(placeholders.get(keys[0]) + "/" + username));

        Mockito.verify(mockRepository, Mockito.atLeastOnce()).save(unsaved);

    }


}