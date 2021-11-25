package com.upgrad.springboottesting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NasaImageViewerController {

    @Autowired // Actual service
    private NasaService nas;

    @GetMapping("nasa/image/{key}")
    public ResponseEntity<?> seach(@PathVariable String key) throws JsonProcessingException {
        byte[] image = nas.search(key);
        if(image == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
}
