package main;

import ru.javaresume.webapp.model.Link;
import ru.javaresume.webapp.storage.MapStorageImpl;
import ru.javaresume.webapp.storage.Storage;

/**
 * Created by deadRabbit on 12.07.2016.
 */
public class Main {

    public static void main(String[] args) {

        Link link = new Link("name", "url");
        System.out.println(link.toString());

        Storage storage = new MapStorageImpl();
        storage.getClass();

    }

}
