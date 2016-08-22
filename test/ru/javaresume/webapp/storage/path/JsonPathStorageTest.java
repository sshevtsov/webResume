package ru.javaresume.webapp.storage.path;

import ru.javaresume.webapp.Config;
import ru.javaresume.webapp.storage.AbstractStorageTest;
import ru.javaresume.webapp.storage.PathStorage;
import ru.javaresume.webapp.storage.serializer.JsonStreamSerializer;

/**
 * Created by deadRabbit on 23.08.2016.
 */
public class JsonPathStorageTest extends AbstractStorageTest {
    public JsonPathStorageTest() {
        super(new PathStorage(Config.getStoragePath(), new JsonStreamSerializer()));
    }
}