package ru.javaresume.webapp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.javaresume.webapp.model.Section;

import java.io.Reader;
import java.io.Writer;
/**
 * Created by deadRabbit on 23.08.2016.
 */
public class JsonParser {
    private static Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Section.class, new JsonSectionAdapter())
            .create();

    public static <T> T read(Reader reader, Class<T> clazz) {
        return GSON.fromJson(reader, clazz);
    }

    public static <T> void write(T object, Writer writer) {
        GSON.toJson(object, writer);
    }
}
