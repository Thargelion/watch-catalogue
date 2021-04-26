package com.watchlog.watchcatalog.api.catalog;

import com.watchlog.watchcatalog.domain.totalprice.TotalPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CatalogControllerTest {

    @Mock
    CatalogHandler catalogHandler;

    @InjectMocks
    CatalogController subject;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void buildCheckoutReturnsTotalPrice() {
        // Given
        var input = new String[]{"10"};
        var expectedPrice = 20L;
        var expected = new TotalPrice(expectedPrice);
        Mockito.when(catalogHandler.getTotalPrice(input)).thenReturn(expected);
        // When
        TotalPrice actual = subject.buildCheckout(input);
        // Then
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expectedPrice, actual.getPrice());
    }

}
