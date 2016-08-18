package ru.javaresume.webapp.storage;

import ru.javaresume.webapp.model.Resume;

/**
 * Created by deadRabbit on 08.08.2016.
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void shiftDeleted(int idx) {
        array[idx] = array[size - 1];
    }

    @Override
    protected void insert(Resume r, int idx) {
        array[size] = r;
    }

    @Override
    protected Integer getContext(String uuid) {
        for (int i = 0; i < size; i++) {
            if (array[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
