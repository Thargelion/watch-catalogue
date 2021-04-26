package com.watchlog.watchcatalog.domain.totalprice;

public interface TotalPriceCalculator {
    TotalPrice calculateFromIds(Integer[] ids);
}
