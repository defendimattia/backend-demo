package it.defendimattia.backenddemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import it.defendimattia.backenddemo.dto.WatchDetailsDTO;
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
    void shouldThrowExceptionWhenWatchNotFound() {

        // Arrange
        Mockito.when(watchRepo.findById(1))
                .thenReturn(Optional.empty());

        // Act + Assert
        ResponseStatusException ex = assertThrows(
                ResponseStatusException.class,
                () -> watchService.getWatchById(1));

        assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
    }
}