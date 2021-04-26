package com.watchlog.watchcatalog.domain.totalprice;

import com.watchlog.watchcatalog.domain.discount.DiscountRepository;
import com.watchlog.watchcatalog.domain.discount.FixedDiscount;
import com.watchlog.watchcatalog.domain.inventory.Amount;
import com.watchlog.watchcatalog.domain.inventory.CountedRequest;
import com.watchlog.watchcatalog.domain.inventory.SellableRepository;
import com.watchlog.watchcatalog.domain.watch.Watch;
import org.springframework.stereotype.Service;

@Service
public class TotalPriceService implements TotalPriceCalculator {

    private final DiscountRepository<FixedDiscount> discountRepository;
    private final SellableRepository<Watch> watchSellableRepository;

    public TotalPriceService(DiscountRepository<FixedDiscount> discountRepository, SellableRepository<Watch> watchSellableRepository) {
        this.discountRepository = discountRepository;
        this.watchSellableRepository = watchSellableRepository;
    }

    @Override
    public TotalPrice calculateFromIds(Integer[] ids) {
        var amountsList = new CountedRequest(ids).getAmountsList();
        long price = amountsList.stream().mapToLong(this::calculateItemPrice).sum();
        return new TotalPrice(price);
    }

    private long calculateItemPrice(Amount amount) {
        var discounted = discountRepository.find(amount.getId());
        if (discounted.isPresent()) {
            return discounted.get().calculateDiscountedPrice(amount.getAmount());
        }

        var regular = watchSellableRepository.find(amount.getId());
        return regular.map(watch -> watch.calculatePrice(amount.getAmount())).orElse(0L);
    }
}
