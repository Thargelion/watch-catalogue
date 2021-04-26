package com.watchlog.watchcatalog.domain.discount;

import com.google.gson.Gson;
import com.watchlog.watchcatalog.repository.json.LoadJson;
import mocks.FixedDiscountMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

public class DiscountLocalJsonRepositoryTest {

    Gson gson = new Gson();
    private static final String FILENAME = "sale_list.json";

    @Mock
    LoadJson loadJson;

    @InjectMocks
    DiscountLocalJsonRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void discountList_getsDiscountListFromRepository() {
        // Given
        var givenClass = FixedDiscount[].class;
        var rawData = gson.fromJson(FixedDiscountMock.listAsString, FixedDiscount[].class);
        var expected = Arrays.asList(rawData);
        Mockito.when(loadJson.load(FILENAME, givenClass)).thenReturn(rawData);
        // When
        var actual = repository.getList();
        // Then
        Assertions.assertEquals(expected, actual);
    }

}
