package com.watchlog.watchcatalog.repository.json;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.watchlog.watchcatalog.domain.discount.FixedDiscount;
import mocks.FixedDiscountMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoadJsonTest {

    @Test
    void load_loadsFromFile() {
        // Given
        var gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        var subject = new LoadJson(gson);
        var expected = FixedDiscountMock.listAsAnArray;
        // When
        var actual = subject.load("sale_list.json", FixedDiscount[].class);
        // Then
        Assertions.assertArrayEquals(expected, actual);
    }

}
