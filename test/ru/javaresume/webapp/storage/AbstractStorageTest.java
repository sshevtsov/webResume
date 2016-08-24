package ru.javaresume.webapp.storage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.javaresume.webapp.ResumeStorageException;
import ru.javaresume.webapp.ResumeTestData;
import ru.javaresume.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by deadRabbit on 24.08.2016.
 */
public abstract class AbstractStorageTest {

    private final Storage storage;

    public AbstractStorageTest(Storage storage) {
        requireNonNull(storage, "Storage must not be null");
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        ResumeTestData.init();
        storage.save(ResumeTestData.R1);
        storage.save(ResumeTestData.R2);
        storage.save(ResumeTestData.R3);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testClear() throws Exception {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void testSize() throws Exception {
        assertSize(3);
    }

    @Test
    public void testUpdate() throws Exception {
        ResumeTestData.R2.setFullName("Updated N2");
        storage.update(ResumeTestData.R2);
        assertGet(ResumeTestData.R2);
    }

    @Test(expected = ResumeStorageException.class)
    public void testUpdateMissed() throws Exception {
        Resume resume = new Resume("missedUuid", "fullName_U1", "about");
        storage.update(resume);
    }

    @Test
    public void testGet() throws Exception {
        assertGet(ResumeTestData.R1);
        assertGet(ResumeTestData.R2);
        assertGet(ResumeTestData.R3);
    }

    @Test(expected = ResumeStorageException.class)
    public void testSaveAlreadyExist() throws Exception {
        storage.save(ResumeTestData.R1);
    }

    @Test
    public void testDelete() throws Exception {
        storage.delete(ResumeTestData.R1.getUuid());
        assertSize(2);
        assertGet(ResumeTestData.R2);
        assertGet(ResumeTestData.R3);
    }

    @Test(expected = ResumeStorageException.class)
    public void testGetNotFound() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = ResumeStorageException.class)
    public void testDeleteNotFound() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void testGetAllSorted() throws Exception {
        List<Resume> list = Arrays.asList(ResumeTestData.R1, ResumeTestData.R2, ResumeTestData.R3);
        assertEquals(list, new ArrayList<>(storage.getAllSorted()));
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}