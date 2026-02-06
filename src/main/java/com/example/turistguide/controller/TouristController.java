package com.example.turistguide.controller;

import com.example.turistguide.model.TouristAttraction;
import com.example.turistguide.model.UpdateAttractionRequest;
import com.example.turistguide.service.LoggedUserManagementService;
import com.example.turistguide.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TouristController {
    private final TouristService service;
    private final LoggedUserManagementService loggedUserManagementService;

    public TouristController(TouristService service, LoggedUserManagementService loggedUserManagementService) {
        this.service = service;
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model page) {
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }
        String username = loggedUserManagementService.getUsername();

        if (username == null) {
            return "redirect:/";
        }
        page.addAttribute("username", username);
        return "main.html";
    }

    @PostMapping("/main?logout")
    public ResponseEntity<String> logout(@RequestParam(required = false) String logout) {
        String username = loggedUserManagementService.getUsername();
        loggedUserManagementService.setUsername(null);

        return new ResponseEntity<>("we good", HttpStatus.OK);
    }


    @PostMapping("/attractions")
    public String addTouristAttraction(TouristAttraction object, Model model) {
        service.addTouristAttraction(object);
        var attractions = service.getTouristAttractions();
        model.addAttribute("attractions", attractions);
        return "main";
    }


    @GetMapping("/api/attractions")
    public ResponseEntity<List<TouristAttraction>> getTouristAttractions() {
        List<TouristAttraction> touristAttractions = service.getTouristAttractions();
        if (touristAttractions.isEmpty()) {
            return new ResponseEntity<>(touristAttractions, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    @GetMapping("/attractions/{name}")
    public ResponseEntity<TouristAttraction> getTouristAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = service.getTouristAttractionByName(name);
        if (touristAttraction == null) {
            return new ResponseEntity<>(touristAttraction, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
        }
    }

    @PostMapping("/api/attractions")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction addedTouristAttraction = service.addTouristAttraction(touristAttraction);
        return ResponseEntity.ok(touristAttraction);
    }

    @PutMapping("/api/attractions/{originalName}")
    public ResponseEntity<UpdateAttractionRequest> updateTouristAttraction(@RequestBody UpdateAttractionRequest request,
                                                                           @PathVariable String originalName) {
        UpdateAttractionRequest updatedTouristAttraction = service.updateTouristAttraction(request, request.getNewName(), request.getNewDescription());
        return ResponseEntity.ok(updatedTouristAttraction);
    }


    @DeleteMapping("/api/attractions/{name}")
    public ResponseEntity<TouristAttraction> deleteByName(@PathVariable String name) {
        TouristAttraction touristAttraction = service.deleteByName(name);
        if (touristAttraction == null) {
            return new ResponseEntity<>(touristAttraction, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
        }
    }

}
