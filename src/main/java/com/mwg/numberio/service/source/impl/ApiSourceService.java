package com.mwg.numberio.service.source.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mwg.numberio.service.source.NumberSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;

@Service("apiSource")
public class ApiSourceService implements NumberSourceService<Integer> {

    @Value("${api.base_url}")
    private String url;
    @Value("#{new Integer('${api.random.min}')}")
    private Integer min;
    @Value("#{new Integer('${api.random.max}')}")
    private Integer max;
    private RestTemplate restTemplate;
    private UriComponentsBuilder builder;
    @Autowired
    private ObjectMapper mapper;

    public ApiSourceService() {
        this.restTemplate = new RestTemplate();
    }

    @PostConstruct
    void postConstruct() {
        this.builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("min", min)
                .queryParam("max", max);
    }

    @Override
    public Integer getNumber() {
        String response = restTemplate.getForEntity(builder.toUriString(), String.class).getBody();
        if (response == null || response.isEmpty()) {
            return 0;
        } else {
            try {
                return mapper.readTree(response).findValue("random").asInt();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }
}
