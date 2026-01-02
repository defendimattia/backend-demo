package it.defendimattia.backenddemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.defendimattia.backenddemo.model.Watch;

public interface WatchRepository extends JpaRepository<Watch, Integer> {

    public List<Watch> findByBrandIgnoreCaseContaining(String brand);

    public List<Watch> findByModelIgnoreCaseContaining(String model);

    public List<Watch> findByCaseMaterialIgnoreCaseContaining(String model);

    public List<Watch> findByStrapMaterialIgnoreCaseContaining(String model);

    public List<Watch> findByMovementTypeIgnoreCaseContaining(String model);

    public List<Watch> findByWaterResistanceGreaterThanEqual(String model);
}
