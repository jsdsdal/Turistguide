package com.example.turistguide.repository;


import com.example.turistguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() { populateTouristAttractions(); }

    // tilføjer alle attraktioner til listen
    public void populateTouristAttractions() {
        touristAttractions.add(new TouristAttraction("Tivoli", "Forlystelsespark"));
        touristAttractions.add(new TouristAttraction("Den Lille Havfrue", "Seværdighed"));
        touristAttractions.add(new TouristAttraction("Rundetårn", "Kulturarv"));
    }

    public List<TouristAttraction> getTouristAttractions() { return touristAttractions; }



}
