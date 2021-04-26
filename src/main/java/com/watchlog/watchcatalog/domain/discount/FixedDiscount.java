package com.watchlog.watchcatalog.domain.discount;

import com.watchlog.watchcatalog.domain.watch.Watch;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FixedDiscount implements QuantityDiscount {
    private final Watch item;
    private final int requiredAmount;
    private final long discountedPrice;

    public long calculateDiscountedPrice(int currentAmount) {
        var dis = currentAmount / this.getRequiredAmount();
        var mod = currentAmount % this.getRequiredAmount();
        var moduloPrice = mod * item.getUnitPrice();
        return dis * this.getDiscountedPrice() + moduloPrice;
    }
}
