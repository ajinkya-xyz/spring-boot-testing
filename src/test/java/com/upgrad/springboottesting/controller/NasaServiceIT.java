package com.upgrad.springboottesting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NasaServiceIT {

    @Autowired
    private NasaService nasaService;

    @Test
    void shouldGetResponseFromService() throws JsonProcessingException {
        byte[] image = nasaService.search("india");
        assertThat(image, is(notNullValue()));
    }
}