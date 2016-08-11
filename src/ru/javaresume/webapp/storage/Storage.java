package ru.javaresume.webapp.storage;

import ru.javaresume.webapp.model.Resume;

import java.util.Collection;

/**
 * Created by deadRabbit on 16.07.2016.
 */
public interface Storage {

    void clear();

    void save(Resume r);

    void update(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    Collection<Resume> getAllSorted();

    int size();
}
