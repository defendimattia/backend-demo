package it.defendimattia.backenddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.defendimattia.backenddemo.model.Watch;
import it.defendimattia.backenddemo.service.WatchService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/watches")
public class WatchRestController {

    @Autowired
    private WatchService watchService;

    @GetMapping
    public List<Watch> index() {
        return watchService.getAllWatches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Watch> show(@PathVariable Integer id) {

        Watch watch = watchService.getWatchById(id);

        return ResponseEntity.ok(watch);
    }

    @GetMapping("/searchByBrand")
    public List<Watch> searchBrand(@RequestParam(name = "query") String query) {

        return watchService.searchByBrand(query);
    }

    @GetMapping("/searchByModel")
    public List<Watch> searchModel(@RequestParam(name = "query") String query) {

        return watchService.searchByModel(query);
    }

    @GetMapping("/searchByCaseMaterial")
    public List<Watch> searchCaseMaterial(@RequestParam(name = "query") String query) {

        return watchService.searchByCaseMaterial(query);
    }

    @GetMapping("/searchByStrapMaterial")
    public List<Watch> searchStrapMaterial(@RequestParam(name = "query") String query) {

        return watchService.searchByStrapMaterial(query);
    }

    @GetMapping("/searchByMovementType")
    public List<Watch> searchMovementType(@RequestParam(name = "query") String query) {

        return watchService.searchByMovementType(query);
    }

    @GetMapping("/searchByWaterResistance")
    public List<Watch> searchWaterResistance(@RequestParam(name = "query") Short query) {

        return watchService.searchByWaterResistance(query);
    }

    @GetMapping("/searchByCaseDiameterEquals")
    public List<Watch> searchCaseDiameterEquals(@RequestParam(name = "query") Double query) {

        return watchService.searchByCaseDiameterEquals(query);
    }

    @GetMapping("/searchByCaseDiameterGreater")
    public List<Watch> searchCaseDiameterGreater(@RequestParam(name = "query") Double query) {

        return watchService.searchByCaseDiameterGreater(query);
    }

    @GetMapping("/searchByCaseDiameterLess")
    public List<Watch> searchCaseDiameterLess(@RequestParam(name = "query") Double query) {

        return watchService.searchByCaseDiameterLess(query);
    }

    @GetMapping("/searchByCaseThicknessEquals")
    public List<Watch> searchCaseThicknessEquals(@RequestParam(name = "query") Double query) {

        return watchService.searchByCaseThicknessEquals(query);
    }

    @GetMapping("/searchByCaseThicknessGreater")
    public List<Watch> searchCaseThicknessGreater(@RequestParam(name = "query") Double query) {

        return watchService.searchByCaseThicknessGreater(query);
    }

    @GetMapping("/searchByCaseThicknessLess")
    public List<Watch> searchCaseThicknessLess(@RequestParam(name = "query") Double query) {

        return watchService.searchByCaseThicknessLess(query);
    }

    @GetMapping("/searchByBandWidthEquals")
    public List<Watch> searchBandWidthEquals(@RequestParam(name = "query") Double query) {

        return watchService.searchByBandWidthEquals(query);
    }

    @GetMapping("/searchByBandWidthGreater")
    public List<Watch> searchBandWidthGreater(@RequestParam(name = "query") Double query) {

        return watchService.searchByBandWidthGreater(query);
    }

    @GetMapping("/searchByBandWidthLess")
    public List<Watch> searchBandWidthLess(@RequestParam(name = "query") Double query) {

        return watchService.searchByBandWidthLess(query);
    }

    @GetMapping("/searchByDialColor")
    public List<Watch> searchDialColor(@RequestParam(name = "query") String query) {
        return watchService.searchByDialColor(query);
    }

    @GetMapping("/searchByCrystalMaterial")
    public List<Watch> searchCrystalMaterial(@RequestParam(name = "query") String query) {
        return watchService.searchByCrystalMaterial(query);
    }

    @GetMapping("/searchByComplications")
    public List<Watch> searchComplications(@RequestParam(name = "query") String query) {
        return watchService.searchByComplications(query);
    }

    @GetMapping("/searchByPowerReserve")
    public List<Watch> searchPowerReserve(@RequestParam(name = "query") Short query) {
        return watchService.searchByPowerReserve(query);
    }

}
