package com.watchlog.watchcatalog.api.catalog;

import com.watchlog.watchcatalog.domain.totalprice.TotalPrice;

public interface CatalogHandler {
    TotalPrice getTotalPrice(String[] itemsIds);
}
