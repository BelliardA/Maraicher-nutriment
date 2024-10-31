package com.dev6.foodapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.dev6.foodapp.controller.AlimentController;
import com.dev6.foodapp.service.AlimentService;

@WebMvcTest(controllers = AlimentController.class)
public class AlimentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private AlimentService alimentService;

    @Test
    public void testGetAliments() throws Exception {
        mockMvc.perform(get("/aliments"))
                .andExpect(status().isOk());
    }

}
