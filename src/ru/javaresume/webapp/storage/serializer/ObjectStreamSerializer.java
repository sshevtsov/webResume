package ru.javaresume.webapp.storage.serializer;

import ru.javaresume.webapp.ResumeStorageException;
import ru.javaresume.webapp.model.Resume;

import java.io.*;
/**
 * Created by deadRabbit on 23.08.2016.
 */
public class ObjectStreamSerializer implements StreamSerializer {

    @Override
    public void write(Resume r, OutputStream os) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(r);
        }
    }

    @Override
    public Resume read(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new ResumeStorageException(null, "Error read resume", e);
        }
    }
}