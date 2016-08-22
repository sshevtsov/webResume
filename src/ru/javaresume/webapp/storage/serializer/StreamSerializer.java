package ru.javaresume.webapp.storage.serializer;

import ru.javaresume.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * Created by deadRabbit on 22.08.2016.
 */
public interface StreamSerializer {
    void write(Resume r, OutputStream os) throws IOException;

    Resume read(InputStream is) throws IOException;
}
