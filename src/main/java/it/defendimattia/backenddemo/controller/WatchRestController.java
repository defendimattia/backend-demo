package it.defendimattia.backenddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.defendimattia.backenddemo.model.Watch;
import it.defendimattia.backenddemo.service.WatchService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/watches")
public class WatchRestController {

    @Autowired
    private WatchService watchService;

    @GetMapping
    public List<Watch> index() {
        return watchService.getAllWatches();
    }

}
