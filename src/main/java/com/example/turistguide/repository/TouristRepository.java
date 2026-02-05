package com.example.turistguide.repository;


import com.example.turistguide.model.TouristAttraction;
import com.example.turistguide.model.UpdateAttractionRequest;
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
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    // tilføjer turistattraktion
    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) { touristAttractions.add(touristAttraction); return touristAttraction; }

    // opdaterer turistattraktion
    public void updateTouristAttraction (UpdateAttractionRequest touristAttraction, String name, String description) {
        if (name != null && description != null){

            for (TouristAttraction element : touristAttractions) {
                if (element.getName().equalsIgnoreCase(touristAttraction.getNewName())) {
                    touristAttraction.setNewName(name);
                    touristAttraction.setNewDescription(description);
                }
            }
        }
       }

    // opdaterer kun navn
    public void updateTouristAttractionName (TouristAttraction touristAttraction, String name) {
        if (name != null) {
            touristAttraction.setName(name);
        }
    }

    // opdaterer beskrivelse
    public void updateTouristAttractionDescription (TouristAttraction touristAttraction, String description) {
        if (description != null) {
            touristAttraction.setName(description);
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
