package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.InfoHabitantes;

@Service
public class PopulationService {
    
    @Autowired
    RestTemplate restTemplate;

    public InfoHabitantes getPopulationFromAPI(String cad){
        String url = "https://geocoding-api.open-meteo.com/v1/search?name="+cad;
        InfoHabitantes text = restTemplate.getForObject(url, InfoHabitantes.class);
        return text;
    }

}
