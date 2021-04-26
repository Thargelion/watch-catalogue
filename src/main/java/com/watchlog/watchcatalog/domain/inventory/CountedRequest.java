package com.watchlog.watchcatalog.domain.inventory;

import lombok.Data;

import java.util.*;

@Data
public class CountedRequest {

    private final List<Amount> amountsList = new ArrayList<>();

    public CountedRequest(Integer[] ids) {
        var idList = new ArrayList<>(Arrays.asList(ids));
        Map<Integer, Amount> amountMap = new HashMap<>();
        idList.forEach(id -> {
            var amount = new Amount(id, Collections.frequency(idList, id));
            amountMap.put(id, amount);
        });
        amountMap.forEach((key, value) -> amountsList.add(value));
    }

}
