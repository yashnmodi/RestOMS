package com.mysquare.restoms.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {
    private static RestTemplate rt;

    public TestService(){
        rt = new RestTemplate();
    }

    public Map getTopStories() {
        String url = "https://api.nytimes.com/svc/topstories/v2/home.json?api-key=7OLGG4jKKvsV7RXvU9mabgZNalrV1lGD";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<Map> response = rt.exchange(url, HttpMethod.GET, entity, Map.class);


        if(response.getStatusCode() == HttpStatus.OK){
            return response.getBody();
        }
        return (Map) new HashMap().put("GNE", "Sorry something went worong.");
    }
}
