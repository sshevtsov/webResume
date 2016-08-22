package ru.javaresume.webapp.storage.serializer;

import ru.javaresume.webapp.model.*;
import ru.javaresume.webapp.util.XmlParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
/**
 * Created by deadRabbit on 23.08.2016.
 */
public class XmlStreamSerializer implements StreamSerializer {
    private XmlParser xmlParser;

    public XmlStreamSerializer() {
        xmlParser = new XmlParser(
                Resume.class, Organization.class, Link.class,
                OrganizationSection.class, TextSection.class, ListSection.class, Organization.Position.class);
    }

    @Override
    public void write(Resume r, OutputStream os) throws IOException {
        try (Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            xmlParser.marshall(r, w);
        }
    }

    @Override
    public Resume read(InputStream is) throws IOException {
        try (Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return xmlParser.unmarshall(r);
        }
    }
}
