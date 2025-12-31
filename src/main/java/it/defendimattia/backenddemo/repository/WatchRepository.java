package it.defendimattia.backenddemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.defendimattia.backenddemo.model.Watch;

public interface WatchRepository extends JpaRepository<Watch, Integer> {

    public List<Watch> findByBrandIgnoreCaseContaining(String brand);
}
