package ru.javaresume.webapp.storage.serializer;
import ru.javaresume.webapp.model.Resume;
import ru.javaresume.webapp.util.JsonParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
/**
 * Created by deadRabbit on 23.08.2016.
 */
public class JsonStreamSerializer  implements StreamSerializer {

    @Override
    public void write(Resume r, OutputStream os) throws IOException {
        try (Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            JsonParser.write(r, writer);
        }
    }

    @Override
    public Resume read(InputStream is) throws IOException {
        try (Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return JsonParser.read(reader, Resume.class);
        }
    }
}