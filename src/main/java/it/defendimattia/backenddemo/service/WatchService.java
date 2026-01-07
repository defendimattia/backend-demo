package it.defendimattia.backenddemo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

        Optional<Watch> watchTry = watchRepo.findById(id);

        if (watchTry.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "watch not found with id " + id);
        }

        return watchTry.get();
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

}
