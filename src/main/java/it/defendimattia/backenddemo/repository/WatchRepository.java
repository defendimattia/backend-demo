package it.defendimattia.backenddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import it.defendimattia.backenddemo.model.Watch;

public interface WatchRepository extends JpaRepository<Watch, Integer>, JpaSpecificationExecutor<Watch> {

}
