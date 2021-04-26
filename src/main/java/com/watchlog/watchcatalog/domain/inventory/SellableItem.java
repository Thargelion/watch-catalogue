package com.watchlog.watchcatalog.domain.inventory;

public interface SellableItem {
    String getName();
    long getUnitPrice();
    long calculatePrice(long amount);
}
