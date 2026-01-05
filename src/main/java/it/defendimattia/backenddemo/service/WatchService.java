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

    public List<Watch> searchByBrand(String query) {
        return watchRepo.findByBrandIgnoreCaseContaining(query);
    }

    public List<Watch> searchByModel(String query) {
        return watchRepo.findByModelIgnoreCaseContaining(query);
    }

    public List<Watch> searchByCaseMaterial(String query) {
        return watchRepo.findByCaseMaterialIgnoreCaseContaining(query);
    }

    public List<Watch> searchByStrapMaterial(String query) {
        return watchRepo.findByStrapMaterialIgnoreCaseContaining(query);
    }

    public List<Watch> searchByMovementType(String query) {
        return watchRepo.findByMovementTypeIgnoreCaseContaining(query);
    }

    public List<Watch> searchByWaterResistance(Short query) {
        return watchRepo.findByWaterResistanceGreaterThanEqual(query);
    }

    public List<Watch> searchByCaseDiameterEquals(Double query) {

        double min = query;
        double max = query + 1;

        return watchRepo.findByCaseDiameterGreaterThanEqualAndCaseDiameterLessThan(min, max);
    }

    public List<Watch> searchByCaseDiameterGreater(Double query) {
        return watchRepo.findByCaseDiameterGreaterThanEqual(query);
    }

    public List<Watch> searchByCaseDiameterLess(Double query) {
        return watchRepo.findByCaseDiameterLessThanEqual(query);
    }

    public List<Watch> searchByCaseThicknessEquals(Double query) {

        double min = query;
        double max = query + 1;

        return watchRepo.findByCaseThicknessGreaterThanEqualAndCaseThicknessLessThan(min, max);
    }

    public List<Watch> searchByCaseThicknessGreater(Double query) {
        return watchRepo.findByCaseThicknessGreaterThanEqual(query);
    }

    public List<Watch> searchByCaseThicknessLess(Double query) {
        return watchRepo.findByCaseThicknessLessThanEqual(query);
    }

    public List<Watch> searchByBandWidthEquals(Double query) {

        double min = query;
        double max = query + 1;

        return watchRepo.findByBandWidthGreaterThanEqualAndBandWidthLessThan(min, max);
    }

    public List<Watch> searchByBandWidthGreater(Double query) {
        return watchRepo.findByBandWidthGreaterThanEqual(query);
    }

    public List<Watch> searchByBandWidthLess(Double query) {
        return watchRepo.findByBandWidthLessThanEqual(query);
    }

    public List<Watch> searchByDialColor(String query) {
        return watchRepo.findByDialColorIgnoreCaseContaining(query);
    }

    public List<Watch> searchByCrystalMaterial(String query) {
        return watchRepo.findByCrystalMaterialIgnoreCaseContaining(query);
    }

    public List<Watch> searchByComplications(String query) {
        return watchRepo.findByComplicationsIgnoreCaseContaining(query);
    }

    public List<Watch> searchByPowerReserve(Short query) {
        return watchRepo.findByPowerReserveGreaterThanEqual(query);
    }

    public List<Watch> searchByPrice(Integer query) {
        return watchRepo.findByPriceLessThanEqual(query);
    }
}
