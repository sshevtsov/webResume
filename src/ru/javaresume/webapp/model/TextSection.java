package ru.javaresume.webapp.model;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class TextSection extends Section{

    private String content;

    public TextSection(String content) {
        super("TextSection");
        this.content = content;
    }
}
