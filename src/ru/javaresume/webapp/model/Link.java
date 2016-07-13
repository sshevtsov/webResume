package ru.javaresume.webapp.model;

/**
 * Created by deadRabbit on 13.07.2016.
 */
public class Link {

    String name;
    String url;

    public Link() {
    }

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String toString() {
        return "Link{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
