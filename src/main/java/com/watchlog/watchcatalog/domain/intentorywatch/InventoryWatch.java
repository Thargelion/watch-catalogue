package com.watchlog.watchcatalog.domain.intentorywatch;

import com.watchlog.watchcatalog.domain.discount.Discount;
import com.watchlog.watchcatalog.domain.discount.FixedDiscount;
import com.watchlog.watchcatalog.domain.watch.Watch;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryWatch {
    Watch watch;
    FixedDiscount discount;
}
