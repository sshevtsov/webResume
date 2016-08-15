package ru.javaresume.webapp.storage;

import ru.javaresume.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by deadRabbit on 08.08.2016.
 */
public class SortedArrayStorage extends AbstractArrayStorage {


    @Override
    protected int getIndex(String uuid) {
        return Arrays.binarySearch(array, 0, size, new Resume(uuid, "", null), new Comparator<Resume>() {
            @Override
            public int compare(Resume o1, Resume o2) {
                return o1.getUuid().compareTo(o2.getUuid());
            }
        });
    }

    @Override
    protected void shiftDeleted(String uuid, int idx) {
        int numMoved = size - idx - 1;
        if (numMoved > 0) {
            System.arraycopy(array, idx + 1, array, idx, numMoved);
        }
    }

    @Override
    protected void insert(Resume r, int idx) {
        int insertIdx = -idx -1;
        System.arraycopy(array, insertIdx, array, insertIdx + 1, size - insertIdx);
        array[insertIdx] = r;
    }
}
