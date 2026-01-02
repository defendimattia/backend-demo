package it.defendimattia.backenddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.defendimattia.backenddemo.model.Watch;
import it.defendimattia.backenddemo.service.WatchService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/searchByBrand")
    public List<Watch> searchBrand(@RequestParam(name = "query") String query) {

        return watchService.searchByBrand(query);
    }

    @GetMapping("/searchByModel")
    public List<Watch> searchModel(@RequestParam(name = "query") String query) {

        return watchService.searchByModel(query);
    }

    @GetMapping("/searchByCaseMaterial")
    public List<Watch> searchCaseMaterial(@RequestParam(name = "query") String query) {

        return watchService.searchByCaseMaterial(query);
    }

    @GetMapping("/searchByStrapMaterial")
    public List<Watch> searchStrapMaterial(@RequestParam(name = "query") String query) {

        return watchService.searchByStrapMaterial(query);
    }

    @GetMapping("/searchByMovementType")
    public List<Watch> searchMovementType(@RequestParam(name = "query") String query) {

        return watchService.searchByMovementType(query);
    }

    @GetMapping("/searchByWaterResistance")
    public List<Watch> searchWaterResistance(@RequestParam(name = "query") String query) {

        return watchService.searchByWaterResistance(query);
    }

}
