package com.watchlog.watchcatalog.domain.discount;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FixedDiscount  {
    private int requiredAmount;
    private long discountedPrice;
}
