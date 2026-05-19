package it.defendimattia.backenddemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import it.defendimattia.backenddemo.dto.PaginatedResponse;
import it.defendimattia.backenddemo.dto.WatchCreateDTO;
import it.defendimattia.backenddemo.dto.WatchDetailsDTO;
import it.defendimattia.backenddemo.dto.WatchListDTO;
import it.defendimattia.backenddemo.dto.WatchSearchDTO;
import it.defendimattia.backenddemo.dto.WatchUpdateDTO;
import it.defendimattia.backenddemo.model.Watch;
import it.defendimattia.backenddemo.repository.WatchRepository;

@ExtendWith(MockitoExtension.class)
class WatchServiceTest {

    @Mock
    private WatchRepository watchRepo;

    @InjectMocks
    private WatchService watchService;

    @Test
    void shouldReturnWatchById() {

        // Arrange
        Watch watch = new Watch();
        watch.setId(1);
        watch.setBrand("Rolex");

        Mockito.when(watchRepo.findById(1))
                .thenReturn(Optional.of(watch));

        // Act
        WatchDetailsDTO result = watchService.getWatchById(1);

        // Assert
        assertEquals(1, result.id());
        assertEquals("Rolex", result.brand());

    }

    @Test
    void shouldReturnPaginatedSearchResults() {

        // Arrange
        Watch watch = new Watch();
        watch.setId(1);
        watch.setBrand("Rolex");
        watch.setModel("Submariner");
        watch.setPrice(10000);

        List<Watch> watches = List.of(watch);

        Page<Watch> page = new PageImpl<>(watches);

        Pageable pageable = PageRequest.of(0, 10);

        WatchSearchDTO filters = new WatchSearchDTO(
                "Rolex",
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
                null,
                null);

        Mockito.when(watchRepo.findAll(
                Mockito.<Specification<Watch>>any(),
                Mockito.any(Pageable.class)))
                .thenReturn(page);

        // Act
        PaginatedResponse<WatchListDTO> result = watchService.search(filters, pageable);

        // Assert
        assertEquals(1, result.content().size());

        WatchListDTO dto = result.content().getFirst();

        assertEquals(1, dto.id());
        assertEquals("Rolex", dto.brand());
        assertEquals("Submariner", dto.model());
        assertEquals(10000, dto.price());
    }

    @Test
    void shouldAddWatchSuccessfully() {

        // Arrange
        WatchCreateDTO dto = new WatchCreateDTO(
                "Rolex",
                "Submariner",
                "Steel",
                "Oystersteel",
                "Automatic",
                (short) 300,
                BigDecimal.valueOf(41.0),
                BigDecimal.valueOf(12.5),
                BigDecimal.valueOf(20),
                "Black",
                "Sapphire",
                "Date",
                (short) 70,
                10000);

        Watch savedWatch = new Watch();
        savedWatch.setId(1);
        savedWatch.setBrand("Rolex");
        savedWatch.setModel("Submariner");
        savedWatch.setPrice(10000);

        Mockito.when(watchRepo.save(Mockito.any(Watch.class)))
                .thenReturn(savedWatch);

        // Act
        WatchDetailsDTO result = watchService.addWatch(dto);

        // Assert
        assertEquals(1, result.id());
        assertEquals("Rolex", result.brand());
        assertEquals("Submariner", result.model());

        Mockito.verify(watchRepo, Mockito.times(1)).save(Mockito.any(Watch.class));
    }

    @Test
    void shouldUpdateWatchSuccessfully() {

        // Arrange
        Watch existingWatch = new Watch();
        existingWatch.setId(1);
        existingWatch.setBrand("Rolex");
        existingWatch.setModel("Submariner");
        existingWatch.setPrice(10000);

        Watch updatedWatch = new Watch();
        updatedWatch.setId(1);
        updatedWatch.setBrand("Omega");
        updatedWatch.setModel("Seamaster");
        updatedWatch.setPrice(12000);

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
                12000);

        Mockito.when(watchRepo.findById(1))
                .thenReturn(Optional.of(existingWatch));

        Mockito.when(watchRepo.save(Mockito.any(Watch.class)))
                .thenReturn(updatedWatch);

        // Act
        WatchDetailsDTO result = watchService.updateWatch(dto);

        // Assert
        assertEquals("Omega", result.brand());
        assertEquals("Seamaster", result.model());
        assertEquals(12000, result.price());

        Mockito.verify(watchRepo).findById(1);
        Mockito.verify(watchRepo, Mockito.times(1)).save(Mockito.any(Watch.class));
    }

    @Test
    void shouldDeleteWatchSuccessfully() {

        // Arrange
        Watch watch = new Watch();
        watch.setId(1);
        watch.setBrand("Rolex");

        Mockito.when(watchRepo.findById(1))
                .thenReturn(Optional.of(watch));

        // Act
        watchService.deleteWatch(1);

        // Assert
        Mockito.verify(watchRepo).findById(1);
        Mockito.verify(watchRepo).delete(watch);
    }

    @Test
    void shouldThrowExceptionWhenWatchNotFound() {

        // Arrange
        Mockito.when(watchRepo.findById(1))
                .thenReturn(Optional.empty());

        // Act + Assert
        ResponseStatusException ex = assertThrows(
                ResponseStatusException.class,
                () -> watchService.getWatchById(1));

        Mockito.verify(watchRepo).findById(1);
        Mockito.verify(watchRepo, Mockito.never()).save(Mockito.any());
        assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
    }

    @Test
    void shouldThrowBadRequestWhenUpdateIdIsNull() {

        // Arrange
        WatchUpdateDTO dto = new WatchUpdateDTO(
                null,
                "Omega",
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
                null,
                null);

        // Act + Assert
        ResponseStatusException ex = assertThrows(
                ResponseStatusException.class,
                () -> watchService.updateWatch(dto));

        assertEquals(HttpStatus.BAD_REQUEST, ex.getStatusCode());

        assertEquals(
                "ID is required to update a watch",
                ex.getReason());
    }

    @Test
    void shouldThrowNotFoundWhenUpdatingNonExistingWatch() {

        // Arrange
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

        Mockito.when(watchRepo.findById(1))
                .thenReturn(Optional.empty());

        // Act + Assert
        ResponseStatusException ex = assertThrows(
                ResponseStatusException.class,
                () -> watchService.updateWatch(dto));

        assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());

        assertEquals(
                "Watch not found with id: 1",
                ex.getReason());

        Mockito.verify(watchRepo).findById(1);
        Mockito.verify(watchRepo, Mockito.never()).save(Mockito.any());
    }

    @Test
    void shouldThrowNotFoundWhenDeletingNonExistingWatch() {

        Mockito.when(watchRepo.findById(1))
                .thenReturn(Optional.empty());

        ResponseStatusException ex = assertThrows(
                ResponseStatusException.class,
                () -> watchService.deleteWatch(1));

        assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());

        Mockito.verify(watchRepo).findById(1);
        Mockito.verify(watchRepo, Mockito.never())
                .delete(Mockito.any(Watch.class));
    }
}