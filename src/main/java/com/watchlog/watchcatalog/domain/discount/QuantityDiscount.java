package com.watchlog.watchcatalog.domain.discount;

public interface QuantityDiscount {
    long calculateDiscountedPrice(int currentAmount);
}
