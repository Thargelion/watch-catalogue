package com.watchlog.watchcatalog.api.catalog;

import com.watchlog.watchcatalog.domain.totalprice.TotalPrice;
import com.watchlog.watchcatalog.domain.totalprice.TotalPriceCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CatalogServiceTest {

    @Mock
    TotalPriceCalculator calculator;

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
        Mockito.when(calculator.calculateFromIds(input)).thenReturn(new TotalPrice(20L));
        // When
        var actualTotalPrice = subject.getTotalPrice(input);
        // Then
        Assertions.assertEquals(expectedPrice, actualTotalPrice.getPrice());
    }
}
