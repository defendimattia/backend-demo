package it.defendimattia.backenddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.defendimattia.backenddemo.model.Watch;
import it.defendimattia.backenddemo.service.WatchService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/watches")
public class WatchRestController {

    @Autowired
    private WatchService watchService;

    @GetMapping
    public List<Watch> index() {
        return watchService.getAllWatches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Watch> show(@PathVariable Integer id) {

        Watch watch = watchService.getWatchById(id);

        return ResponseEntity.ok(watch);
    }

    @GetMapping("/search")
    public List<Watch> searchWatches(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String caseMaterial,
            @RequestParam(required = false) String strapMaterial,
            @RequestParam(required = false) String movementType,
            @RequestParam(required = false) Short waterResistance,
            @RequestParam(required = false) Double caseDiameter,
            @RequestParam(required = false) Double caseThickness,
            @RequestParam(required = false) Double bandWidth,
            @RequestParam(required = false) String dialColor,
            @RequestParam(required = false) String crystalMaterial,
            @RequestParam(required = false) String complications,
            @RequestParam(required = false) Short powerReserve,
            @RequestParam(required = false) Integer maxPrice) {

        return watchService.search(
                brand, model, caseMaterial, strapMaterial, movementType,
                waterResistance, caseDiameter, caseThickness, bandWidth,
                dialColor, crystalMaterial, complications, powerReserve, maxPrice);
    }

}
