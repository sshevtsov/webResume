package ru.javaresume.webapp.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * Created by deadRabbit on 23.08.2016.
 */
public class LocalDateAdapter  extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String str) throws Exception {
        return LocalDate.parse(str);
    }

    @Override
    public String marshal(LocalDate ld) throws Exception {
        return ld.toString();
    }
}