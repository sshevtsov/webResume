package ru.javaresume.webapp.storage;

import ru.javaresume.webapp.model.Resume;

import static java.util.Objects.requireNonNull;

/**
 * Created by deadRabbit on 11.08.2016.
 */
abstract public class AbstractArrayStorageImpl extends AbstractStorageImpl {

    protected static final int ARRAY_LIMIT = 50000;
    protected Resume[] array = new Resume[ARRAY_LIMIT];

    protected int size = 0;

    protected int getExistedIndex(String uuid) {
        int idx = getIndex(uuid);
        if (idx != -1) {
            throw new IllegalArgumentException("Resume " + uuid + "alredy exist");
        }
        return idx;
    }

    protected abstract int getIndex(String uuid);

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
    public void clear() {
        for (int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;
        //    Arrays.fill(array, null);
    }

}
