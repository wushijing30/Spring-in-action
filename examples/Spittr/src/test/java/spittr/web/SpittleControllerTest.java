package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by wusj on 2017/12/8.
 */
public class SpittleControllerTest {

    @Test
    public void findSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
                .thenReturn(expectedSpittles);
        //测试SpittleController
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",
                        hasItems(expectedSpittles.toArray())))
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void showSpittle() throws Exception {
        Spittle expectedSpittle = new Spittle("Hello", new Date());
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(12345))
                .thenReturn(expectedSpittle);
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle))
                .andDo(MockMvcResultHandlers.print());
    }

    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++){
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

}