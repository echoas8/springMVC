package Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringJUnitWebConfig(locations = {"classpath:spring-mvc.xml"})
class restControllerTest {
    MockMvc mockMvc;

    @BeforeEach
    void before(WebApplicationContext w){
        mockMvc= MockMvcBuilders.webAppContextSetup(w).build();
    }

    @Test
    void getUser() {
        try {
            ResultActions per=mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}",1));
            MockHttpServletResponse res=per.andReturn().getResponse();
            System.out.println(res.getContentType());
            System.out.println(res.getStatus());
            System.out.println(res.getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAllUser() {
        try {
            ResultActions per=mockMvc.perform(MockMvcRequestBuilders.get("/user"));
            MockHttpServletResponse res=per.andReturn().getResponse();
            System.out.println(res.getContentType());
            System.out.println(res.getStatus());
            System.out.println(res.getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void addUser() {
    }
}