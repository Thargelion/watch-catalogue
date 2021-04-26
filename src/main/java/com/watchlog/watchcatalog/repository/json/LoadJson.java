package com.watchlog.watchcatalog.repository.json;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class LoadJson {

    private static final String JSON_FOLDER = "/json/";

    private final Gson gson;

    LoadJson(Gson gson) {
        this.gson = gson;
    }

    public <T> T load(String fileName, Class<T> clazz) {
        try (InputStream is = clazz.getResourceAsStream(JSON_FOLDER + fileName)) {
            assert is != null;
            return gson.fromJson(new InputStreamReader(is), clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
