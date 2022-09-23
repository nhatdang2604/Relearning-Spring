package com.example.chap_5.spittr.web;

import com.example.chap_5.spittr.Spittle;
import com.example.chap_5.spittr.data.SpittleRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SpittleControllerTest {

    private List<Spittle> createSpittleList(long count) {
        List<Spittle> spittles = new ArrayList<>();

        for (long i = 0; i < count; ++i) {
            spittles.add(new Spittle(i, "test " + i, new Date(i), new Double(i), new Double(i)));
        }

        return spittles;
     }

    @Test
    public void shouldShowRecentSpittles() throws Exception {

        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);

        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE,20))
                .thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);

        //Placeholders support
        Map<String, String> placeholders = new HashMap<>();
        placeholders.put("path.spittles", "/spittles");

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .addPlaceholderValue("path.spittles", placeholders.get("path.spittles"))
                .build();

        String spittleListKey = "spittleList";

        mockMvc.perform(MockMvcRequestBuilders.get(placeholders.get("path.spittles")))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists(spittleListKey))
                .andExpect(MockMvcResultMatchers.model().attribute(spittleListKey,
                        Matchers.hasItems(expectedSpittles.toArray())));

    }
}