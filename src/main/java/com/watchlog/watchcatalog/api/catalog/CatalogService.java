package com.watchlog.watchcatalog.api.catalog;

import com.watchlog.watchcatalog.domain.totalprice.TotalPrice;
import org.springframework.stereotype.Service;

@Service
public class CatalogService implements CatalogHandler {
    @Override
    public TotalPrice getTotalPrice(String[] itemsIds) {
        return new TotalPrice(20L);
    }
}
