package ru.javaresume.webapp.storage.path;

import ru.javaresume.webapp.Config;
import ru.javaresume.webapp.storage.AbstractStorageTest;
import ru.javaresume.webapp.storage.PathStorage;
import ru.javaresume.webapp.storage.serializer.ObjectStreamSerializer;

/**
 * Created by deadRabbit on 24.08.2016.
 */
public class ObjectStreamPathStorageTest extends AbstractStorageTest {
    public ObjectStreamPathStorageTest() {
        super(new PathStorage(Config.getStoragePath(), new ObjectStreamSerializer()));
    }
}
