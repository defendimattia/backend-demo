package it.defendimattia.backenddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.defendimattia.backenddemo.model.Watch;
import it.defendimattia.backenddemo.repository.WatchRepository;

@Service
public class WatchService {

    @Autowired
    private WatchRepository watchRepo;

    public List<Watch> getAllWatches() {
        return watchRepo.findAll();
    }

    public Watch getWatchById(Integer id) {

        Optional<Watch> watchTry = watchRepo.findById(id);

        if (watchTry.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "watch not found with id " + id);
        }

        return watchTry.get();
    }
}
