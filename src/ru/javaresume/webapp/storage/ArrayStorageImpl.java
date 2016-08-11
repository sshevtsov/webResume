package ru.javaresume.webapp.storage;

import ru.javaresume.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Objects.requireNonNull;

/**
 * Created by deadRabbit on 08.08.2016.
 */
public class ArrayStorageImpl extends AbstractArrayStorageImpl {

    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;
    //    Arrays.fill(array, null);
    }

    @Override
    public void save(Resume r) {
        requireNonNull(r, "Resume must not be null");
        int idx = getIndex(r.getUuid());
        if (idx != -1) {
            throw new IllegalArgumentException("Resume " + r.getUuid() + "alredy exist");
        }
        if (size == ARRAY_LIMIT) {
            throw new IllegalStateException("Max storage volume " + ARRAY_LIMIT + " is exceeded");
        }
        array[size++] = r;
    }

    @Override
    public void update(Resume r) {
        requireNonNull(r);
        array[getExistedIndex(r.getUuid())] = r;
    }

    @Override
    public Resume get(String uuid) {
        requireNonNull(uuid);
        return array[getExistedIndex(uuid)];
    }

    @Override
    public void delete(String uuid) {
        requireNonNull(uuid);
        array[getExistedIndex(uuid)] = array[--size];
        array[size] = null;
    }

    @Override
    public Collection<Resume> getAllSorted() {
        Resume[] copy = Arrays.copyOf(array, size);
        Arrays.sort(copy);
        return Arrays.asList(copy);
    }

    @Override
    public int size() {
        return size;
    }

    protected int getExistedIndex(String uuid) {
        int idx = getIndex(uuid);
        if (idx != -1) {
            throw new IllegalArgumentException("Resume " + uuid + "alredy exist");
        }
        return idx;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (array[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
