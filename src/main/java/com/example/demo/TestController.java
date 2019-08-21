package com.example.demo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/test")
    User test() {
        String urlGETList = "http://www.mocky.io/v2/5d5d9b85330000068057babe";

        ParameterizedTypeReference<ObjectWrapper<UserWrapper<User>>> typeRef = new ParameterizedTypeReference<ObjectWrapper<UserWrapper<User>>>() {};
        
        ResponseEntity<ObjectWrapper<UserWrapper<User>>> result = restTemplate.exchange(urlGETList, HttpMethod.GET, null, typeRef );

        return result.getBody().getObject().getUser();
    }
}