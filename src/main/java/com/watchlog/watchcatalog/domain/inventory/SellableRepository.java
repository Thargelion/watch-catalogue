package com.watchlog.watchcatalog.domain.inventory;

import com.watchlog.watchcatalog.domain.watch.Watch;

import java.util.List;
import java.util.Optional;

public interface SellableRepository<T extends SellableItem> {
    List<T> getList();

    Optional<T> find(long id);
}
