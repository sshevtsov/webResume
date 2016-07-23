package ru.javaresume.webapp.model;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class Contact {

    private final ContactType type;
    private String value;

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + type + " - " + value + ")";
    }
}
