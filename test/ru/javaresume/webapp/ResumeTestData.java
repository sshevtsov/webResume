package ru.javaresume.webapp;

import ru.javaresume.webapp.model.*;

import java.time.Month;

/**
 * Created by deadRabbit on 16.08.2016.
 */
public class ResumeTestData {

    public static Resume R1;
    public static Resume R2;
    public static Resume R3;

    public static String UUID1;

    public static void init() {
        R1 = new Resume("Полное Имя1", "About1");
        R2 = new Resume("Полное Имя2", "About2");
        R3 = new Resume("Полное Имя3", "About3");
        R1.addContact(ContactType.MAIL, "mail1@ya.ru");
        R1.addContact(ContactType.PHONE, "11111");
        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(ContactType.PHONE, "22222");


        R1 = new Resume("Full Name", "about");
        R1.addContact(ContactType.MAIL, "email1@mail.ru");
        R1.addContact(ContactType.PHONE, "111111");
        R1.addSection(new TextSection(SectionType.OBJECTIVE, "Objective"));
        R1.addSection(new ListSection(SectionType.QUALIFICATIONS, "Achivement1", "Achivement2"));
        R1.addSection(new ListSection(SectionType.QUALIFICATIONS, "Java", "SQL"));
        R1.addSection(
                new OrganizationSection(SectionType.EXPERIENCE,
                        new Organization("Organization1", null,
                                new Position(2005, Month.JANUARY, "position1", "content1"),
                                new Position(2001, Month.MARCH, 2005, Month.APRIL, "position2", "content2"))));


        UUID1 = R1.getUuid();
    }
}


