package ru.javaresume.webapp.model;

/**
 * Created by deadRabbit on 23.07.2016.
 */
public enum SectionType {

    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    private String title;

    SectionType() {
    }

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
