package com.watchlog.watchcatalog.domain.watch;

import com.watchlog.watchcatalog.domain.inventory.SellableRepository;
import com.watchlog.watchcatalog.repository.json.LoadJson;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class WatchJsonRepository implements SellableRepository<Watch> {

    private static final String FILENAME = "regular_list.json";
    private final LoadJson loadJson;

    public WatchJsonRepository(LoadJson loadJson) {
        this.loadJson = loadJson;
    }

    @Override
    public List<Watch> getList() {
        return Arrays.asList(loadJson.load(FILENAME, Watch[].class));
    }

    @Override
    public Optional<Watch> find(long id) {
        return getList().stream().filter(watch -> watch.getId() == id).findFirst();
    }

}
