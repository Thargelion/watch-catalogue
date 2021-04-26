package com.watchlog.watchcatalog.domain.discount;

import com.watchlog.watchcatalog.repository.json.LoadJson;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DiscountLocalJsonRepository implements DiscountRepository<FixedDiscount> {

    private static final String FILENAME = "sale_list.json";
    private final LoadJson loadJson;

    public DiscountLocalJsonRepository(LoadJson loadJson) {
        this.loadJson = loadJson;
    }

    @Override
    public List<FixedDiscount> getList() {
        return Arrays.asList(loadJson.load(FILENAME, FixedDiscount[].class));
    }

    @Override
    public Optional<FixedDiscount> find(long id) {
        return getList().stream().filter(fixedDiscount -> fixedDiscount.getItem().getId() == id).findFirst();
    }
}
