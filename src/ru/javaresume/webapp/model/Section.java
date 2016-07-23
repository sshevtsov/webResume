package ru.javaresume.webapp.model;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public abstract class Section {

    private final SectionType type;

    protected Section(SectionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Section(" + type + ")";
    }
}
