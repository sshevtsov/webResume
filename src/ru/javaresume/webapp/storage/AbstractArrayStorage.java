package ru.javaresume.webapp.storage;

import ru.javaresume.webapp.ResumeStorageException;
import ru.javaresume.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Objects.requireNonNull;

/**
 * Created by deadRabbit on 11.08.2016.
 */
abstract public class AbstractArrayStorage extends AbstractStorage {

    protected static final int ARRAY_LIMIT = 50000;
    protected Resume[] array = new Resume[ARRAY_LIMIT];

    protected int size = 0;

    protected abstract int getIndex(String uuid);

    protected abstract void shiftDeleted(String uuid, int idx);

    protected abstract void insert(Resume r, int idx);

    private int getIndex(Resume r) {
        return getIndex(r.getUuid());
    }

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
        int idx = getIndex(r);
        String uuid = r.getUuid();
        if (idx >= 0) {
            throw new ResumeStorageException(uuid, "Resume " + uuid + " must be exist");
        }
        if (size == ARRAY_LIMIT) {
            throw new ResumeStorageException(uuid, "Array size limit(" + ARRAY_LIMIT + ") exceeded");
        }
        insert(r, idx);
        size++;
    }

    @Override
    public void update(Resume r) {
        requireNonNull(r, "Resumr must not be null");
        int idx = getIndex(r);
        mustExist(r.getUuid(), idx);
        array[getIndex(r.getUuid())] = r;
    }

    @Override
    public Resume get(String uuid) {
        requireNonNull(uuid, "UUID must not be null");
        int idx = getIndex(uuid);
        mustExist(uuid, idx);
        return array[getIndex(uuid)];
    }

    @Override
    public void delete(String uuid) {
        requireNonNull(uuid, "UUID must not be null");
        int idx = getIndex(uuid);
        mustExist(uuid, idx);
        shiftDeleted(uuid, idx);
        array[size--] = null;
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

    private void mustExist(String uuid, int idx){
        if (idx < 0) {
            throw new ResumeStorageException(uuid, "Resume " + uuid + " not found");
        }
    }

}
