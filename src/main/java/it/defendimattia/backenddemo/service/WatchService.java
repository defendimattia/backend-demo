package it.defendimattia.backenddemo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.defendimattia.backenddemo.model.Watch;
import it.defendimattia.backenddemo.repository.WatchRepository;
import it.defendimattia.backenddemo.specification.WatchSpecification;

@Service
public class WatchService {

    @Autowired
    private WatchRepository watchRepo;

    public List<Watch> getAllWatches() {
        return watchRepo.findAll();
    }

    public Watch getWatchById(Integer id) {
        return watchRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Watch not found with id " + id));
    }

    public List<Watch> search(String brand,
            String model,
            String caseMaterial,
            String strapMaterial,
            String movementType,
            Short waterResistance,
            BigDecimal caseDiameter,
            BigDecimal caseThickness,
            BigDecimal bandWidth,
            String dialColor,
            String crystalMaterial,
            String complications,
            Short powerReserve,
            Integer maxPrice) {

        Specification<Watch> spec = Specification.where(WatchSpecification.brandContains(brand))
                .and(WatchSpecification.modelContains(model))
                .and(WatchSpecification.caseMaterialContains(caseMaterial))
                .and(WatchSpecification.strapMaterialContains(strapMaterial))
                .and(WatchSpecification.movementTypeContains(movementType))
                .and(WatchSpecification.waterResistanceGreaterThanEqual(waterResistance))
                .and(WatchSpecification.caseDiameterGreaterThanEqual(caseDiameter))
                .and(WatchSpecification
                        .caseDiameterLessThan(caseDiameter == null ? null : caseDiameter.add(BigDecimal.ONE)))
                .and(WatchSpecification.caseThicknessGreaterThanEqual(caseThickness))
                .and(WatchSpecification.caseThicknessLessThanEqual(caseThickness))
                .and(WatchSpecification.bandWidthGreaterThanEqual(bandWidth))
                .and(WatchSpecification.bandWidthLessThanEqual(bandWidth))
                .and(WatchSpecification.dialColorContains(dialColor))
                .and(WatchSpecification.crystalMaterialContains(crystalMaterial))
                .and(WatchSpecification.complicationsContains(complications))
                .and(WatchSpecification.powerReserveGreaterThanEqual(powerReserve))
                .and(WatchSpecification.priceLessThanEqual(maxPrice));

        return watchRepo.findAll(spec);
    }

    public Watch addWatch(Watch watch) {

        if (watch.getId() != null && watchRepo.existsById(watch.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Watch with id " + watch.getId() + " already exists");
        }

        return watchRepo.save(watch);
    }

    public Watch updateWatch(Watch watch) {

        if (watch.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID is required to update a watch");
        }

        Watch existing = watchRepo.findById(watch.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Watch not found with id " + watch.getId()));

        if (watch.getBrand() != null)
            existing.setBrand(watch.getBrand());
        if (watch.getModel() != null)
            existing.setModel(watch.getModel());
        if (watch.getCaseMaterial() != null)
            existing.setCaseMaterial(watch.getCaseMaterial());
        if (watch.getStrapMaterial() != null)
            existing.setStrapMaterial(watch.getStrapMaterial());
        if (watch.getMovementType() != null)
            existing.setMovementType(watch.getMovementType());
        if (watch.getWaterResistance() != null)
            existing.setWaterResistance(watch.getWaterResistance());
        if (watch.getCaseDiameter() != null)
            existing.setCaseDiameter(watch.getCaseDiameter());
        if (watch.getCaseThickness() != null)
            existing.setCaseThickness(watch.getCaseThickness());
        if (watch.getBandWidth() != null)
            existing.setBandWidth(watch.getBandWidth());
        if (watch.getDialColor() != null)
            existing.setDialColor(watch.getDialColor());
        if (watch.getCrystalMaterial() != null)
            existing.setCrystalMaterial(watch.getCrystalMaterial());
        if (watch.getComplications() != null)
            existing.setComplications(watch.getComplications());
        if (watch.getPowerReserve() != null)
            existing.setPowerReserve(watch.getPowerReserve());
        if (watch.getPrice() != null)
            existing.setPrice(watch.getPrice());

        return watchRepo.save(existing);
    }

}
