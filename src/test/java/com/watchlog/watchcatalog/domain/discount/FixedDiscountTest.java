package com.watchlog.watchcatalog.domain.discount;

import com.watchlog.watchcatalog.domain.watch.Watch;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FixedDiscountTest {
    @ParameterizedTest
    @MethodSource("discountUseCasesProvider")
    void getDiscountedPrice_getsProperDiscountedPrice(DiscountUseCase useCase) {
        // When
        var actual = useCase.givenWatch.calculateDiscountedPrice(useCase.givenAmount);
        // Then
        Assertions.assertEquals(useCase.expected, actual);
    }

    static Stream<DiscountUseCase> discountUseCasesProvider() {
        var rolex = new FixedDiscount(new Watch(1, "Rolex", 100), 3, 200L);
        var kors = new FixedDiscount(new Watch(2, "Michael Kors", 80), 2, 120);
        var swatch = new FixedDiscount(new Watch(2, "Swatch", 50), 1, 50);
        return Stream.of(
                new DiscountUseCase(
                        rolex,
                        4,
                        300L
                ),
                new DiscountUseCase(
                        rolex,
                        7,
                        500L
                ),
                new DiscountUseCase(
                        rolex,
                        8,
                        600L
                ),
                new DiscountUseCase(
                        rolex,
                        9,
                        600L
                ),
                new DiscountUseCase(
                        rolex,
                        50,
                        3400L
                ),
                new DiscountUseCase(
                        kors,
                        2,
                        120L
                ),
                new DiscountUseCase(
                        swatch,
                        50,
                        2500L
                )
        );
    }

    @Data
    @AllArgsConstructor
    private static class DiscountUseCase {
        FixedDiscount givenWatch;
        int givenAmount;
        long expected;
    }

}
