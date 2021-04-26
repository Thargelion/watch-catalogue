package com.watchlog.watchcatalog.api.catalog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CatalogServiceTest {

    @InjectMocks
    CatalogService subject;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTotalPrice_getsTotalPrice() {
        // Given
        var expectedPrice = 20L;
        var input = new Integer[]{10};
        // When
        var actualTotalPrice = subject.getTotalPrice(input);
        // Then
        Assertions.assertEquals(expectedPrice, actualTotalPrice.getPrice());
    }
}
