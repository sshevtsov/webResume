package ru.javaresume.webapp.model;

import java.util.Objects;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class TextSection extends Section {
    private static final long serialVersionUID = 1L;

    public static final TextSection EMPTY = new TextSection("");

    private String content;

    public TextSection() {
    }

    public TextSection(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
