package com.watchlog.watchcatalog.domain.discount;

import java.util.List;
import java.util.Optional;

public interface DiscountRepository<T extends QuantityDiscount> {
    List<T> getList();

    Optional<T> find(long id);
}
