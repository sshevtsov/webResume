package ru.javaresume.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class Resume {

    private String fullName;
    private String about;
    private List<Contact> contacts = new ArrayList<>();
    private List<Section> sections = new ArrayList<>();

    public Resume(String fullName, String about) {
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.fullName = fullName;
        this.about = about;
    }

    public void addContact(ContactType type, String value) {
        contacts.add(new Contact(type, value));
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(fullName, resume.fullName) &&
                Objects.equals(about, resume.about) &&
                Objects.equals(contacts, resume.contacts) &&
                Objects.equals(sections, resume.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, about, contacts, sections);
    }

    @Override
    public String toString() {
        return "Resume{" +
                "fullName='" + fullName + '\'' +
                ", about='" + about + '\n' +
                "contacts=" + contacts + '\n' +
                "sections=" + sections +
                '}';
    }
}
