package mocks;

import com.watchlog.watchcatalog.domain.discount.FixedDiscount;
import com.watchlog.watchcatalog.domain.watch.Watch;

public class FixedDiscountMock {
    public static String listAsString = "[\n" +
            "  {\n" +
            "    \"item\": {\n" +
            "      \"id\": 1,\n" +
            "      \"watch_name\": \"Rolex\",\n" +
            "      \"unit_price\": 100\n" +
            "    },\n" +
            "    \"required_amount\": 3,\n" +
            "    \"discounted_price\": 200\n" +
            "  },\n" +
            "  {\n" +
            "    \"item\": {\n" +
            "      \"id\": 2,\n" +
            "      \"watch_name\": \"Michael Kors\",\n" +
            "      \"unit_price\": 100\n" +
            "    },\n" +
            "    \"required_amount\": 2,\n" +
            "    \"discounted_price\": 120\n" +
            "  }\n" +
            "]";

    public static FixedDiscount[] listAsAnArray = new FixedDiscount[]{
            new FixedDiscount(new Watch(1, "Rolex", 100), 3, 200),
            new FixedDiscount(new Watch(2, "Michael Kors", 80), 2, 120)
    };

}
