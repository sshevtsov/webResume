package ru.javaresume.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.javaresume.webapp.storage.file.DataStreamFileStorageTest;
import ru.javaresume.webapp.storage.file.XmlFileStorageTest;
import ru.javaresume.webapp.storage.path.JsonPathStorageTest;
import ru.javaresume.webapp.storage.path.ObjectStreamPathStorageTest;
import ru.javaresume.webapp.storage.path.XmlPathStorageTest;

/**
 * Created by deadRabbit on 24.08.2016.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ArrayStorageTest.class,
                SortedArrayStorageTest.class,
                ListStorageTest.class,
                MapResumeStorageTest.class,
                MapUuidStorageTest.class,
                DataStreamFileStorageTest.class,
                ObjectStreamPathStorageTest.class,
                JsonPathStorageTest.class,
                XmlFileStorageTest.class,
                XmlPathStorageTest.class,
                //SqlStorageTest.class
        })
public class AllStorageTests {
}
