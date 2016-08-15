package ru.javaresume.webapp.storage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.javaresume.webapp.model.*;

import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by deadRabbit on 12.08.2016.
 */
public class AbstractStorageTest {

    private Resume r1;
    private Storage storage = new SortedArrayStorage();

    {
        r1 = new Resume("Full Name", "about");
        r1.addContact(ContactType.MAIL, "email1@mail.ru");
        r1.addContact(ContactType.PHONE, "111111");
        r1.addSection(new TextSection(SectionType.OBJECTIVE, "Objective"));
        r1.addSection(new ListSection(SectionType.QUALIFICATIONS, "Achivement1", "Achivement2"));
        r1.addSection(new ListSection(SectionType.QUALIFICATIONS, "Java", "SQL"));
        r1.addSection(
                new OrganizationSection(SectionType.EXPERIENCE,
                        new Organization("Organization1", null,
                                new Position(2005, Month.JANUARY, "position1", "content1"),
                                new Position(2001, Month.MARCH, 2005, Month.APRIL, "position2", "content2"))));


    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(r1);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testLoad() throws Exception {
        assertTrue(storage.size() == 1);
        storage.get(r1.getUuid());
        //assertGetResume(r1);
    }

    private void assertGetResume(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }
}