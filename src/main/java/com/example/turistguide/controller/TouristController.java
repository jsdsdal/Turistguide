package com.example.turistguide.controller;

import com.example.turistguide.model.TouristAttraction;
import com.example.turistguide.model.UpdateAttractionRequest;
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
    public TouristController(TouristService service) {
        this.service = service;
    }

    @RequestMapping("/attractions")
    public String attractions(@RequestParam (required = false) String name,
                              @RequestParam (required = false) String description, Model page) {
        var attractions = service.getTouristAttractions();
        page.addAttribute("attractions", attractions);
        page.addAttribute("name", name);
        page.addAttribute("description", description);

        return "attraction";
    }


    @GetMapping()
    public ResponseEntity<List<TouristAttraction>> getTouristAttractions() {
        List<TouristAttraction> touristAttractions = service.getTouristAttractions();
        if (touristAttractions.isEmpty()) {
            return new ResponseEntity<>(touristAttractions, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<TouristAttraction> getTouristAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = service.getTouristAttractionByName(name);
        if (touristAttraction==null) {
            return new ResponseEntity<>(touristAttraction, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
        }
    }

    @PostMapping("add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction addedTouristAttraction = service.addTouristAttraction(touristAttraction);
        return ResponseEntity.ok(touristAttraction);
    }

    @PostMapping("update")
    public ResponseEntity<UpdateAttractionRequest> updateTouristAttraction(@RequestBody UpdateAttractionRequest request, String name, String description){
        System.out.println(request + " <-- initial object");
        UpdateAttractionRequest updatedTouristAttraction = service.updateTouristAttraction(request, request.getNewName(), request.getNewDescription());
        System.out.println(updatedTouristAttraction + " <-- updated object object");
        return ResponseEntity.ok(updatedTouristAttraction);
    }


    @PostMapping("{name}")
    public ResponseEntity<TouristAttraction> deleteByName(@PathVariable String name) {
        TouristAttraction touristAttraction = service.deleteByName(name);
        if (touristAttraction==null) {
            return new ResponseEntity<>(touristAttraction, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
        }
    }

}
