package ru.javaresume.webapp.storage.path;

import ru.javaresume.webapp.Config;
import ru.javaresume.webapp.storage.AbstractStorageTest;
import ru.javaresume.webapp.storage.PathStorage;
import ru.javaresume.webapp.storage.serializer.XmlStreamSerializer;

/**
 * Created by deadRabbit on 23.08.2016.
 */
public class XmlPathStorageTest extends AbstractStorageTest {
    public XmlPathStorageTest() {
        super(new PathStorage(Config.getStoragePath(), new XmlStreamSerializer()));
    }
}
