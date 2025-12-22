package it.defendimattia.backenddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.defendimattia.backenddemo.model.Watch;
import it.defendimattia.backenddemo.repository.WatchRepository;

@Service
public class WatchService {

    @Autowired
    private WatchRepository watchRepo;

    public List<Watch> getAllWatches() {
        return watchRepo.findAll();
    }
}
