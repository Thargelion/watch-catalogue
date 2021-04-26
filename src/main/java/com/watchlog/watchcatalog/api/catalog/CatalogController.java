package com.watchlog.watchcatalog.api.catalog;

import com.watchlog.watchcatalog.domain.totalprice.TotalPrice;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {

    private final CatalogHandler catalogHandler;

    public CatalogController(CatalogHandler catalogHandler) {
        this.catalogHandler = catalogHandler;
    }

    @PostMapping("/checkout")
    @NonNull
    public TotalPrice buildCheckout(@RequestBody Integer[] data) {
        return this.catalogHandler.getTotalPrice(data);
    }

}
