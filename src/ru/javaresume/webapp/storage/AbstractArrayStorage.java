package ru.javaresume.webapp.storage;

import ru.javaresume.webapp.ResumeStorageException;
import ru.javaresume.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Created by deadRabbit on 11.08.2016.
 */
abstract public class AbstractArrayStorage extends AbstractStorage<Integer> {

    protected static final int ARRAY_LIMIT = 50000;

    protected Resume[] array = new Resume[ARRAY_LIMIT];
    protected int size = 0;

    protected abstract void shiftDeleted(int idx);

    protected abstract void insert(Resume r, int idx);

    @Override
    protected boolean exist(Integer idx) {
        return idx >= 0;
    }

    @Override
    public void doClear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
    }

    @Override
    protected void doSave(Resume r, Integer idx) {
        if (size == ARRAY_LIMIT) {
            throw new ResumeStorageException(r.getUuid(), "Array size limit(" + ARRAY_LIMIT + ") exceeded");
        }
        insert(r, idx);
        size++;
    }

    @Override
    protected void doUpdate(Resume r, Integer idx) {
        array[idx] = r;
    }

    @Override
    protected Resume doGet(Integer idx) {
        return array[idx];
    }

    @Override
    public void doDelete(Integer idx) {
        shiftDeleted(idx);
        array[size--] = null;
    }

    @Override
    public List<Resume> getAll() {
        Resume[] copy = Arrays.copyOf(array, size);
        return Arrays.asList(copy);
    }

    @Override
    public int getSize() {
        return size;
    }

}
