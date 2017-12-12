package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by wusj on 2017/12/10.
 */
public class SpitterControllerTest {
    @Test
    public void showRegistrationForm() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"))
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 测试处理表单的控制器
     */
    @Test
    public void shouldProcessRegistration() throws Exception{
        SpitterRepository mockSpitterRepository  = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer", "jbauer@ctu.gov");
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer", "jbauer@ctu.gov");
        when(mockSpitterRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockSpitterRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(post("/spitter/register")
                .param("fisrtName", "Jack")
                .param("lastName", "Bauer")
                 .param("username", "jbauer")
                 .param("password", "24hours"))
                .andExpect(redirectedUrl("/spitter/jbauer"));
        //检验保存情况
        verify(mockSpitterRepository, atLeastOnce()).save(unsaved);

    }

}