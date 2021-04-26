package com.watchlog.watchcatalog.domain.totalprice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TotalPriceTest {

    @Test
    void newTotalPrice_buildsTotalPrice() {
        // Given
        var expectedPrice = 20;
        // When
        var actual = new TotalPrice(expectedPrice);
        // Then
        Assertions.assertEquals(expectedPrice, actual.getPrice());
        Assertions.assertEquals(TotalPrice.class, actual.getClass());
    }

}
