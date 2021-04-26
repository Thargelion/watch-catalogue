package com.watchlog.watchcatalog.domain.inventory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountedRequestTest {

    @Test
    void newCountedRequest_ProvidesAmounts() {
        var ids = new Integer[]{1, 2, 1, 1, 2,};
        var count = new CountedRequest(ids);
        var amountList = count.getAmountsList();
        Assertions.assertEquals(3, amountList.stream().findFirst().get().amount);
    }

}
