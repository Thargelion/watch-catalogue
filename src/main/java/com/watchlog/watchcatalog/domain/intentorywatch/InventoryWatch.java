package com.watchlog.watchcatalog.domain.intentorywatch;

import com.watchlog.watchcatalog.domain.discount.FixedDiscount;
import com.watchlog.watchcatalog.domain.watch.Watch;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryWatch {
    Watch watch;
    FixedDiscount discount;

    public long getTotalDiscountedPrice(int currentAmount) {
        var dis = currentAmount / discount.getRequiredAmount();
        var mod = currentAmount % discount.getRequiredAmount();
        var moduloPrice = mod * watch.getUnitPrice();
        return dis * this.discount.getDiscountedPrice() + moduloPrice;
    }
}
