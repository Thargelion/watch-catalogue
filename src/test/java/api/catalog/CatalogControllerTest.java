package api.catalog;

import com.watchlog.watchcatalog.api.catalog.CatalogController;
import com.watchlog.watchcatalog.domain.totalprice.TotalPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CatalogControllerTest {

    @InjectMocks
    CatalogController subject;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void buildCheckoutReturnsTotalPrice() {
        // Given
        var expectedPrice = 20L;
        String[] input = new String[]{"10"};
        // When
        TotalPrice actual = subject.buildCheckout(input);
        // Then
        Assertions.assertEquals(expectedPrice, actual.getPrice());
    }

}
