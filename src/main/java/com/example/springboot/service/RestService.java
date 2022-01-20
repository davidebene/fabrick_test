package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RestService<T> {

    @Value("${api.host.baseurl}")
    private String apiHost;

    @Value("${api.host.apiSchema}")
    private String apiSchema;

    @Value("${api.host.apiKey}")
    private String apiKey;

    public String getResponseEntity(String path) {
        RestTemplate restTemplate = new RestTemplate();

        String uri = String.format("%s%s", apiHost, path);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Auth-Schema", apiSchema);
        headers.set("Api-Key", apiKey);
        headers.set("X-Time-Zone", "Europe/Rome");

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(uri, HttpMethod.GET, entity, String.class);

        return responseEntity.getBody();
    }

    public String postResponseEntity(String path, T body) {
        RestTemplate restTemplate = new RestTemplate();

        String uri = String.format("%s%s", apiHost, path);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Auth-Schema", apiSchema);
        headers.set("Api-Key", apiKey);
        headers.set("X-Time-Zone", "Europe/Rome");


        HttpEntity<?> entity = new HttpEntity<T>(body, headers);
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(uri, HttpMethod.POST, entity, String.class);

        return responseEntity.getBody();
    }
}
