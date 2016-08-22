package ru.javaresume.webapp.storage;

import ru.javaresume.webapp.ResumeStorageException;
import ru.javaresume.webapp.model.Resume;
import ru.javaresume.webapp.storage.serializer.StreamSerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage extends AbstractIOStorage<File> {
    private final File directory;

    public FileStorage(String file, StreamSerializer streamSerializer) {
        super(streamSerializer);
        directory = new File(file);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(file + " is not directory");
        }
    }

    @Override
    protected File getContext(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean exist(File file) {
        return file.isFile();
    }

    @Override
    protected void doClear() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                doDelete(file);
            }
        }
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            if (!file.createNewFile()) {
                throw new ResumeStorageException(r.getUuid(), "File " + file.getAbsolutePath() + " already exist");
            }
        } catch (IOException e) {
            throw new ResumeStorageException(r.getUuid(), "Couldn't create file " + file.getAbsolutePath(), e);
        }
        doUpdate(r, file);
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        try {
            write(r, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new ResumeStorageException(r.getUuid(), "File write error", e);
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return read(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new ResumeStorageException(file.getName(), "File read error", e);
        }
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new ResumeStorageException(file.getName(), "File delete error");
        }
    }

    @Override
    protected List<Resume> getAll() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new ResumeStorageException(null, "Directory read error");
        }
        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) {
            list.add(doGet(file));
        }
        return list;
    }

    @Override
    public int getSize() {
        String[] list = directory.list();
        if (list == null) {
            throw new ResumeStorageException(null, "Directory read error");
        }
        return list.length;
    }
}