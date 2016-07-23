package main;

import ru.javaresume.webapp.model.*;

/**
 * Created by deadRabbit on 12.07.2016.
 */
public class Main {

    public static void main(String[] args) {

        Resume r1 = new Resume("Полное Имя1", "About1");
        r1.addContact(ContactType.MAIL, "email1@mail.ru");
        r1.addContact(ContactType.PHONE, "111111");
        r1.addSection(new TextSection(SectionType.OBJECTIVE, "Objective"));
        r1.addSection(new ListSection(SectionType.QUALIFICATIONS, "Achivement1", "Achivement2"));
        r1.addSection(new ListSection(SectionType.QUALIFICATIONS, "Java", "SQL"));

        System.out.println(r1);
    }

}
