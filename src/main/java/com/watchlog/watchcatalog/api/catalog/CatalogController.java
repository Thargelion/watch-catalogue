package com.watchlog.watchcatalog.api.catalog;

import com.watchlog.watchcatalog.domain.totalprice.TotalPrice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {

    private final CatalogHandler catalogHandler;

    public CatalogController(CatalogHandler catalogHandler) {
        this.catalogHandler = catalogHandler;
    }

    @PostMapping("/checkout")
    public TotalPrice buildCheckout(String[] data) {
        return this.catalogHandler.getTotalPrice(data);
    }

}
