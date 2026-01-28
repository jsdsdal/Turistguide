package com.example.turistguide.service;

import com.example.turistguide.model.TouristAttraction;
import com.example.turistguide.repository.TouristRepository;
import com.example.turistguide.repository.TouristRepository;

import java.util.List;

public class TouristService {

    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public List<TouristAttraction> getTouristAttractions(){
        return repository.getTouristAttractions();

    }

    public TouristAttraction getTouristAttractionByName(String name, String caps) {
        TouristAttraction touristAttraction = repository.getTouristAttractionByName(name);
        if (caps != null && caps.equals("yes")) {
            return new TouristAttraction(touristAttraction.getName(), touristAttraction.getDescription().toUpperCase());
        }
        return touristAttraction;
    }




}
