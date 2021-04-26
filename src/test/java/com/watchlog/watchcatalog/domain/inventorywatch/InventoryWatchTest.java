package com.watchlog.watchcatalog.domain.inventorywatch;

import com.watchlog.watchcatalog.domain.discount.FixedDiscount;
import com.watchlog.watchcatalog.domain.intentorywatch.InventoryWatch;
import com.watchlog.watchcatalog.domain.watch.Watch;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class InventoryWatchTest {

    @ParameterizedTest
    @MethodSource("discountUseCasesProvider")
    void getDiscountedPrice_getsProperDiscountedPrice(DiscountUseCase useCase) {
        // When
        var actual = useCase.givenWatch.getTotalDiscountedPrice(useCase.givenAmount);
        // Then
        Assertions.assertEquals(useCase.expected, actual);
    }

    static Stream<DiscountUseCase> discountUseCasesProvider() {
        var rolex = new InventoryWatch(new Watch(1, "Rolex", 100), new FixedDiscount(3, 200L));
        return Stream.of(
                new DiscountUseCase(
                        rolex,
                        4,
                        300L
                ),
                new DiscountUseCase(
                        rolex,
                        5,
                        400L
                )
        );
    }

    @Data
    @AllArgsConstructor
    private static class DiscountUseCase {
        InventoryWatch givenWatch;
        int givenAmount;
        long expected;
    }

}
