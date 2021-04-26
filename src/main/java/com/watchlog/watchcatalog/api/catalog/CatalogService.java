package com.watchlog.watchcatalog.api.catalog;

import com.watchlog.watchcatalog.domain.totalprice.TotalPrice;
import com.watchlog.watchcatalog.domain.totalprice.TotalPriceCalculator;
import org.springframework.stereotype.Service;

@Service
public class CatalogService implements CatalogHandler {

    private final TotalPriceCalculator calculator;

    public CatalogService(TotalPriceCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public TotalPrice getTotalPrice(Integer[] itemsIds) {
        return calculator.calculateFromIds(itemsIds);
    }
}
