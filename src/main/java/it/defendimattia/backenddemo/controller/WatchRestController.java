package it.defendimattia.backenddemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
