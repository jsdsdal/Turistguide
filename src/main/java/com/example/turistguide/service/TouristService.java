package com.example.turistguide.service;

import com.example.turistguide.model.TouristAttraction;
import com.example.turistguide.model.UpdateAttractionRequest;
import com.example.turistguide.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public List<TouristAttraction> getTouristAttractions(){
        return repository.getTouristAttractions();

    }

    public TouristAttraction getTouristAttractionByName(String name) {
        return repository.getTouristAttractionByName(name);
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction){
        return repository.addTouristAttraction(touristAttraction);
    }

    public UpdateAttractionRequest updateTouristAttraction(UpdateAttractionRequest touristAttraction, String name, String description){
        repository.updateTouristAttraction(touristAttraction, name, description);
        return touristAttraction;
    }

    public TouristAttraction updateTouristAttractionName(TouristAttraction touristAttraction, String name) {
        repository.updateTouristAttractionName(touristAttraction, name);
        return touristAttraction;
    }

    public TouristAttraction updateTouristAttractionDescription(TouristAttraction touristAttraction, String description) {
        repository.updateTouristAttractionDescription(touristAttraction, description);
        return touristAttraction;
    }

    public TouristAttraction deleteByName(String name){
        return repository.deleteByName(name);
    }


    }
