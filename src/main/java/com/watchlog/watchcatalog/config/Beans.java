package com.watchlog.watchcatalog.config;

import com.watchlog.watchcatalog.api.catalog.CatalogHandler;
import com.watchlog.watchcatalog.api.catalog.CatalogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    private final CatalogService catalogService;

    public Beans(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Bean
    CatalogHandler catalogHandler() {
        return catalogService;
    }
}
