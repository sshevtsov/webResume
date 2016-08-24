package ru.javaresume.webapp.storage.file;

import ru.javaresume.webapp.Config;
import ru.javaresume.webapp.storage.AbstractStorageTest;
import ru.javaresume.webapp.storage.FileStorage;
import ru.javaresume.webapp.storage.serializer.XmlStreamSerializer;
/**
 * Created by deadRabbit on 24.08.2016.
 */
public class XmlFileStorageTest extends AbstractStorageTest {
    public XmlFileStorageTest() {
        super(new FileStorage(Config.getStoragePath(), new XmlStreamSerializer()));
    }
}