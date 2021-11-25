package com.upgrad.springboottesting.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NasaImageViewerControllerTest {
    @Autowired
    private MockMvc mvc;
    
    @MockBean // Dummy Service
    private NasaService nasaService;
    
    @Autowired
    private NasaImageViewerController controller;

    @Test
    void shouldReturnImageForKeyword() throws Exception {

        mvc.perform(get("/nasa/image/india"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.IMAGE_JPEG));

    }

    @Test
    void shouldThrowExceptionIfServiceResponseIsNull() throws Exception {
        Mockito.when(nasaService.search(anyString())).thenReturn(null);
        //Mockito.when(nasaService.readFromDatabase(1L)).thenReturn("dummy data");
        //Mockito.when(databaseClass.searchFromDatabase(anyString())).thenReturn(result);
        mvc.perform(get("/nasa/image/india"))
                .andExpect(status().isBadRequest());


    }
}