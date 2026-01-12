package it.defendimattia.backenddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import it.defendimattia.backenddemo.model.Watch;

/**
 * Repository for managing luxury watches.
 * 
 * <p>
 * Extends {@link JpaRepository} to provide basic CRUD operations
 * and {@link JpaSpecificationExecutor} to support advanced searches using
 * Specifications.
 * </p>
 * 
 * <p>
 * The managed entity is {@link Watch}.
 * </p>
 * 
 */
public interface WatchRepository extends JpaRepository<Watch, Integer>, JpaSpecificationExecutor<Watch> {

}
