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

    // getter
    public List<TouristAttraction> getTouristAttractions() { return touristAttractions; }

    // getter til navn
    public TouristAttraction getTouristAttractionByName(String name) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName() == name) {
                return touristAttraction;
            }
        }
        return null;
    }

    // tilføjer turistattraktion
    public void addTouristAttraction(TouristAttraction touristAttraction) { touristAttractions.add(touristAttraction); }

    // opdaterer turistattraktion
    public void updateTouristAttraction (TouristAttraction touristAttraction, String name, String description) {
        if (name != null){
            touristAttraction.setName(name);
        }
        else if (description != null){
            touristAttraction.setDescription(description);
        }
       }

    // generic remove
    public void removeTouristAttraction(TouristAttraction touristAttraction) { touristAttractions.remove(touristAttraction); }

    // remove by name
    public void deleteByName(String name) {
        TouristAttraction deletedAttraction = touristAttractions.get(0);

        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName() == name) {
                deletedAttraction = touristAttraction;
            }
        }
        removeTouristAttraction(deletedAttraction);
    }

}
