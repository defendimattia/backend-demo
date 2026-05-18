package it.defendimattia.backenddemo.mapper;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import it.defendimattia.backenddemo.dto.WatchDetailsDTO;
import it.defendimattia.backenddemo.dto.WatchListDTO;
import it.defendimattia.backenddemo.dto.WatchUpdateDTO;
import it.defendimattia.backenddemo.model.Watch;

public class WatchMapperTest {

    @Test
    void shouldMapWatchToListDTOCorrectly() {

        // Arrange
        Watch watch = new Watch();
        watch.setId(1);
        watch.setBrand("Rolex");
        watch.setModel("Submariner");
        watch.setPrice(10000);

        // Act
        WatchListDTO dto = WatchMapper.toListDTO(watch);

        // Assert
        assertEquals(1, dto.id());
        assertEquals("Rolex", dto.brand());
        assertEquals("Submariner", dto.model());
        assertEquals(10000, dto.price());
    }

    @Test
    void shouldMapWatchToDetailsDTOCorrectly() {

        // Arrange
        Watch watch = new Watch();
        watch.setId(1);
        watch.setBrand("Rolex");
        watch.setModel("Submariner");
        watch.setCaseMaterial("Steel");
        watch.setStrapMaterial("Oystersteel");
        watch.setMovementType("Automatic");
        watch.setWaterResistance((short) 300);
        watch.setCaseDiameter(BigDecimal.valueOf(41.0));
        watch.setCaseThickness(BigDecimal.valueOf(12.5));
        watch.setBandWidth(BigDecimal.valueOf(20.0));
        watch.setDialColor("Black");
        watch.setCrystalMaterial("Sapphire");
        watch.setComplications("Date");
        watch.setPowerReserve((short) 70);
        watch.setPrice(10000);

        // Act
        WatchDetailsDTO dto = WatchMapper.toDTO(watch);

        // Assert
        assertAll(
                () -> assertEquals(1, dto.id()),
                () -> assertEquals("Rolex", dto.brand()),
                () -> assertEquals("Submariner", dto.model()),
                () -> assertEquals("Steel", dto.caseMaterial()),
                () -> assertEquals("Oystersteel", dto.strapMaterial()),
                () -> assertEquals("Automatic", dto.movementType()),
                () -> assertEquals((short) 300, dto.waterResistance()),
                () -> assertEquals(BigDecimal.valueOf(41.0), dto.caseDiameter()),
                () -> assertEquals(BigDecimal.valueOf(12.5), dto.caseThickness()),
                () -> assertEquals(BigDecimal.valueOf(20.0), dto.bandWidth()),
                () -> assertEquals("Black", dto.dialColor()),
                () -> assertEquals("Sapphire", dto.crystalMaterial()),
                () -> assertEquals("Date", dto.complications()),
                () -> assertEquals((short) 70, dto.powerReserve()),
                () -> assertEquals(10000, dto.price()));
    }

    @Test
    void shouldUpdateEntityWithNonNullFields() {

        // Arrange
        Watch watch = new Watch();
        watch.setBrand("Rolex");
        watch.setModel("Submariner");

        WatchUpdateDTO dto = new WatchUpdateDTO(
                1,
                "Omega",
                "Seamaster",
                (String) null,
                (String) null,
                (String) null,
                (Short) null,
                (BigDecimal) null,
                (BigDecimal) null,
                (BigDecimal) null,
                (String) null,
                (String) null,
                (String) null,
                (Short) null,
                (Integer) null);

        // Act
        WatchMapper.updateEntity(dto, watch);

        // Assert
        assertEquals("Omega", watch.getBrand());
        assertEquals("Seamaster", watch.getModel());
    }

    @Test
    void shouldNotOverwriteFieldsWithNull() {

        // Arrange
        Watch watch = new Watch();
        watch.setBrand("Rolex");
        watch.setModel("Submariner");

        WatchUpdateDTO dto = new WatchUpdateDTO(
                1,
                (String) null,
                "Seamaster",
                (String) null,
                (String) null,
                (String) null,
                (Short) null,
                (BigDecimal) null,
                (BigDecimal) null,
                (BigDecimal) null,
                (String) null,
                (String) null,
                (String) null,
                (Short) null,
                (Integer) null);
        // Act
        WatchMapper.updateEntity(dto, watch);

        // Assert
        assertEquals("Rolex", watch.getBrand());
        assertEquals("Seamaster", watch.getModel());
    }

    @Test
    void shouldNotModifyEntityWhenDtoIsEmpty() {

        // Arrange
        Watch watch = new Watch();
        watch.setBrand("Rolex");

        WatchUpdateDTO dto = new WatchUpdateDTO(
                1,
                (String) null,
                (String) null,
                (String) null,
                (String) null,
                (String) null,
                (Short) null,
                (BigDecimal) null,
                (BigDecimal) null,
                (BigDecimal) null,
                (String) null,
                (String) null,
                (String) null,
                (Short) null,
                (Integer) null);

        // Act
        WatchMapper.updateEntity(dto, watch);

        // Assert
        assertEquals("Rolex", watch.getBrand());
    }

    @Test
    void shouldPartiallyUpdateMultipleFields() {

        // Arrange
        Watch watch = new Watch();
        watch.setBrand("Rolex");
        watch.setModel("Submariner");
        watch.setPrice(10000);

        WatchUpdateDTO dto = new WatchUpdateDTO(
                1,
                "Omega",
                "Seamaster",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        // Act
        WatchMapper.updateEntity(dto, watch);

        // Assert
        assertEquals("Omega", watch.getBrand());
        assertEquals("Seamaster", watch.getModel());
        assertEquals(10000, watch.getPrice());
    }
}
