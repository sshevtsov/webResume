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
        R1.addContact(ContactType.MAIL, "email1@mail.ru");
        R1.addContact(ContactType.PHONE, "111111");


        R1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R1.addSection(SectionType.ACHIEVEMENT, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        R1.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        R1.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization11", "http://Organization11.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content1"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        R1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", null,
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://Organization12.ru")));
        UUID1 = R1.getUuid();
    }
}


