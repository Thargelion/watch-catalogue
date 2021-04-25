package com.watchlog.watchcatalog.api.catalog;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {

    @PostMapping("/checkout")
    public String buildCheckout(String data) {
        return "Data";
    }

}
