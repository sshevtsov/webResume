package ru.javaresume.webapp.storage;

import ru.javaresume.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import static java.util.Objects.requireNonNull;

/**
 * Created by deadRabbit on 08.08.2016.
 */
public class SortedArrayStorageImpl extends AbstractArrayStorageImpl {

    @Override
    public void save(Resume r) {
        requireNonNull(r, "Resume must not be null");
        int idx = getIndex(r.getUuid());
        if (idx > 0) {
            throw new IllegalArgumentException("Resume " + r.getUuid() + "alredy exist");
        }
        if (size == ARRAY_LIMIT) {
            throw new IllegalStateException("Max storage volume " + ARRAY_LIMIT + " is exceeded");
        }
        int insertIdx = idx -1;
        System.arraycopy(array, insertIdx, array, insertIdx + 1, size - insertIdx);
        array[idx] = r;
        size++;
    }

    @Override
    public void delete(String uuid) {
        requireNonNull(uuid);
        int idx = getExistedIndex(uuid);
        int numMoved = size - idx - 1;
        if (numMoved > 0) {
            System.arraycopy(array, idx + 1, array, idx, numMoved);
        }
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

    protected int getIndex(String uuid) {
        return Arrays.binarySearch(array, 0, size, new Resume(uuid, "", null), new Comparator<Resume>() {
            @Override
            public int compare(Resume r1, Resume r2) {
                return r1.getUuid().compareTo(r2.getUuid());
            }
        });
    }
}
