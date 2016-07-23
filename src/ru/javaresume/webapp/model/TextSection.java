package ru.javaresume.webapp.model;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class TextSection extends Section{

    private String content;

    public TextSection(SectionType type, String content) {
        super(type);
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextSection(" + content + ")";
    }
}
