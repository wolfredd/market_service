package com.sagatrading.marketdata.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagatrading.marketdata.model.ProductData;
import com.sagatrading.marketdata.repository.ProductDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class ProductDataService {
    @Autowired
    ProductDataRepository productDataRepository;

    RestTemplate restTemplate = new RestTemplate();

    public void addProduct(){
        String url = "https://exchange.matraining.com/pd";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer your-access-token");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String productListStr = response.getBody();

        System.out.println("Response Body: " + productListStr);

        // check deserialization
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<ProductData> productDataList = objectMapper.readValue(productListStr, new TypeReference<List<ProductData>>() {});
            System.out.println(productDataList);
            productDataRepository.saveAll(productDataList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);

        }

    }

}
