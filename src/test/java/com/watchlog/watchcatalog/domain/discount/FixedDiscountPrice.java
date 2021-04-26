package com.watchlog.watchcatalog.domain.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FixedDiscountPrice {

    @Test
    void getDiscountedPrice_getsExpected() {
        // Given
        FixedDiscount discount = new FixedDiscount(2, 100L);
        var expected = 10;
        // When
        var actual = discount.getTotalDiscountedPrice(3);
        // Then
        Assertions.assertEquals(expected, actual);
    }

}
