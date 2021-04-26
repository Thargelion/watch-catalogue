package integration;

import com.watchlog.watchcatalog.WatchCatalogApplication;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Tag("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = WatchCatalogApplication.class)
public class CheckoutIntegrationTest {

    @Test
    public void whenListPost_thenReturnTotalPrice() {
        RestAssured
                .with()
                .body("[001]")
                .when()
                .post("/checkout")
                .then()
                .statusCode(200);
    }
}
