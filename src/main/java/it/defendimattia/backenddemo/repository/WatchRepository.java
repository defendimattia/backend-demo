package it.defendimattia.backenddemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.defendimattia.backenddemo.model.Watch;

public interface WatchRepository extends JpaRepository<Watch, Integer> {

    public List<Watch> findByBrandIgnoreCaseContaining(String brand);

    public List<Watch> findByModelIgnoreCaseContaining(String model);

    public List<Watch> findByCaseMaterialIgnoreCaseContaining(String caseMaterial);

    public List<Watch> findByStrapMaterialIgnoreCaseContaining(String strapMaterial);

    public List<Watch> findByMovementTypeIgnoreCaseContaining(String movementType);

    public List<Watch> findByWaterResistanceGreaterThanEqual(Short waterResistance);

    public List<Watch> findByCaseDiameterGreaterThanEqualAndCaseDiameterLessThan(Double min, Double max);

    public List<Watch> findByCaseDiameterGreaterThanEqual(Double diameter);

    public List<Watch> findByCaseDiameterLessThanEqual(Double diameter);

    public List<Watch> findByCaseThicknessGreaterThanEqualAndCaseDiameterLessThan(Double min, Double max);

    public List<Watch> findByCaseThicknessGreaterThanEqual(Double caseThickness);

    public List<Watch> findByCaseThicknessLessThanEqual(Double caseThickness);

    public List<Watch> findByBandWidthGreaterThanEqualAndCaseDiameterLessThan(Double min, Double max);

    public List<Watch> findByBandWidthGreaterThanEqual(Double bandWidth);

    public List<Watch> findByBandWidthLessThanEqual(Double bandWidth);

    public List<Watch> findByDialColorIgnoreCaseContaining(String dialColor);

    public List<Watch> findByCrystalMaterialIgnoreCaseContaining(String crystalMaterial);

    public List<Watch> findByComplicationsIgnoreCaseContaining(String complications);

    public List<Watch> findByPowerReserveGreaterThanEqual(Short powerReserve);

    public List<Watch> findByPriceLessThanEqual(Integer bprice);

}
