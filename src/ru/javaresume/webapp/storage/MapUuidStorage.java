package ru.javaresume.webapp.storage;

import ru.javaresume.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by deadRabbit on 19.08.2016.
 */
public class MapUuidStorage extends AbstractStorage<String> {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected boolean exist(String uuid) {
        return map.containsKey(uuid);
    }

    @Override
    protected String getContext(String uuid) {
        return uuid;
    }

    @Override
    protected void doClear() {
        map.clear();
    }

    @Override
    protected void doSave(Resume r, String uuid) {
        map.put(uuid, r);
    }

    @Override
    protected void doUpdate(Resume r, String uuid) {
        map.put(uuid, r);
    }

    @Override
    protected Resume doGet(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doDelete(String uuid) {
        map.remove(uuid);
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
