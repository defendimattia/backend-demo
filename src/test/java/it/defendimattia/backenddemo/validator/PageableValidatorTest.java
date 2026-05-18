package it.defendimattia.backenddemo.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.PageRequest;

public class PageableValidatorTest {

    @Test
    void shouldLimitPageSizeToMaximumAllowed() {

        // Arrange
        Pageable pageable = PageRequest.of(0, 999);

        // Act
        Pageable sanitized = PageableValidator.sanitize(
                pageable,
                List.of("id", "brand"));

        // Assert
        assertEquals(50, sanitized.getPageSize());
    }

    @Test
    void shouldPreserveValidPageSize() {

        // Arrange
        Pageable pageable = PageRequest.of(0, 20);

        // Act
        Pageable sanitized = PageableValidator.sanitize(
                pageable,
                List.of("id", "brand"));

        // Assert
        assertEquals(20, sanitized.getPageSize());
    }

    @Test
    void shouldRejectInvalidSortField() {

        // Arrange
        Pageable pageable = PageRequest.of(
                0,
                10,
                Sort.by(Sort.Order.desc("price")));

        // Act & Assert
        assertThrows(ResponseStatusException.class, () -> {
            PageableValidator.sanitize(
                    pageable,
                    List.of("id", "brand", "model"));
        });
    }

    @Test
    void shouldAcceptValidSortField() {

        // Arrange
        Pageable pageable = PageRequest.of(
                0,
                10,
                Sort.by(Sort.Order.asc("brand")));

        // Act
        Pageable sanitized = PageableValidator.sanitize(
                pageable,
                List.of("id", "brand", "model"));

        // Assert
        assertTrue(sanitized.getSort().isSorted());

        assertEquals("brand",
                sanitized.getSort().iterator().next().getProperty());
    }

    @Test
    void shouldSanitizePageableKeepingValidSortAndSize() {

        // Arrange
        Pageable pageable = PageRequest.of(
                0,
                999,
                Sort.by(Sort.Order.asc("brand")));

        // Act
        Pageable sanitized = PageableValidator.sanitize(
                pageable,
                List.of("id", "brand", "model", "price"));

        // Assert
        assertEquals(50, sanitized.getPageSize());

        assertTrue(sanitized.getSort().isSorted());
        assertEquals("brand",
                sanitized.getSort().iterator().next().getProperty());

        assertEquals(0, sanitized.getPageNumber());
    }

    @Test
    void shouldThrowExceptionForInvalidSortField() {

        // Arrange
        Pageable pageable = PageRequest.of(
                0,
                10,
                Sort.by(Sort.Order.asc("price")));

        // Act & Assert
        assertThrows(ResponseStatusException.class, () -> {
            PageableValidator.sanitize(
                    pageable,
                    List.of("id", "brand", "model"));
        });
    }
}
