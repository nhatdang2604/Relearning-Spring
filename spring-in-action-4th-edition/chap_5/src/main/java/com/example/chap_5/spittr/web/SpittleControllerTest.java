package com.example.chap_5.spittr.web;

import com.example.chap_5.spittr.Spittle;
import com.example.chap_5.spittr.data.SpittleRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.*;

class SpittleControllerTest {


    private Map<String, String> placeholders;

    //Construct the placeholder for each test
    @BeforeEach
    public void buildPlaceholder() {
        placeholders = new HashMap<>();
        placeholders.put("path.spittles", "/spittles");
        placeholders.put("path.spittles.show", "/show");
        placeholders.put("param.spittle.id", "spittleId");
    }

    //Add the placeholder with <key, value>, to the MockMvcBuilder
    private StandaloneMockMvcBuilder placeholderBuilder(Object controller) {
        StandaloneMockMvcBuilder builder = MockMvcBuilders.standaloneSetup(controller);
        for (Map.Entry<String, String> entry: placeholders.entrySet()) {
            builder = builder.addPlaceholderValue(entry.getKey(), entry.getValue());
        }

        return builder;
    }

    private List<Spittle> createSpittleList(long count) {
        List<Spittle> spittles = new ArrayList<>();

        for (long i = 0; i < count; ++i) {
            spittles.add(new Spittle(i, "test " + i, new Date(i), new Double(i), new Double(i)));
        }

        return spittles;
     }


    @Test
    public void shouldShowRecentSpittles() throws Exception {

        long max = 238900;
        int count = 50;

        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);

        Mockito.when(mockRepository.findSpittles(max, count))
                .thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);

        MockMvc mockMvc = placeholderBuilder(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();

        String spittleListKey = "spittleList";

        mockMvc.perform(MockMvcRequestBuilders.get(placeholders.get("path.spittles") + "?max=" + max +"&count=" + count))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists(spittleListKey))
                .andExpect(MockMvcResultMatchers.model().attribute(spittleListKey,
                        Matchers.hasItems(expectedSpittles.toArray())));

    }

    @Test
    public void testSpittle() throws Exception {

        long spittleId = 0;
        Spittle expectedSpittle =
                new Spittle(spittleId, "test " + spittleId, new Date(spittleId), new Double(spittleId), new Double(spittleId));

        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findOne(0))
                .thenReturn(expectedSpittle);

        SpittleController spittleController = new SpittleController(mockRepository);
        MockMvc mockMvc = placeholderBuilder(spittleController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles/" + spittleId))
                .andExpect(MockMvcResultMatchers.view().name("spittle"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittle"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittle", expectedSpittle));
    }
}