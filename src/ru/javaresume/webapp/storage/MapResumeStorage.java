package ru.javaresume.webapp.storage;

import ru.javaresume.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by deadRabbit on 19.08.2016.
 */
public class MapResumeStorage extends AbstractStorage<Resume> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected boolean exist(Resume resume) {
        return resume != null;
    }

    @Override
    protected Resume getContext(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doClear() {
        map.clear();
    }

    @Override
    protected void doSave(Resume r, Resume nullResume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
    }

    @Override
    protected void doDelete(Resume resume) {
        map.remove(resume.getUuid());
    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int getSize() {
        return map.size();
    }
}
