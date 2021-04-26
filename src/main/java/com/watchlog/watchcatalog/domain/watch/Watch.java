package com.watchlog.watchcatalog.domain.watch;

import com.watchlog.watchcatalog.domain.inventory.SellableItem;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Watch implements SellableItem {
    int id;
    String name;
    long unitPrice;

    @Override
    public long calculatePrice(long amount) {
        return this.getUnitPrice() * amount;
    }
}
