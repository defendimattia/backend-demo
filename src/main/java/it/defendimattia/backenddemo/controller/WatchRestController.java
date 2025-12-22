package it.defendimattia.backenddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.defendimattia.backenddemo.model.Watch;
import it.defendimattia.backenddemo.repository.WatchRepository;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/watches")
public class WatchRestController {

    @Autowired
    private WatchRepository watchRepo;

    @GetMapping
    public List<Watch> index() {
        return watchRepo.findAll();
    }

}
