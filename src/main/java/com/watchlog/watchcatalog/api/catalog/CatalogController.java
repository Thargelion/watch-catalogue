package com.watchlog.watchcatalog.api.catalog;

import com.watchlog.watchcatalog.domain.totalprice.TotalPrice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {

    @PostMapping("/checkout")
    public TotalPrice buildCheckout(String[] data) {
        return new TotalPrice(20L);
    }

}
