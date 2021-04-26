package com.watchlog.watchcatalog.domain.discount;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FixedDiscount implements Discount {
    private int requiredAmount;
    private long discountedPrice;

    @Override
    public long getTotalDiscountedPrice(int currentAmount) {
        return currentAmount % requiredAmount * discountedPrice;
    }

}
