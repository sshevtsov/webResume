package ru.javaresume.webapp.storage;

import ru.javaresume.webapp.ResumeStorageException;
import ru.javaresume.webapp.model.Resume;
import ru.javaresume.webapp.storage.serializer.StreamSerializer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class PathStorage extends AbstractIOStorage<Path> {
    private final Path directory;

    public PathStorage(String Path, StreamSerializer streamSerializer) {
        super(streamSerializer);
        directory = Paths.get(Path);
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(Path + " is not directory or is not writable");
        }
    }

    @Override
    protected Path getContext(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected boolean exist(Path path) {
        return Files.isRegularFile(path);
    }

    @Override
    protected void doClear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new ResumeStorageException(null, "Path delete error");
        }
    }

    @Override
    protected void doSave(Resume r, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new ResumeStorageException(r.getUuid(), "Path " + path + " already exist");
        }
        doUpdate(r, path);
    }

    @Override
    protected void doUpdate(Resume r, Path path) {
        try {
            write(r, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new ResumeStorageException(r.getUuid(), "Path write error", e);
        }
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return read(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new ResumeStorageException(path.getFileName().toString(), "Path read error", e);
        }
    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new ResumeStorageException(path.getFileName().toString(), "Path delete error");
        }
    }

    @Override
    protected List<Resume> getAll() {
        try {
            return Files.list(directory).map(this::doGet).collect(Collectors.toList());
        } catch (IOException e) {
            throw new ResumeStorageException(null, "Directory read error");
        }
    }

    @Override
    public int getSize() {
        try {
            return Files.list(directory).collect(Collectors.counting()).intValue();
        } catch (IOException e) {
            throw new ResumeStorageException(null, "Directory read error");
        }
    }
}